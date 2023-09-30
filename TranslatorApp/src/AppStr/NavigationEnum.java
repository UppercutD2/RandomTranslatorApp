package AppStr;

public enum NavigationEnum {
    START(1,"Start"),
    ADD_WORD(2,"Add Word"),
    SEE_HISTORY(3,"See History"),
    EXIT(0,"Exit");


    int option;
    String message;
    NavigationEnum(int option,String message)
    {
        this.option=option;
        this.message=message;
    }

    public String getNaviMsg()
    {
        return "["+option+"] "+message;
    }




}
