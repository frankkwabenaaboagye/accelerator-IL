package frank.exceptionhandlinginjava.ex4_customexception;

public class FrankCustomException extends RuntimeException{
    public FrankCustomException(String message) {
        super(message);
    }
}
