package com.Geekster.Recipe.Management.System.API.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfPerson;
    private String textOfComment;
    //    @ManyToOne
//    @JoinColumn(name = "fk_comment_recipe_recipeId")
    @ManyToOne(cascade = CascadeType.ALL)
    private Recipe recipe;
}
