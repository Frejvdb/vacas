package lasvacas.models;

public abstract class User {
    protected int id; 
    protected String email;
    protected String password;
    protected String name;
    protected String profilePicture;
    protected boolean isLocked = false;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void lockAccount() {
        this.isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }  
}
