public class Student extends Person {
    private double marks;

    public Student(int id, String name, double marks) {
        super(id, name);
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Marks: " + marks);
        System.out.println("Result: " +
                (marks >= 40 ? "Pass" : "Fail"));
    }
}