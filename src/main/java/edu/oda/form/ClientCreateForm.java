package edu.oda.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateForm {
    private String name;
    private String typeOfProperty;
    private String address;
    private String phoneNumber;
    private String contactPerson;
    private String description;
}

