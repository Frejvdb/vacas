package lasvacas.services;

import java.util.HashMap;
import java.util.Map;

import lasvacas.exceptions.AuthenticationException;
import lasvacas.models.User;

public class AuthenticationService {
    private Map<String, User> users;
    private Map<String, Integer> failedAttempts;

    public AuthenticationService() {
        this.users = new HashMap<>();
        this.failedAttempts = new HashMap<>();
    }

    public void registerUser(User user) throws AuthenticationException {
        // Use the getEmail() method instead of accessing the email field directly
        if (users.containsKey(user.getEmail())) {
            throw new AuthenticationException("Email already registered.");
        }
        // Use the getPassword() method instead of accessing the password field directly
        if (!validatePassword(user.getPassword())) {
            throw new AuthenticationException("Password does not meet complexity requirements.");
        }
        users.put(user.getEmail(), user);  // Use getEmail() method here as well
        // Deliberate Fault: Missing email verification step
    }

    public User login(String email, String password) throws AuthenticationException {
        User user = users.get(email);
        if (user == null) {
            throw new AuthenticationException("User not found.");
        }
        if (user.isLocked()) {
            throw new AuthenticationException("Account is locked.");
        }
        if (!user.authenticate(password)) {
            int attempts = failedAttempts.getOrDefault(email, 0) + 1;
            failedAttempts.put(email, attempts);
            if (attempts >= 5) {
                user.lockAccount();
            }
            throw new AuthenticationException("Invalid credentials.");
        }
        failedAttempts.put(email, 0);
        return user;
    }

    private boolean validatePassword(String password) {
        return password.length() >= 8;
    }
}
