public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    public void testInternalAccess() {
        System.out.println("Private field: " + privateField);
        System.out.println("Default field: " + defaultField);
        System.out.println("Protected field: " + protectedField);
        System.out.println("Public field: " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 20.5, true);

        System.out.println(obj.defaultField);
        System.out.println(obj.protectedField);
        System.out.println(obj.publicField);

        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();

        obj.testInternalAccess();

        System.out.println("\n--- Testing in SamePackageTest ---");
        SamePackageTest.testAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(5, "World", 15.5, false);

        System.out.println(obj.defaultField);
        System.out.println(obj.protectedField);
        System.out.println(obj.publicField);

        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();
    }
}
