package com.therapJavaFest.jagoronBD.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "policeNumber")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class PoliceNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    Division division;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String phoneNumberNo;



}
