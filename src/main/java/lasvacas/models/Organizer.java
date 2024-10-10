package lasvacas.models;

import java.util.ArrayList;
import java.util.List;

public class Organizer extends User {
    private List<Vaca> vacas;

    public Organizer(String email, String password, String name) {
        super(email, password, name);
        this.vacas = new ArrayList<>();
    }

    public void createVaca(Vaca vaca) {
        vacas.add(vaca);
    }

    public List<Vaca> getVacas() {
        return vacas;
    }
}
