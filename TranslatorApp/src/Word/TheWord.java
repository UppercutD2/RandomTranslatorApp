package Word;

public class TheWord {

    private String eng="English";
    private String aze = "Azeri";

    private boolean isShown;

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getAze() {
        return aze;
    }

    public void setAze(String aze) {
        this.aze = aze;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    @Override
    public String toString() {
        return " | eng='" + eng +", aze='" + aze  +'|';
    }
}
