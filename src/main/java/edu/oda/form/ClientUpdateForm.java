package edu.oda.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateForm {
    private String id;
    private String name;
    private String typeOfProperty;
    private String address;
    private String phoneNumber;
    private String contactPerson;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
