package com.catedra.democatedra.domain.dto;

import com.catedra.democatedra.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto extends BaseDto{

    protected String name;
    protected byte age;
    protected String country;
}
