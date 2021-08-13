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
public class Item {
    @Id
    private String id;
    private String name;
    private String desc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
