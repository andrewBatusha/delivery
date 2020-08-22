package com.coursework.demo.entity;

import com.coursework.demo.entity.enums.CallStatus;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "calls")
public class Call implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brigade_id")
    private Brigade brigade;

    @OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private CallStatus callStatus;
}
