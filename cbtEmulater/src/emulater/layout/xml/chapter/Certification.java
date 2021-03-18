package emulater.layout.xml.chapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Certification {

    @XmlAttribute(name="certType")
    private CertType certType;

    @XmlValue()
    private String value;

    public CertType getCertType() {
        return certType;
    }

    public String getValue() {
        return value;
    }

}
