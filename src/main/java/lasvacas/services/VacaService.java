package lasvacas.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lasvacas.models.Donor;
import lasvacas.models.Vaca;

public class VacaService {
    private List<Vaca> vacas;

    public VacaService() {
        this.vacas = new ArrayList<>();
    }

    public void addVaca(Vaca vaca) {
        vacas.add(vaca);
    }

    public List<Vaca> searchVacas(String keyword) {
        List<Vaca> results = new ArrayList<>();
        for (Vaca vaca : vacas) {
            if (vaca.getTitle().contains(keyword) || vaca.getDescription().contains(keyword)) {
                results.add(vaca);
            }
        }
        return results;
    }

    public Vaca findVacaById(int id) {
        for (Vaca vaca : vacas) {
            if (vaca.getId() == id) { 
                return vaca;
            }
        }
        return null; // Or throw an exception if not found
    }

    public void updateVacaStatus(Vaca vaca) {
        double progress = calculateFundingProgress(vaca);
        String status;
        if (progress == 100.0) {
            status = "Funded";
        } else if (progress >= 75.0) {
            status = "Almost Funded";
        } else {
            status = "In Progress";
        }
        vaca.setStatus(status);
    }

    public double calculateFundingProgress(Vaca vaca) {
        if (vaca.getTotalDonations() > vaca.getGoalAmount()) {
            vaca.setStatus("Funded");
            return 100.0;
        } else if (vaca.getTotalDonations() == 0) {
            return 0.0;
        } else {
            return (vaca.getTotalDonations() / vaca.getGoalAmount()) * 100;
        }
    }

    public List<Vaca> getActiveVacas() {
        List<Vaca> activeVacas = new ArrayList<>();
        Date now = new Date();
        for (Vaca vaca : vacas) {
            if (vaca.getStartDate().before(now) && vaca.getEndDate().after(now)) {
                activeVacas.add(vaca);
            }
        }
        return activeVacas;
    }
public Donor findDonorById(int donorId) {
        for (Vaca vaca : vacas) {
            Donor donor = vaca.findDonorById(donorId);
            if (donor != null) {
                return donor;
            }
        }
        return null; // Or throw an exception if not found
    }
}
