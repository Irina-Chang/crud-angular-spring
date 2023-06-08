package com.codelab.crudspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.sql.Update;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@SQLDelete(sql = "Update Course Set status ='Inativo' Where id=?")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100 , nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Length(max = 10)
    //@Pattern( regexp = "Back-end|Front-end")
    @Column(length = 10 ,nullable = false)
    private String categoria;

    @NotNull
    @NotBlank
    @Length(max = 10)
    @Column(length = 10 ,nullable = false)
    private String status = "Ativo";

}
