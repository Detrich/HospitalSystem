package HospitalSystem;

public class Doctor extends Employee {
    private String speciality;

    public void setSpeciality(String Speciality) {
        this.speciality = Speciality;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Blazerid: " + getBlazerID() +
                ", Speciality: " + speciality;
    }
}
