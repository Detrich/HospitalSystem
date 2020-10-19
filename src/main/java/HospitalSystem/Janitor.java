package HospitalSystem;

public class Janitor extends Employee {
    private String sweeping;
    private String department;

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String getSweeping() {
        return this.sweeping;
    }

    public void setSweeping(String Sweeping) {
        this.sweeping = Sweeping;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Blazerid: " + getBlazerID() +
                ", Department: " + department +
                ", Sweeping: " + sweeping;
    }
}