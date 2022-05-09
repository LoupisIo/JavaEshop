package gr.upatras;


class MyException extends Exception {
    private String email;
    
    public MyException(String details){
        super(details);
    }

}
