package edu.oda.form;
import edu.oda.model.Client;
import edu.oda.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOfLoanCreateForm {
    private String loan;
    private String client;
    private double amount;
    private String dateOfIssue;
    private String description;
}
