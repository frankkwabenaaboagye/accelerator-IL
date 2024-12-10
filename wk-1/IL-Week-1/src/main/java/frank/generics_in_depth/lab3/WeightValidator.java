package frank.generics_in_depth.lab3;

public class WeightValidator implements BakingValidator<Double>{
    @Override
    public boolean validate(Double weight) {
        return weight > 0 && weight <= 1000;
    }
}
