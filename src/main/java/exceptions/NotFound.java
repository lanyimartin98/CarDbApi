package exceptions;

public class NotFound extends Throwable {
    public NotFound(String title){
        super(title+" not found in the database");
    }
}
