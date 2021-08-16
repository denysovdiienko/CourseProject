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
public class TypeOfLoan {
    @Id
    private String id;
    private Loan loan;
    private Client client;
    private double amount;
    private String dateOfIssue;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfLoan that = (TypeOfLoan) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public TypeOfLoan(Loan loan, String description, Client client, double amount, String dateOfIssue) {

        this.loan = loan;
        this.description = description;
        this.client = client;
        this.amount = amount;
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "TypesOfLoans{" +
                "loans=" + loan +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", clients=" + client +
                ", amount=" + amount +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
