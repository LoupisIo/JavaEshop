package gr.upatras;

public class NoItemEx extends Exception {
    public String ExceptionMessage()
    {
        return "This Item does not exists";
    }
}