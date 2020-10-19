package HospitalSystem;

public class Receptionist extends Employee {
    private String answering;
    private String department;

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String getAnswering() {
        return this.answering;
    }

    public void setAnswering(String Answering) {
        this.answering = Answering;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Blazerid: " + getBlazerID() +
                ", Department: " + department +
                ", Answering: " + answering;
    }
}
