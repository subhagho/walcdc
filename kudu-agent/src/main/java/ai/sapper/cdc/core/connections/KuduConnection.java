package ai.sapper.cdc.core.connections;

import ai.sapper.cdc.common.ConfigReader;
import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;
import org.apache.kudu.client.KuduClient;

import java.io.IOException;

@Getter
@Accessors(fluent = true)
public class KuduConnection implements Connection {
    @Getter(AccessLevel.NONE)
    protected final ConnectionState state = new ConnectionState();
    private KuduConnectionConfig config;
    private KuduClient client;

    @Override
    public String name() {
        return config.name;
    }

    @Override
    public Connection init(@NonNull HierarchicalConfiguration<ImmutableNode> xmlConfig) throws ConnectionError {
        synchronized (state) {
            try {
                config = new KuduConnectionConfig(xmlConfig);
                config.read();

                client = new KuduClient.KuduClientBuilder(config.masters).build();

                state.state(EConnectionState.Initialized);
                return this;
            } catch (Exception ex) {
                state.error(ex);
                throw new ConnectionError(ex);
            }
        }
    }

    @Override
    public Connection connect() throws ConnectionError {
        if (state.state() != EConnectionState.Initialized) {
            throw new ConnectionError(
                    String.format("Failed to connect: invalid state [state=%s]", state.state().name()));
        }
        state.state(EConnectionState.Connected);
        return this;
    }

    @Override
    public Throwable error() {
        return state.error();
    }

    @Override
    public EConnectionState connectionState() {
        return state.state();
    }

    @Override
    public boolean isConnected() {
        return state.isConnected();
    }

    @Override
    public HierarchicalConfiguration<ImmutableNode> config() {
        return config.config();
    }

    @Override
    public void close() throws IOException {
        if (!state.hasError()) {
            state.state(EConnectionState.Closed);
        }
        if (client != null) {
            client.close();
            client = null;
        }
    }

    public static class KuduConnectionConfig extends ConfigReader {
        public static class Constants {
            public static final String __CONFIG_PATH = "kudu";
            public static final String CONFIG_MASTERS = "masters";
            public static final String CONFIG_NAME = "name";
        }

        private String name;
        private String masters;

        public KuduConnectionConfig(@NonNull HierarchicalConfiguration<ImmutableNode> config) {
            super(config, Constants.__CONFIG_PATH);
        }

        public void read() throws ConfigurationException {
            if (get() == null) {
                throw new ConfigurationException("Configuration not initialized...");
            }
            name = get().getString(Constants.CONFIG_NAME);
            if (Strings.isNullOrEmpty(name)) {
                throw new ConfigurationException(
                        String.format("Kudu Configuration: missing value [name=%s]", Constants.CONFIG_NAME));
            }
            masters = get().getString(Constants.CONFIG_MASTERS);
            if (Strings.isNullOrEmpty(masters)) {
                throw new ConfigurationException(
                        String.format("Kudu Configuration: missing value [name=%s]", Constants.CONFIG_MASTERS));
            }
        }
    }
}
