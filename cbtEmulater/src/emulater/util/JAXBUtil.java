package emulater.util;

import java.io.BufferedReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import emulater.layout.xml.XmlElementInterfarcee;

public class JAXBUtil {

	public static XmlElementInterfarcee getXMLReder(Class<? extends XmlElementInterfarcee> clazz, BufferedReader br) {

		XmlElementInterfarcee element = null;

		try {
			JAXBContext con = JAXBContext.newInstance(clazz);
			Unmarshaller unMarshal = con.createUnmarshaller();

			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(br);

			element = (XmlElementInterfarcee) unMarshal.unmarshal(reader);

		} catch (JAXBException | XMLStreamException e) {
			e.printStackTrace();
		}

		return element;

	}
}
