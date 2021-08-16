package edu.oda.form;

import edu.oda.model.TypeOfLoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfLoanUpdateForm {
    private String id;
    private String loan;
    private String client;
    private double amount;
    private String dateOfIssue;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TypeOfLoanUpdateForm(TypeOfLoan typeOfLoan) {
        this.id = typeOfLoan.getId();
        this.client = typeOfLoan.getClient().getName();
        this.loan = typeOfLoan.getLoan().getCodeType() + " ";
        this.amount = typeOfLoan.getAmount();
        this.dateOfIssue = typeOfLoan.getDateOfIssue();
        this.description = typeOfLoan.getDescription();
        this.createdAt = typeOfLoan.getCreatedAt();
        this.updatedAt = typeOfLoan.getUpdatedAt();
    }
}
