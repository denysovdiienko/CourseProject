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
public class Client {
    @Id

    private String id;
    private String name;
    private String typeOfProperty;
    private String address;
    private String phoneNumber;
    private String contactPerson;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Client(String name, String typeOfProperty, String address, String phoneNumber, String contactPerson,
                  String description) {
        this.name = name;
        this.typeOfProperty = typeOfProperty;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.contactPerson = contactPerson;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getId().equals(client.getId());
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", typeOfProperty='" + typeOfProperty + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


