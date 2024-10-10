package lasvacas.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Vaca {
    protected int id; 
    protected String title;
    protected String description;
    protected double goalAmount;
    protected Date startDate;
    protected Date endDate;
    protected String status;
    protected double totalDonations;
    protected Map<String, Double> compensationLevels;
    protected Map<Donor, Double> contributions;
     

    public Vaca(int id, String title, String description, double goalAmount, Date startDate, Date endDate) {
        this.id = id; 
        this.title = title;
        this.description = description;
        this.goalAmount = goalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
        this.totalDonations = 0;
        this.compensationLevels = new HashMap<>();
        this.contributions = new HashMap<>();
    }

    public int getId() {  
        return id;
    }

    public void addCompensationLevel(String reward, double amount) {
        compensationLevels.put(reward, amount);
    }

    public void receiveContribution(Donor donor, double amount) {
        contributions.put(donor, amount);
        totalDonations += amount; 
    }

    public double getTotalDonations() {
        return totalDonations;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    public Donor findDonorById(int donorId) {
        for (Donor donor : contributions.keySet()) {
            if (donor.getId() == donorId) {  
                return donor;
            }
        }
        return null; 
    }
}
