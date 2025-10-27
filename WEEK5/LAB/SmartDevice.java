import java.time.LocalDateTime;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;
    private String deviceName;
    private boolean isEnabled;
    private LocalDateTime startupTime;
    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    public SmartDevice(String name) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = UUID.randomUUID().toString();
        this.deviceName = name;
        this.startupTime = LocalDateTime.now();
        this.isEnabled = true;
    }

    public String getDeviceId() { return deviceId; }
    public LocalDateTime getManufacturingDate() { return manufacturingDate; }
    public String getSerialNumber() { return serialNumber; }
    public long getUptime() { return java.time.Duration.between(startupTime, LocalDateTime.now()).toSeconds(); }
    public int getDeviceAge() { return LocalDateTime.now().getYear() - manufacturingDate.getYear(); }

    public void setEncryptionKey(String key) { hashedEncryptionKey = key.hashCode(); }
    public void setAdminPassword(String pwd) { hashedAdminPassword = pwd.hashCode(); }

    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String name) { deviceName = name; }
    public boolean isEnabled() { return isEnabled; }
    public void setEnabled(boolean en) { isEnabled = en; }

    public static void main(String[] args) {
        SmartDevice dev = new SmartDevice("Alpha");
        dev.setEncryptionKey("key123");
        dev.setAdminPassword("admin123");
        System.out.println("Device: " + dev.getDeviceName() + ", ID: " + dev.getDeviceId());
        System.out.println("Uptime(sec): " + dev.getUptime() + ", Age: " + dev.getDeviceAge());
    }
}
