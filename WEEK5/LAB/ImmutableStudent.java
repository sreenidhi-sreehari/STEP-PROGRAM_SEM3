import java.time.LocalDateTime;
import java.util.*;

public class SecureConfiguration {
    public static final String APPLICATION_NAME = "SecureApp";
    public static final String VERSION = "1.0";
    public static final int MAX_CONNECTIONS = 100;
    public static final long DEFAULT_TIMEOUT = 5000;

    private final String configId;
    private final LocalDateTime creationTime;
    private final Set<String> allowedOperations;
    private final Map<String,String> serverSettings;
    private final List<String> userPermissions;

    public SecureConfiguration(String id, Set<String> ops, Map<String,String> settings, List<String> perms) {
        this.configId = id;
        this.creationTime = LocalDateTime.now();
        this.allowedOperations = new HashSet<>(ops);
        this.serverSettings = new HashMap<>(settings);
        this.userPermissions = new ArrayList<>(perms);
    }

    public String getConfigId() { return configId; }
    public LocalDateTime getCreationTime() { return creationTime; }
    public Set<String> getAllowedOperations() { return new HashSet<>(allowedOperations); }
    public Map<String,String> getServerSettings() { return new HashMap<>(serverSettings); }
    public List<String> getUserPermissions() { return new ArrayList<>(userPermissions); }

    public void addUserPermission(String p) { if(!userPermissions.contains(p)) userPermissions.add(p); }
    public void updateServerSetting(String k, String v) { serverSettings.put(k,v); }

    public static void main(String[] args) {
        Map<String,String> settings = Map.of("host","localhost","port","8080");
        Set<String> ops = new HashSet<>(Arrays.asList("backup","restore"));
        List<String> perms = new ArrayList<>(Arrays.asList("READ","WRITE"));
        SecureConfiguration cfg = new SecureConfiguration("CFG01", ops, settings, perms);
        System.out.println("Config ID: " + cfg.getConfigId() + ", Host: " + cfg.getServerSettings().get("host"));
        cfg.addUserPermission("DELETE");
        System.out.println("Permissions: " + cfg.getUserPermissions());
    }
}
