public class Ingredient {
    private String quantity; //H
    private String ingredient; //I
    private String preparation; //K
    private String identifier; //L

    public Ingredient(String quantity, String ingredient, String preparation, String identifier) {
        this.quantity = quantity;
        this.ingredient = ingredient;
        this.preparation = preparation;
        this.identifier = identifier;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "quantity='" + quantity + '\'' +
                ", ingredients='" + ingredient + '\'' +
                ", preparation='" + preparation + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
