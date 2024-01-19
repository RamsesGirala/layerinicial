package com.catedra.democatedra.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserValidatedDto {

    private Long id;
    private String name;
    private boolean puedeConducir;

}
