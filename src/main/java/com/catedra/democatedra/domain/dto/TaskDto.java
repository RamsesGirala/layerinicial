package com.catedra.democatedra.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto extends BaseDto {

    private String name;
    private String description;
    private int timeRequiredToComplete;

}
