package exception;

/**
 * Created by marek on 8.5.16.
 */
public class ImageNotFoundException extends RuntimeException {
    
    public ImageNotFoundException(String message) {
        super(message);
    }
}
