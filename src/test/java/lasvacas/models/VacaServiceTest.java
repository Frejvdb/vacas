package lasvacas.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lasvacas.services.VacaService;

public class VacaServiceTest{
    private VacaService vacaService;

    @BeforeEach
    public void setUp(){
        vacaService = new VacaService();
        Vaca vacatest1 = new ProductLaunchVaca(1, "Vaca1", "Vaca1 description", 1000.0, new java.util.Date(), new java.util.Date());
        Vaca vacatest2 = new ProductLaunchVaca(2, "Vaca2", "Vaca2 description", 2000.0, new java.util.Date(), new java.util.Date());
        Vaca vacatest3 = new ProductLaunchVaca(3, "VacA3", "Vaca3 desc", 3000.0, new java.util.Date(), new java.util.Date());

        vacaService.addVaca(vacatest1);
        vacaService.addVaca(vacatest2);
        vacaService.addVaca(vacatest3);
    }

    @Test
    public void testSearchVacas(){
        // Test case 1: Search with an empty string, expecting 3 results
        assertEquals(3, vacaService.searchVacas("").size());
        
        // Test case 2: Search with the term "Vaca1", expecting 1 result
        assertEquals(1, vacaService.searchVacas("Vaca1").size());
        
        // Test case 3: Search with the term "description", expecting 2 results
        assertEquals(2, vacaService.searchVacas("description").size());

        // Test case 4: Search with the term "NoVaca", expecting 0 results
        assertEquals(0, vacaService.searchVacas("NoVaca").size());

        // Test case 5: Search with the term "Vaca", expectin 3 results
        assertEquals(3, vacaService.searchVacas("Vaca").size());

        // Test case 5: Search with the term "vaca1", expecting 0 result
        assertEquals(0, vacaService.searchVacas("vaca").size());
    }

    @Test
    public void testEmptyVacas(){

        vacaService = new VacaService();
        // Test case 1: Search with an empty string and empty list, expecting 0 results
        assertEquals(0, vacaService.searchVacas("").size());

        vacaService.addVaca(new ProductLaunchVaca(1, "Vaca1", "Vaca1 description", 1000.0, new java.util.Date(), new java.util.Date()));
        // Test case 2: Search with the term "Vaca1" and only one object in list, expecting 1 result
        assertEquals(1, vacaService.searchVacas("Vaca1").size());

        vacaService.addVaca(new ProductLaunchVaca(2, "Vaca2", "Vaca2 description", 2000.0, new java.util.Date(), new java.util.Date()));
        // Test case 3: Search with the term "Vaca1" and two objects in list, expecting 1 result
        assertEquals(1, vacaService.searchVacas("Vaca1").size());

        // Test case 4: Serch with a extreamly long keyword thats longer than any title or description
        assertEquals(0, vacaService.searchVacas("abcdefghijklmnopqrstxyzabcdefghijklmnopqrstuvwxyz").size());
    }
}

