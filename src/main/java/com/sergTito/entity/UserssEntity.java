package com.sergTito.entity;

import com.sergTito.converter.BirthdayConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "userss",schema = "public")
public class UserssEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    //hibernate_sequence
//    @SequenceGenerator(name = "user_generator",sequenceName = "user_id_sequence",allocationSize = 1)
    private Long id;


    @AttributeOverride(name = "birthDate",column = @Column(name = "birth_date"))
    private PersonalInfo personalInfo;

    @Column(unique = true)
    private String username;


    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
}
