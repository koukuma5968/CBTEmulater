package emulater.layout.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Left")
@XmlAccessorType(XmlAccessType.FIELD)
public class LeftViewItem implements XmlElementInterfarcee {

    @XmlElement(name="Categorys")
	private List<Category> Categorys;

    public List<Category> getCategorys() {
		return Categorys;
	}

}
