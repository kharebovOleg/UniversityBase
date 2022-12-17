package io;

import model.AllInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JaxbWriter {

    private static final Logger log = Logger.getLogger(AllInfo.class.getName());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    private JaxbWriter() {}

    public static void writeXml(AllInfo allLists) {
        try {

            log.log(Level.INFO, "XML marshalling started");

            JAXBContext jaxbContext = JAXBContext.newInstance(AllInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                log.log(Level.INFO, "Directory created successfully");
            } catch (IOException ioEx) {
                log.log(Level.FINE, "Directory already created", ioEx);
            }


            File requestFile = new File("xmlReqs/infoReq" + dateFormat.format(new Date()) + ".xml");

            marshaller.marshal(allLists, requestFile);
        } catch (JAXBException jaxbEx) {
            log.log(Level.SEVERE, "XML marshalling failed", jaxbEx);
            return;
        }
        log.log(Level.INFO, "XML marshalling finished successfully");
    }
}
