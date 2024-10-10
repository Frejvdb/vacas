package lasvacas.models;

public class Administrator extends User {
    public Administrator(String email, String password, String name) {
        super(email, password, name);
    }

    public void deactivateUser(User user) {
        user.lockAccount();
    }


}
