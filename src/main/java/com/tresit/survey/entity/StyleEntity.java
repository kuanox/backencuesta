package com.tresit.survey.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "StyleEntity")
@Table(name = "style")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StyleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    String style;

}
