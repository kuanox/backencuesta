package com.tresit.survey.dto.out;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class MusicStyleOutDto implements Serializable {

    private static final long serialVersionUID = -4050956821772545414L;
    private String email;
    private int estyle;

}
