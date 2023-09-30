package Exceptions;

public class AppException extends Exception{

    public AppException(TranslatorException ex)
    {
        System.err.println(ex.getErrMessage());
    }
}
