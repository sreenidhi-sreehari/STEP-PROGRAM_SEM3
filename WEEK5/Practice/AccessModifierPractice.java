class AccessModifierDemo {
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
}

class ExtendedDemo extends AccessModifierDemo {
    public ExtendedDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        super(privateField, defaultField, protectedField, publicField);
    }

    public void testInheritedAccess() {
        System.out.println(protectedField);
        System.out.println(publicField);

        protectedMethod();
        publicMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in ExtendedDemo");
    }
}

public class AccessModifierPractice {
    public static void main(String[] args) {
        AccessModifierDemo parent = new AccessModifierDemo(10, "Hello", 20.5, true);
        parent.publicMethod();

        ExtendedDemo child = new ExtendedDemo(5, "World", 15.5, false);
        child.testInheritedAccess();
    }
}
