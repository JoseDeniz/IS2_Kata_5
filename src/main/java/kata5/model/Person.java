package kata5.model;

public class Person {

    private final Mail mail;
    private final int phoneNumber;
    private final String name;

    public Person(String name, Mail mail, int phoneNumber) {
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Mail getMail() {
        return mail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
