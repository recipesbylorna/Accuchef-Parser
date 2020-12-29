import java.util.ArrayList;

public class Recipe {
    private String name; //A
    private String category; //B
    private String mainIng; //C
    private String yieldAmount; //D
    private String yieldType; //M
    private String notes; //F
    private ArrayList<Ingredient> ingredients; //H I K L
    private String instructions; //J

    public Recipe(String name, String category, String mainIng, String yieldAmount, String yieldType, String notes, ArrayList<Ingredient> ingredients, String instructions) {
        this.name = name;
        this.category = category;
        this.mainIng = mainIng;
        this.yieldAmount = yieldAmount;
        this.yieldType = yieldType;
        this.notes = notes;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainIng() {
        return mainIng;
    }

    public void setMainIng(String mainIng) {
        this.mainIng = mainIng;
    }

    public String getYieldAmount() {
        return yieldAmount;
    }

    public void setYieldAmount(String yieldAmount) {
        this.yieldAmount = yieldAmount;
    }

    public String getYieldType() {
        return yieldType;
    }

    public void setYieldType(String yieldType) {
        this.yieldType = yieldType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", mainIng='" + mainIng + '\'' +
                ", yieldAmount='" + yieldAmount + '\'' +
                ", yieldType='" + yieldType + '\'' +
                ", notes='" + notes + '\'' +
                ", ingredients=" + ingredients +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}