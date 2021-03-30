package emulater.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import emulater.xml.XmlElementInterface;
import emulater.xml.problem.Problem;

public class FileUtile {

    public static XmlElementInterface readProblemFile(String path) {

        try (
            GZIPInputStream gs = new GZIPInputStream(new BufferedInputStream(new FileInputStream(path)));
            BufferedReader br = new BufferedReader(new InputStreamReader(gs));
        ) {

            XmlElementInterface prob = JAXBUtil.getXMLReder(Problem.class, br);
            return prob;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
