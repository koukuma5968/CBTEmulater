package emulater.application.bean;

import java.io.Serializable;

public class StorageAnswerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number = null;

    private String solution = null;

    private String userSel = null;

    private String correction = null;

     public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getUserSel() {
        return userSel;
    }

    public void setUserSel(String userSel) {
        this.userSel = userSel;
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

}
