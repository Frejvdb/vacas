package lasvacas.models;

import java.util.Date;

public class PersonalAdventureVaca extends Vaca {
    public PersonalAdventureVaca(int id, String title, String description, double goalAmount, Date startDate, Date endDate) {
        super(id, title, description, goalAmount, startDate, endDate);
    }
}
