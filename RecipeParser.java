import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeParser {

    static String name = ""; //A
    static String category = ""; //B
    static String mainIng = ""; //C
    static String yieldAmount = ""; //D
    static String yieldType = ""; //M
    static String notes = ""; //F
    static ArrayList<Ingredient> allIngredients = new ArrayList<>(); //H I K L
    static String instructions = ""; //J

    static ArrayList<Recipe> recipes = new ArrayList<>();
    static ArrayList<String> ingredientList = new ArrayList<>();

    public static void organize(ArrayList<String> unorganizedIngredients) {
        ArrayList<ArrayList<String>> listList = new ArrayList<>();
        listList.add(new ArrayList<String>());
        int previousCount = 0;
        int currentCount = 1;
        int index = 0;
        for (String ingredient : unorganizedIngredients) {
            if (ingredient.charAt(0) == 'H') {
                currentCount = 1;
            }
            else if (ingredient.charAt(0) == 'I') {
                currentCount = 2;
            }
            else if (ingredient.charAt(0) == 'K') {
                currentCount = 3;
            }
            else if (ingredient.charAt(0) == 'L') {
                currentCount = 4;
            }

            if (currentCount > previousCount) {
                listList.get(index).add(ingredient);
            }
            else {
                index++;
                listList.add(new ArrayList<String>());
                listList.get(index).add(ingredient);
            }
            previousCount = currentCount;
        }

        String quantity = "";
        String ingredients = "";
        String preparation = "";
        String identifier = "";
        for (ArrayList<String> list : listList) {
            quantity = "";
            ingredients = "";
            preparation = "";
            identifier = "";
            for (String item : list) {
                char firstChar = item.charAt(0);
                if (firstChar == 'H') {
                    quantity = item.substring(1);
                }
                else if (firstChar == 'I') {
                    ingredients = item.substring(1);
                }
                else if (firstChar == 'K') {
                    preparation = item.substring(1);
                }
                else if (firstChar == 'L') {
                    identifier = item.substring(1);
                }
            }
            allIngredients.add(new Ingredient(quantity, ingredients, preparation, identifier));
        }
    }

    public static void main(String[] args) {

        File file = new File("src/main/java/LORNA.TXT");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char firstChar = line.charAt(0);

            switch (firstChar) {
                case 'A': {
                    name = line.substring(1);
                    break;
                }
                case 'B': {
                    category = line.substring(1);
                    break;
                }
                case 'C': {
                    mainIng = line.substring(1);
                    break;
                }
                case 'D': {
                    yieldAmount = line.substring(1);
                    break;
                }
                case 'M': {
                    yieldType = line.substring(1);
                    break;
                }
                case 'F': {
                    notes = notes.concat(line.substring(1));
                    break;
                }
                case 'H': {
                }
                case 'I': {
                }
                case 'K': {
                }
                case 'L': {
                    ingredientList.add(line);
                    break;
                }
                case 'J': {
                    if (line.length() == 1) {
                        break;
                    }
                    char char2 = line.charAt(1);
                    String newLine = line.substring(1);
                    if (char2 == '{' || char2 == '}' || char2 == '~') {
                        break;
                    }
                    else if (char2 == '\\') {
                        int index = 0;
                        while (!Character.isUpperCase(newLine.charAt(index)) && index < newLine.length() - 1) {
                            index++;
                        }
                        newLine = newLine.substring(index);
                    }
                    newLine = newLine.replace("\\", "");
                    newLine = newLine.replace("par~", "");
                    newLine = newLine.replace("~", "\n");
                    instructions = instructions.concat(newLine);
                    break;
                }
                case 'Z': {
                    organize(ingredientList);
                    Recipe recipe = new Recipe(name, category, mainIng, yieldAmount, yieldType, notes, allIngredients, instructions);
                    recipes.add(recipe);
                    notes = "";
                    instructions = "";
                    ingredientList = new ArrayList<>();
                    allIngredients = new ArrayList<>();
                    break;
                }
                default: {

                }
            }
        }
        System.out.println(recipes);
            FileWriter fw = null;
        try {
            fw = new FileWriter("src/main/java/OUTPUT.JSON");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        gson.toJson(recipes, fw);
    }
}
