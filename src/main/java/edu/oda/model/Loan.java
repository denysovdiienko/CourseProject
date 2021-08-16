package edu.oda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Loan {
    @Id
    private String id;
    private String codeType;
    private double amount;
    private String dateOfIssue;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return getId().equals(loan.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Loan(String codeType, double amount, String dateOfIssue, String description) {
        this.codeType = codeType;
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "id='" + id + '\'' +
                ", codeType='" + codeType + '\'' +
                ", amount=" + amount +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                '}';
    }
}
