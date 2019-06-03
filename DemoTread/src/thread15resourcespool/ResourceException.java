package thread15resourcespool;

public class ResourceException extends Exception {
    public ResourceException(){
        super();
    }
    public ResourceException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public ResourceException(String msg) {
        super(msg);
    }
    public ResourceException(Throwable cause) {
        super(cause);
    }
}
