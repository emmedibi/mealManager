package com.projects.mealManager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name="weeklyPlan")
public class WeeklyPlan {

    @Id
    @UuidGenerator
    @Column(name="id",unique = true, updatable = false)
    private String id;
    private LocalDateTime startingDate;

    @OneToMany(mappedBy = "weeklyPlan")
    private Set<Meal> meals;
}
