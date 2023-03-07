package com.tresit.survey.dto.out;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class CreateOKOutDto implements Serializable {

    private static final long serialVersionUID = -2980443943295566354L;
    private int status;
    private String message;

}
