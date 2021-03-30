package emulater.xml.chapter;

import emulater.xml.XmlElementInterface;

public enum CertType implements XmlElementInterface {

    NAME("試験名"),
    NUMBER("試験番号"),
    TIME("試験時間"),
    QNUMBER("問題数"),
    PASSLINE("合格ライン"),
    EXAMFEE("試験料");

    private CertType(String title) {
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

}
