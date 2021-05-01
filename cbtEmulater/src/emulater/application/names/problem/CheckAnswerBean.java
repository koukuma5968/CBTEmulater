package emulater.application.names.problem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CheckAnswerBean {

     private StringProperty number = new SimpleStringProperty();

    private StringProperty solution = new SimpleStringProperty();

    private StringProperty userSel = new SimpleStringProperty();

    private StringProperty correction = new SimpleStringProperty();

     public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getSolution() {
        return solution.get();
    }

    public void setSolution(String solution) {
        this.solution.set(solution);
    }

    public String getUserSel() {
        return userSel.get();
    }

    public void setUserSel(String userSel) {
        this.userSel.set(userSel);
    }

    public String getCorrection() {
        return correction.get();
    }

    public void setCorrection(boolean correction) {
        this.correction.setValue(correction ? "〇" : "×");
    }

}
