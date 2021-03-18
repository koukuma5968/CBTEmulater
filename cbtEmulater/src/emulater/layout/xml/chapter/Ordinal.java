package emulater.layout.xml.chapter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ordinal {

    @XmlElement(name="Number")
    private int number;

    @XmlElement(name="Title")
    private String title;

    @XmlElementWrapper(name="ClauseGroup")
    @XmlElement(name="Clause")
    private List<String> clause;

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getClause() {
        return clause;
    }

}
