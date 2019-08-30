package day_05_ListSetMap.StudentMange;

public class Student {

    private int StudentId;

    private String name;

    private String set;

    public int getStudentId() {
        return StudentId;
    }

    public Student() {
    }

    public Student(int studentId, String name, String set) {
        StudentId = studentId;
        this.name = name;
        this.set = set;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
}
