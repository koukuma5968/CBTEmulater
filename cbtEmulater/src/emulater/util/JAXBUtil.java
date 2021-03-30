package emulater.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import emulater.xml.XmlElementInterface;

public class JAXBUtil {

    public static final String problemRoot = "prop/problem/";

    public static XmlElementInterface getXMLReder(Class<? extends XmlElementInterface> clazz, BufferedReader br) {

        XmlElementInterface element = null;

        try {
            JAXBContext con = JAXBContext.newInstance(clazz);
            Unmarshaller unMarshal = con.createUnmarshaller();

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(br);

            element = (XmlElementInterface) unMarshal.unmarshal(reader);

        } catch (JAXBException | XMLStreamException e) {
            e.printStackTrace();
        }

        return element;

    }

    public static Object getXmlObject(Class<? extends XmlElementInterface> clazz, String filePath) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            return JAXBUtil.getXMLReder(clazz, br);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
