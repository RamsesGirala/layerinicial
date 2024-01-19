package com.catedra.democatedra.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserWithTaskDTO {

    private Long user_id;
    private String user_name;
    private Long task_id;
    private String task_name;

}
