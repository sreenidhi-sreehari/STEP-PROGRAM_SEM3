import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;

    private String deviceName;
    private boolean isEnabled;

    private final LocalDateTime startupTime;
    private int hashedEncryptionKey;
    private int hashedAdminPassword;

    public SmartDevice(String deviceName) {
        this.deviceId = UUID.randomUUID().toString();
        this.manufacturingDate = LocalDateTime.now();
        this.serialNumber = "SN-" + System.currentTimeMillis();
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.isEnabled = true;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public long getUptime() {
        return ChronoUnit.SECONDS.between(startupTime, LocalDateTime.now());
    }

    public int getDeviceAge() {
        return (int) ChronoUnit.DAYS.between(manufacturingDate, LocalDateTime.now());
    }

    public void setEncryptionKey(String key) {
        this.hashedEncryptionKey = key.hashCode();
    }

    public void setAdminPassword(String password) {
        this.hashedAdminPassword = password.hashCode();
    }

    public boolean validateEncryptionKey(String key) {
        return this.hashedEncryptionKey == key.hashCode();
    }

    public boolean validateAdminPassword(String password) {
        return this.hashedAdminPassword == password.hashCode();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Map<String, String> getPropertyInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("deviceId", "Read-Only");
        info.put("manufacturingDate", "Read-Only");
        info.put("serialNumber", "Read-Only");
        info.put("uptime", "Computed Read-Only");
        info.put("deviceAge", "Computed Read-Only");
        info.put("encryptionKey", "Write-Only");
        info.put("adminPassword", "Write-Only");
        info.put("deviceName", "Read-Write");
        info.put("isEnabled", "Read-Write");
        return info;
    }

    public void resetDevice() {
        this.hashedEncryptionKey = 0;
        this.hashedAdminPassword = 0;
    }

    public static void main(String[] args) {
        SmartDevice device1 = new SmartDevice("Thermostat");
        System.out.println("Device ID: " + device1.getDeviceId());
        System.out.println("Manufacturing Date: " + device1.getManufacturingDate());
        System.out.println("Serial Number: " + device1.getSerialNumber());
        System.out.println("Uptime: " + device1.getUptime() + " seconds");
        System.out.println("Device Age: " + device1.getDeviceAge() + " days");

        device1.setEncryptionKey("secureKey123");
        device1.setAdminPassword("adminPass!");
        System.out.println("Encryption key valid: " + device1.validateEncryptionKey("secureKey123"));
        System.out.println("Admin password valid: " + device1.validateAdminPassword("adminPass!"));

        System.out.println("Device Name: " + device1.getDeviceName());
        device1.setDeviceName("Smart Thermostat");
        System.out.println("Updated Device Name: " + device1.getDeviceName());

        System.out.println("Enabled: " + device1.isEnabled());
        device1.setEnabled(false);
        System.out.println("Enabled after update: " + device1.isEnabled());

        System.out.println("Property Info: " + device1.getPropertyInfo());

        SmartDevice device2 = new SmartDevice("Camera");
        System.out.println("Second Device ID: " + device2.getDeviceId());
        System.out.println("Second Device Name: " + device2.getDeviceName());
    }
}
