package gr.upatras;

class ItemEx extends Exception {
    public String ExceptionMessage()
    {
        return "This Item already exists";
    }
}