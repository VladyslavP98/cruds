package com.example.contractcrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String contractNumber;

    @Column(nullable = false, length = 120)
    private String partnerName;

    @Column(nullable = false, length = 60)
    private String state;

    public Contract() {}

    public Contract(Long id, String contractNumber, String partnerName, String state) {
        this.id = id;
        this.contractNumber = contractNumber;
        this.partnerName = partnerName;
        this.state = state;
    }

    public Long getId() { return id; }
    public String getContractNumber() { return contractNumber; }
    public String getPartnerName() { return partnerName; }
    public String getState() { return state; }
    public void setId(Long id) { this.id = id; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }
    public void setState(String state) { this.state = state; }
}
