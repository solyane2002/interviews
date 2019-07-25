package interviews;

public class UnknownInterviewException extends Exception { 
    private static final long serialVersionUID = 1L;

    public UnknownInterviewException(String errorMessage) {
        super(errorMessage);
    }
}