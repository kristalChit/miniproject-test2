package sg.edu.nus.iss.miniproject.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import sg.edu.nus.iss.miniproject.model.Recipe;
import sg.edu.nus.iss.miniproject.repository.UserRepository;

@Service
public class RecipeService {

    @Autowired
    public RecipeService(UserRepository userRepository) {}

    public ArrayList<Recipe> getRecipes() throws IOException {
        ArrayList<Recipe> listOfRecipes = new ArrayList<>();

        String url = "https://themealdb.com/api/json/v1/1/filter.php?i=";

        /*
         * final String uri = "www.themealdb.com/api/json/v1/1/filter.php";
         * 
         * String url = UriComponentsBuilder.fromUriString(uri).queryParam("i", "")
         * .toUriString();
         */

        String payload;

        RequestEntity<Void> req = RequestEntity.get(url).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);

        payload = resp.getBody();

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray array = reader.readObject().getJsonArray("meals");

        for (JsonValue value : array) {
            JsonObject obj = value.asJsonObject();
            String meal = obj.getString("strMeal", "");
            String mealThumb = obj.getString("strMealThumb", "");
            String id = obj.getString("idMeal", "");

            Recipe recipe = new Recipe();
            recipe.setMeal(meal);
            recipe.setMealThumb(mealThumb);
            recipe.setId(id);
            listOfRecipes.add(recipe);
        }

        return listOfRecipes;
    }
}

    /* public Boolean saveFavorites(String user, List<Recipe> recipes) {
        List<String> idsToSave = recipes.stream()
                .map(Recipe::getId)
                .collect(Collectors.toList());

        Boolean isSavedSuccessfully = UserRepository.saveFavourites(user, idsToSave);
        return isSavedSuccessfully;
    }

    public Recipe getRecipestepsById(String idMeal) {

        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

        String payload;

        RequestEntity<Void> req = RequestEntity.get(url).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);

        payload = resp.getBody();

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray array = reader.readObject().getJsonArray("meals");

        for (JsonValue value : array) {
            JsonObject obj = value.asJsonObject();
            String meal = obj.getString("strMeal", "");
            String mealThumb = obj.getString("strMealThumb", "");
            String id = obj.getString("idMeal", "");
            String cuisine = obj.getString("strArea", "");
            String recipesteps = obj.getString("strInstruction", "");
            String youtube = obj.getString("strYoutube", "");
            String ingredient = obj.getString("strIngredient", "");
            String measure = obj.getString("strMeasure", "");

            Recipe recipe = new Recipe();
            recipe.setMeal(meal);
            recipe.setMealThumb(mealThumb);
            recipe.setId(id);
            recipe.setCuisine(cuisine);
            recipe.setRecipesteps(recipesteps);
            recipe.setYoutube(youtube);
            recipe.setIngredient(ingredient);
            recipe.setMeasure(measure);
        }

        return UserRepository.searchRecipeById(idMeal);
    }

    public Recipe searchRecipestepsByName(String strMeal) {
       String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

        String payload;

        RequestEntity<Void> req = RequestEntity.get(url).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);

        payload = resp.getBody();

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray array = reader.readObject().getJsonArray("meals");

        for (JsonValue value : array) {
            JsonObject obj = value.asJsonObject();
            String meal = obj.getString("strMeal", "");
            String mealThumb = obj.getString("strMealThumb", "");
            String id = obj.getString("idMeal", "");
            String cuisine = obj.getString("strArea", "");
            String recipesteps = obj.getString("strInstruction", "");
            String youtube = obj.getString("strYoutube", "");
            String ingredient = obj.getString("strIngredient", "");
            String measure = obj.getString("strMeasure", "");

            Recipe recipe = new Recipe();
            recipe.setMeal(meal);
            recipe.setMealThumb(mealThumb);
            recipe.setId(id);
            recipe.setCuisine(cuisine);
            recipe.setRecipesteps(recipesteps);
            recipe.setYoutube(youtube);
            recipe.setIngredient(ingredient);
            recipe.setMeasure(measure);
        }

        return UserRepository.searchRecipeById(strMeal);
    }

    public List<Recipe> getFavorites(String user) {
        List<String> idsRetrieved = UserRepository.getUserFavouriteRecipes(user);
        List<Recipe> recipesRetrieved = new ArrayList<>();
        for (String id : idsRetrieved) {
            Recipe newRecipe = getRecipeById(String idMeal);
            recipesRetrieved.add(newRecipe);
        }
        return recipesRetrieved;
    }
 */