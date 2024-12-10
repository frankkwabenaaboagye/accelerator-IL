package frank.generics_in_depth.lab3;

public class IngredientNameValidator implements BakingValidator<String>{
    @Override
    public boolean validate(String name) {
        return name != null && !name.isEmpty() && name.length() <= 30;
    }
}
