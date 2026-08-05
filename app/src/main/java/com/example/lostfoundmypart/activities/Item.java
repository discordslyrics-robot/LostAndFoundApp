package com.example.lostfoundmypart.activities;

import com.example.lostfoundmypart.R;

import java.io.Serializable;

public class Item implements Serializable {
    private String id;
    private String itemName;
    private String category;
    private String location;
    private String date;
    private String description;
    private String status;
    private String imageUrl;
    private String reporterName;
    private String contact;

    public Item() {
        // Required empty constructor for Firebase
    }

    public Item(String itemName, String category, String location, String date, String description, String status, String imageUrl, String reporterName, String contact) {
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.date = date;
        this.description = description;
        this.status = status;
        this.imageUrl = imageUrl;
        this.reporterName = reporterName;
        this.contact = contact;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
