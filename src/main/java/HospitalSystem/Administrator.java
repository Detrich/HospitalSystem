package HospitalSystem;

public class Administrator extends Employee {
    private String department;

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Blazerid: " + getBlazerID() +
                ", Department: " + department;
    }
}
