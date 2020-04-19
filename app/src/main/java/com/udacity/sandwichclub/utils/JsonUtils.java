package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            Sandwich sandwich = new Sandwich();
            JSONObject sandwichName = sandwichJson.getJSONObject("name");
            sandwich.setMainName(sandwichName.getString("mainName"));
            JSONArray aliasesJson = sandwichName.getJSONArray("alsoKnownAs");
            List<String> aliases = new ArrayList<>();
            for(int i = 0; i < aliasesJson.length(); i++)
            {
                aliases.add(aliasesJson.getString(i));
            }
            sandwich.setAlsoKnownAs(aliases);
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichJson.getString("description"));
            sandwich.setImage(sandwichJson.getString("image"));
            JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for(int i = 0; i < ingredientsJson.length(); i++)
            {
                ingredients.add(ingredientsJson.getString(i));
            }
            sandwich.setIngredients(ingredients);
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
