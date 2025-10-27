import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public final class ImmutableStudent {
    private final String studentId;
    private final String name;
    private final LocalDate birthDate;
    private final List<String> courses;
    private final Map<String, Double> grades;
    private final LocalDate graduationDate;

    private ImmutableStudent(String studentId, String name, LocalDate birthDate,
                             List<String> courses, Map<String, Double> grades, LocalDate graduationDate) {
        if (studentId == null || studentId.isEmpty()) throw new IllegalArgumentException("Invalid studentId");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
        if (birthDate == null) throw new IllegalArgumentException("Birth date cannot be null");
        this.studentId = studentId;
        this.name = name;
        this.birthDate = birthDate;
        this.courses = new ArrayList<>(courses != null ? courses : Collections.emptyList());
        this.grades = new HashMap<>(grades != null ? grades : Collections.emptyMap());
        this.graduationDate = graduationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public Map<String, Double> getGrades() {
        return new HashMap<>(grades);
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public double getGPA() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double g : grades.values()) sum += g;
        return sum / grades.size();
    }

    public int getTotalCourses() {
        return courses.size();
    }

    public boolean isGraduated() {
        return graduationDate != null;
    }

    public ImmutableStudent withGraduationDate(LocalDate date) {
        return new ImmutableStudent(studentId, name, birthDate, courses, grades, date);
    }

    public ImmutableStudent withAdditionalCourse(String course) {
        List<String> newCourses = new ArrayList<>(courses);
        newCourses.add(course);
        return new ImmutableStudent(studentId, name, birthDate, newCourses, grades, graduationDate);
    }

    public ImmutableStudent withGrade(String course, double grade) {
        Map<String, Double> newGrades = new HashMap<>(grades);
        newGrades.put(course, grade);
        return new ImmutableStudent(studentId, name, birthDate, courses, newGrades, graduationDate);
    }

    public ImmutableStudent withName(String newName) {
        return new ImmutableStudent(studentId, newName, birthDate, courses, grades, graduationDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ImmutableStudent)) return false;
        ImmutableStudent other = (ImmutableStudent) obj;
        return studentId.equals(other.studentId) &&
                name.equals(other.name) &&
                birthDate.equals(other.birthDate) &&
                courses.equals(other.courses) &&
                grades.equals(other.grades) &&
                Objects.equals(graduationDate, other.graduationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, birthDate, courses, grades, graduationDate);
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", courses=" + courses +
                ", grades=" + grades +
                ", graduationDate=" + graduationDate +
                '}';
    }

    public static class Builder {
        private String studentId;
        private String name;
        private LocalDate birthDate;
        private List<String> courses = new ArrayList<>();
        private Map<String, Double> grades = new HashMap<>();
        private LocalDate graduationDate;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setCourses(List<String> courses) {
            this.courses = new ArrayList<>(courses);
            return this;
        }

        public Builder setGrades(Map<String, Double> grades) {
            this.grades = new HashMap<>(grades);
            return this;
        }

        public Builder setGraduationDate(LocalDate graduationDate) {
            this.graduationDate = graduationDate;
            return this;
        }

        public ImmutableStudent build() {
            return new ImmutableStudent(studentId, name, birthDate, courses, grades, graduationDate);
        }
    }

    public static ImmutableStudent createBasicStudent(String id, String name, LocalDate birthDate) {
        return new ImmutableStudent(id, name, birthDate, new ArrayList<>(), new HashMap<>(), null);
    }

    public static ImmutableStudent createGraduatedStudent(String id, String name, LocalDate birthDate, LocalDate graduationDate) {
        return new ImmutableStudent(id, name, birthDate, new ArrayList<>(), new HashMap<>(), graduationDate);
    }

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(Arrays.asList("Math", "Science"));
        Map<String, Double> grades = new HashMap<>();
        grades.put("Math", 95.0);
        grades.put("Science", 87.0);

        ImmutableStudent student = new ImmutableStudent("S001", "Alice", LocalDate.of(2000, 5, 15), courses, grades, null);
        System.out.println(student);

        courses.add("History");
        grades.put("History", 80.0);
        System.out.println("After modifying original collections: " + student);

        List<String> retrievedCourses = student.getCourses();
        retrievedCourses.add("Chemistry");
        System.out.println("After modifying retrieved courses: " + student);

        ImmutableStudent updated = student.withAdditionalCourse("Physics").withGrade("Physics", 92.0).withName("Alice Smith");
        System.out.println("Updated Student: " + updated);

        ImmutableStudent graduated = updated.withGraduationDate(LocalDate.of(2024, 6, 1));
        System.out.println("Graduated Student: " + graduated);

        ImmutableStudent built = new ImmutableStudent.Builder()
                .setStudentId("S002")
                .setName("Bob")
                .setBirthDate(LocalDate.of(1999, 8, 20))
                .setCourses(Arrays.asList("English", "Biology"))
                .setGrades(Map.of("English", 88.0, "Biology", 92.0))
                .build();
        System.out.println("Built Student: " + built);
    }
}
