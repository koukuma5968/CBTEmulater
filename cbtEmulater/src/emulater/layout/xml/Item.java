package emulater.layout.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Item {

	@XmlElement(name="Name")
	private String name;

    @XmlElementWrapper(name="Values")
    @XmlElement(name="Value")
	private List<String> value;

	public String getName() {
		return name;
	}

	public List<String> getValue() {
		return value;
	}

}
