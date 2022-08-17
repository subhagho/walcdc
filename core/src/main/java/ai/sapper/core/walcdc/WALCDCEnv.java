package ai.sapper.core.walcdc;

import ai.sapper.cdc.common.AbstractState;
import ai.sapper.cdc.common.ConfigReader;
import ai.sapper.cdc.core.BaseEnv;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

public class WALCDCEnv extends BaseEnv {
    @Override
    public void init(@NonNull HierarchicalConfiguration<ImmutableNode> xmlConfig,
                     @NonNull String module,
                     @NonNull String connectionsConfigPath) throws ConfigurationException {
        super.init(xmlConfig, module, connectionsConfigPath);
    }

    private static final WALCDCEnv __instance = new WALCDCEnv();

    public enum EWALEnvState {
        Unknown, Initialized, Error, Disposed
    }

    @Getter
    @Setter
    @Accessors(fluent = true)
    public static class WALEnvState extends AbstractState<EWALEnvState> {

        public WALEnvState() {
            super(EWALEnvState.Error);
        }

        public boolean isAvailable() {
            return (state() == EWALEnvState.Initialized);
        }
    }

    @Getter
    @Accessors(fluent = true)
    public static class WALEnvConfig extends ConfigReader {
        public static final String __CONFIG_PATH = "walcdc";

        public static class Constants {

        }

        private String module;

        public WALEnvConfig(@NonNull HierarchicalConfiguration<ImmutableNode> config) {
            super(config, __CONFIG_PATH);
        }

    }
}
