package HospitalSystem;

public class Employee {
    private String name;
    private String blazerID;

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getBlazerID() {
        return blazerID;
    }

    public void setBlazerID(String BlazerID) {
        this.blazerID = BlazerID;
    }

    @Override
    public String toString() {
        return "name: " + name + ' ' +
                ", blazerID: " + blazerID;
    }
}
