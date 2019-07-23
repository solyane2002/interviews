package interviews;

public class DurationExcedeedException extends Exception { 
    private static final long serialVersionUID = 1L;

    public DurationExcedeedException(String errorMessage) {
        super(errorMessage);
    }
}