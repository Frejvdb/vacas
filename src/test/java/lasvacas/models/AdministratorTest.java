package lasvacas.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class AdministratorTest {

    private User mockUser;
    private Administrator admin;

    @BeforeEach
    public void setUp() {
        mockUser = mock(User.class);
        admin = new Administrator("admin@example.com", "password", "Admin Name");
    }

    @Test
    public void testDeactivateUser() {
        // Call the method to test
        admin.deactivateUser(mockUser);

        // Verify that the lockAccount method was called on the mockUser
        verify(mockUser).lockAccount();
    }

}