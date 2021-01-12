package emulater.layout.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

	@XmlElement(name="Category")
	private String category;

	@XmlElement(name="Item")
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public String getCategory() {
		return category;
	}

}
