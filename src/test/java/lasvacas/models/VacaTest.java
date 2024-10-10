package lasvacas.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacaTest {

    @Test
    public void testGetTitle() {
        // Setup
        Vaca vaca = new CommunityProjectVaca(1, "Community Park", "Fundraising for a new park", 10000.0, 
                new java.util.Date(), new java.util.Date());
        
        // Assertion
        assertEquals("Community Park", vaca.getTitle());

        // Print something to console
        System.out.println("Test for getTitle() passed!");
    }

    @Test
    public void testGetDescription() {
        // Setup
        Vaca vaca = new CommunityProjectVaca(1, "Community Park", "Fundraising for a new park", 10000.0, 
                new java.util.Date(), new java.util.Date());
        
        // Assertion
        assertEquals("Fundraising for a new park", vaca.getDescription());

        // Print something to console
        System.out.println("Test for getDescription() passed!");
    }
}
