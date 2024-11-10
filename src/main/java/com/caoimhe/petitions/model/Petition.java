// src/main/java/com/<your_first_name>/spetitions/model/Petition.java
package com.caoimhe.petitions.model;

public class Petition {
    private Long id;
    private String title;
    private String description;
    private int signatureCount;

    public Petition(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.signatureCount = 0;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSignatureCount() {
        return signatureCount;
    }

    public void setSignatureCount(int signatureCount) {
        this.signatureCount = signatureCount;
    }
}
