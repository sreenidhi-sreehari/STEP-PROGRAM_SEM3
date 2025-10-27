import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.lang.reflect.Method;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}

    public EmployeeBean(String employeeId, String firstName, String lastName, double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { if(salary >= 0) this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    public String getFullName() { return firstName + " " + lastName; }

    public int getYearsOfService() {
        LocalDate hire = new java.sql.Date(hireDate.getTime()).toLocalDate();
        return Period.between(hire, LocalDate.now()).getYears();
    }

    public String getFormattedSalary() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(salary);
    }

    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ");
        if(parts.length >= 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        }
    }

    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", salary=" + getFormattedSalary() +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", yearsOfService=" + getYearsOfService() +
                ", active=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return employeeId != null && employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        return employeeId != null ? employeeId.hashCode() : 0;
    }

    public static void main(String[] args) {
        EmployeeBean e1 = new EmployeeBean();
        e1.setEmployeeId("E001");
        e1.setFirstName("John");
        e1.setLastName("Doe");
        e1.setSalary(50000);
        e1.setDepartment("IT");
        e1.setHireDate(new Date(120, 0, 1));
        e1.setActive(true);

        EmployeeBean e2 = new EmployeeBean("E002", "Jane", "Smith", 60000, "HR", new Date(118, 5, 15), true);

        System.out.println(e1);
        System.out.println(e2);

        System.out.println("Full Name: " + e2.getFullName());
        System.out.println("Years of Service: " + e2.getYearsOfService());
        System.out.println("Formatted Salary: " + e2.getFormattedSalary());

        EmployeeBean[] employees = {e1, e2};
        Arrays.sort(employees, (a, b) -> Double.compare(a.getSalary(), b.getSalary()));
        System.out.println("Sorted by salary:");
        for(EmployeeBean e : employees) System.out.println(e);

        System.out.println("Active employees:");
        for(EmployeeBean e : employees) if(e.isActive()) System.out.println(e);

        JavaBeanProcessor.printAllProperties(e1);
        EmployeeBean e3 = new EmployeeBean();
        JavaBeanProcessor.copyProperties(e2, e3);
        System.out.println("Copied Employee: " + e3);
    }
}

class JavaBeanProcessor {
    public static void printAllProperties(EmployeeBean emp) {
        try {
            Method[] methods = emp.getClass().getMethods();
            for(Method m : methods) {
                if((m.getName().startsWith("get") || m.getName().startsWith("is")) && m.getParameterCount() == 0) {
                    Object value = m.invoke(emp);
                    System.out.println(m.getName() + " = " + value);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyProperties(EmployeeBean source, EmployeeBean target) {
        try {
            Method[] methods = source.getClass().getMethods();
            for(Method m : methods) {
                if(m.getName().startsWith("get") && m.getParameterCount() == 0) {
                    Object value = m.invoke(source);
                    String setterName = "set" + m.getName().substring(3);
                    try {
                        Method setter = target.getClass().getMethod(setterName, m.getReturnType());
                        setter.invoke(target, value);
                    } catch(NoSuchMethodException ignored) {}
                } else if(m.getName().startsWith("is") && m.getParameterCount() == 0) {
                    Object value = m.invoke(source);
                    String setterName = "set" + m.getName().substring(2);
                    try {
                        Method setter = target.getClass().getMethod(setterName, m.getReturnType());
                        setter.invoke(target, value);
                    } catch(NoSuchMethodException ignored) {}
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
