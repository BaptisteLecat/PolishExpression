package entity;

public class User {
    private int id;
    private String name;
    private String firstName;
    private String email;

    public User(int id, String name, String firstName, String email){
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}
