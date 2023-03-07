package com.tresit.survey.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "SurveyEntity")
@Table(name = "survey")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Email is mandatory")
    @Column(unique=true)
    String email;
    @NotNull
    int style;

}
