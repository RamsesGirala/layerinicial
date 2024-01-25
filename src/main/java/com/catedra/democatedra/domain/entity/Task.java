package com.catedra.democatedra.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task extends Base{

    private String name;
    private String description;
    private boolean isCompleted;
    private LocalDateTime dateOfCreation;
    private int timeRequiredToComplete;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tasks")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public void setInitialValues(){
        this.isCompleted = false;
        this.dateOfCreation = LocalDateTime.now();
    }

}
