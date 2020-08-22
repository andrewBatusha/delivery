package com.coursework.demo.entity;

import com.coursework.demo.entity.enums.Condition;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patient implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String phoneNumber;

    private int age;

    @Enumerated(EnumType.STRING)
    private Condition condition;
}
