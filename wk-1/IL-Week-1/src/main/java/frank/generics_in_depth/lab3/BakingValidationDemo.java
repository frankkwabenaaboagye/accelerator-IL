package frank.generics_in_depth.lab3;

public class BakingValidationDemo {

    public static void main(String[] args) {
        BakingValidator<Integer> temperatureValidator = new TemperatureValidator();
        int temperature = 180;
        System.out.println("Is temperature valid? " + temperatureValidator.validate(temperature));

        BakingValidator<String> ingredientValidator = new IngredientNameValidator();
        String ingredient = "Flour";
        System.out.println("Is ingredient valid? " + ingredientValidator.validate(ingredient));

        BakingValidator<Double> weightValidator = new WeightValidator();
        double weight = 500.0;
        System.out.println("Is weight valid? " + weightValidator.validate(weight));
    }
}
