package sg.edu.nus.iss.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.miniproject.model.Recipe;
import sg.edu.nus.iss.miniproject.service.RecipeService;
import sg.edu.nus.iss.miniproject.service.UserService;

@RestController
@RequestMapping
public class RecipeRestController {};
   /*  
   
    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;
    
    @GetMapping(path = "/{email}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getList(@PathVariable(name = "email") String email) {

        /* if (!userService.existingUser(email)) {
            JsonObject errorObject = Json.createObjectBuilder()
                    .add("error", "User does not exist")
                    .build();

            String errorJson = errorObject.toString();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorJson);
        }

        List<String> favorites = recipeService.getFavorites(email);

        if (favorites == null || favorites.isEmpty()) {
            JsonObject errorObject = Json.createObjectBuilder()
                    .add("error", "User does not have any favorites")
                    .build();

            String errorJson = errorObject.toString();

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorJson);
        }

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        int i = 1;

        for (String favorite : favorites) {
            if (!favorite.equals("")) {
                JsonObject jsonObject = Json.createObjectBuilder()
                        .add("Favourite " + i, favorite)
                        .build();
                jsonArrayBuilder.add(jsonObject);
                i++;
            }
        }

        return ResponseEntity.ok(jsonArrayBuilder.build().toString());
    } */