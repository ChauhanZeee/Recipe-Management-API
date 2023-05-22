package com.Geekster.Recipe.Management.System.API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;
    @NotEmpty
    @Size(max = 255, min = 4, message = "minimum 3 character")
    private String name;
    @NotEmpty
    @Size(max = 2000, min = 4)
    private String ingredients;
    @NotEmpty
    @Size(max = 5000, min = 4)
    private String instruction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    //   @JoinColumn(name = "fk_recipe_comment_commentId")
    private List<Comment> commentList;
}
