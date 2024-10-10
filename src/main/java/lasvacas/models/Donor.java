package lasvacas.models;

public class Donor extends User {
    private boolean isAnonymous;

    public Donor(String email, String password, String name, boolean isAnonymous) {
        super(email, password, name);
        this.isAnonymous = isAnonymous;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }
    public int getId() {
        return this.id;  // Assuming id is inherited from the User class
    }

}
