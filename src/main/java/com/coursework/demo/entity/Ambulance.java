package com.coursework.demo.entity;

import com.coursework.demo.entity.enums.AmbulanceStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ambulances")
public class Ambulance implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String driver;

    @OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    @Enumerated(EnumType.STRING)
    private AmbulanceStatus ambulanceStatus;
}
