package com.example.contractcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContractRequestDto {
    @NotBlank
    @Size(max = 120)
    private String contractNumber;

    @NotBlank
    @Size(max = 120)
    private String partnerName;

    @NotBlank
    @Size(max = 60)
    private String state;

    public ContractRequestDto() {}

    public String getContractNumber() { return contractNumber; }
    public String getPartnerName() { return partnerName; }
    public String getState() { return state; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }
    public void setState(String state) { this.state = state; }
}
