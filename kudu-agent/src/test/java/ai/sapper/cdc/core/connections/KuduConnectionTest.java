package ai.sapper.cdc.core.connections;

import ai.sapper.cdc.common.utils.DefaultLogger;
import ai.sapper.core.walcdc.WALCDCEnv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KuduConnectionTest {
    private static final String CONFIG_FILE = "src/test/resources/connection-test.xml";
    @Test
    void connect() {
        try {
        } catch (Exception ex) {
            DefaultLogger.LOG.debug(DefaultLogger.stacktrace(ex));
            fail(ex);
        }
    }
}