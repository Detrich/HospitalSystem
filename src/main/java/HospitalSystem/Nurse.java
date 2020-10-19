package HospitalSystem;

public class Nurse extends Employee {
    private String numberofpatients;

    public String getNumberofpatients() {
        return this.numberofpatients;
    }

    public void setNumberofpatients(String Speciality) {
        this.numberofpatients = Speciality;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Blazerid: " + getBlazerID() +
                ", Number of patients: " + numberofpatients;
    }
}
