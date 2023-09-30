package Exceptions;

public enum TranslatorException {
    ILLEGAL_CHARACTER_EXCEPTION("Special character inserted"),
    ILLEGAL_POINT_EXCEPTION("Point cant be below zero");


    String message;

    TranslatorException(String s)
    {
        this.message=s;
    }

    public String getErrMessage()
    {
        return message;
    }






}

