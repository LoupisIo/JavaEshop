package gr.upatras.JavaEshop;

class ItemEx extends Exception {
    public String ExceptionMessage()
    {
        return "This Item already exists";
    }
}