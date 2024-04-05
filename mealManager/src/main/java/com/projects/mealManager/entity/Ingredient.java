package com.projects.mealManager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.mealManager.constant.Measure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name="ingredient")
public class Ingredient {

    @Id
    @UuidGenerator
    @Column(name="id",unique = true, updatable = false)
    private String id;
    private String name;

}
