package com.example.contractcrud.dto;

public class ContractResponseDto {
    private Long id;
    private String contractNumber;
    private String partnerName;
    private String state;

    public ContractResponseDto() {}

    public ContractResponseDto(Long id, String contractNumber, String partnerName, String state) {
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
