package com.example.sping.data.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    private int id;

//    @Column(name = "name")
//    Since in our table the column name matches the variable name @Column is not needed in JPA
    private String name;

    private String author;
}
