package edu.oda.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TypesOfLoans {
    private String codeType;
    private String clientId;
    private double amount;
    private String dateOfIssue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TypesOfLoans() {
    }

    public TypesOfLoans(double amount, String dateOfIssue) {
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
    }

    public TypesOfLoans(String codeType, String clientId, double amount, String dateOfIssue, LocalDateTime createdAt,
                        LocalDateTime updatedAt) {
        this.codeType = codeType;
        this.clientId = clientId;
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypesOfLoans that = (TypesOfLoans) o;
        return getCodeType().equals(that.getCodeType()) && getClientId().equals(that.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeType(), getClientId());
    }

    @Override
    public String toString() {
        return "TypesOfLoans{" +
                "codeType='" + codeType + '\'' +
                ", clientId='" + clientId + '\'' +
                ", amount='" + amount + '\'' +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
