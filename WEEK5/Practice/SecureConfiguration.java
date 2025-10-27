import java.util.*;
import java.time.LocalDateTime;

public class SecureConfiguration {
    public static final String APPLICATION_NAME = "MyApp";
    public static final String VERSION = "1.0";
    public static final int MAX_CONNECTIONS = 100;

    private final String configId;
    private final LocalDateTime creationTime;
    private final Set<String> allowedOperations;
    private final Map<String, String> serverSettings;

    public SecureConfiguration(String id, Set<String> operations, Map<String, String> settings) {
        this.configId = id;
        this.creationTime = LocalDateTime.now();
        this.allowedOperations = new HashSet<>(operations);
        this.serverSettings = new HashMap<>(settings);
    }

    public String getConfigId() { return configId; }
    public LocalDateTime getCreationTime() { return creationTime; }
    public Set<String> getAllowedOperations() { return new HashSet<>(allowedOperations); }
    public Map<String, String> getServerSettings() { return new HashMap<>(serverSettings); }

    public SecureConfiguration addOperation(String op) {
        Set<String> newOps = new HashSet<>(allowedOperations);
        newOps.add(op);
        return new SecureConfiguration(configId, newOps, serverSettings);
    }

    public static void main(String[] args) {
        Map<String, String> settings = Map.of("host", "localhost", "port", "8080");
        Set<String> ops = new HashSet<>(Arrays.asList("read", "write"));

        SecureConfiguration config = new SecureConfiguration("CFG001", ops, settings);
        System.out.println("ID: " + config.getConfigId());
        System.out.println("Created: " + config.getCreationTime());
        System.out.println("Ops: " + config.getAllowedOperations());
        System.out.println("Settings: " + config.getServerSettings());

        SecureConfiguration updatedConfig = config.addOperation("delete");
        System.out.println("Updated Ops: " + updatedConfig.getAllowedOperations());
    }
}
