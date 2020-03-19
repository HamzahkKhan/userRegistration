package addUser;

public class User {

    String email, name;

    public User(String name, String email) {
        this.email = email;
        this.name=name;
    }

    public String getEmail() {
        return email;
    }
    
     public String getName() {
        return name;
    }
}
