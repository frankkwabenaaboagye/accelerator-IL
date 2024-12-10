package frank.generics_in_depth.lab3;

public interface BakingValidator<T> {
    boolean validate(T value);
}
