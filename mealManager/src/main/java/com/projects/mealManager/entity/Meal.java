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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name="meal")
public class Meal {

    @Id
    @UuidGenerator
    @Column(name="id",unique = true, updatable = false)
    private String id;
    private LocalDateTime mealDateTime;

    @ManyToMany(mappedBy = "mealSet")
    ArrayList<Recipe> recipes;

    @ManyToOne
    @JoinColumn(name="weeklyPlan_id", nullable=false)
    private WeeklyPlan weeklyPlan;

}
