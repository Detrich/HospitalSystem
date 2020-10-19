package HospitalSystem;

public class Surgeon extends Employee {
    private String operating;
    private String department;

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String getOperating() {
        return this.operating;
    }

    public void setOperating(String Operating) {
        this.operating = Operating;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Blazerid: " + getBlazerID() +
                ", Department: " + department +
                ", Answering: " + operating;
    }
}
