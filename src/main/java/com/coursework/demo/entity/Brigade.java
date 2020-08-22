package com.coursework.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "brigades")
public class Brigade implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String doctor;

    private String paramedic;

    private String nurse;

}
