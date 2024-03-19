package com.shreeya.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Entity annotation, part of the javax. persistence package, is used at the class level
        and marks the class as a persistent entity.
        It signals to the JPA provider that the class should be treated as a table in the database.

@Table Annotation. The @Table annotation provides the specifics of the corresponding database table. This includes the name of the table, the catalog, and the schema.
If no @Table annotation is provided, the default table name will be the name of the class */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}