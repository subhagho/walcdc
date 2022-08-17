package ai.sapper.core.walcdc;

import ai.sapper.cdc.core.BaseEnv;
import lombok.NonNull;
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
}
