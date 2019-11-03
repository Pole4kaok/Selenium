package model;

public class PersonModel{
    private String firstName;
    private String lastName;
    private String line1;
    private String country;

    public PersonModel(String firstName, String lastName, String line1, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.line1 = line1;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getLine1(){
        return line1;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }
}
