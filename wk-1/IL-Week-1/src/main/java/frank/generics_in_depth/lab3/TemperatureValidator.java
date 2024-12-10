package frank.generics_in_depth.lab3;

public class TemperatureValidator implements BakingValidator<Integer>{
    @Override
    public boolean validate(Integer temperature) {
        return temperature >= 150 && temperature <= 250;
    }
}
