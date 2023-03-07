package com.tresit.survey.dto.out;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class ResultOutDto implements Serializable {

    private static final long serialVersionUID = -5185373677332161913L;
    private String label;
    private int y;

}
