import java.util.Date;

public class EmployeeBean {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}
    
    public EmployeeBean(String id, String firstName, String lastName, double salary, String dept, Date hireDate, boolean active) {
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = dept;
        this.hireDate = hireDate;
        this.isActive = active;
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
    public void setActive(boolean active) { isActive = active; }
    
    public String getFullName() { return firstName + " " + lastName; }

    public static void main(String[] args) {
        EmployeeBean emp = new EmployeeBean();
        emp.setEmployeeId("E001");
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setSalary(50000);
        emp.setDepartment("IT");
        emp.setHireDate(new Date());
        emp.setActive(true);

        System.out.println(emp.getFullName() + " works in " + emp.getDepartment() + " with salary " + emp.getSalary());
    }
}
