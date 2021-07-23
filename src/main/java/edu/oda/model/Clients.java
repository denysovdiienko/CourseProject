package edu.oda.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Clients {
    private String clientId;
    private String name;
    private String typeOfProperty;
    private String address;
    private String phoneNumber;
    private String contactPerson;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Clients() {
    }

    public Clients(String name, String typeOfProperty, String address, String phoneNumber, String contactPerson) {
        this.name = name;
        this.typeOfProperty = typeOfProperty;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.contactPerson = contactPerson;
    }

    public Clients(String clientId, String name, String typeOfProperty, String address, String phoneNumber,
                   String contactPerson, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.clientId = clientId;
        this.name = name;
        this.typeOfProperty = typeOfProperty;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.contactPerson = contactPerson;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(String typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
        Clients clients = (Clients) o;
        return getClientId().equals(clients.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId());
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", typeOfProperty='" + typeOfProperty + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


