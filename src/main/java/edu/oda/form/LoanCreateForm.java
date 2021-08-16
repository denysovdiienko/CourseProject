package edu.oda.form;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanCreateForm {
    private String codeType;
    private double amount;
    private String dateOfIssue;
    private String description;
}
