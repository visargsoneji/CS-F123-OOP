public class InvalidUsageException extends java.lang.Exception{

    public InvalidUsageException(String roomType, String object){
        String message;
        message = roomType + " cannot have " + object;
        super(message);
    }
}
