package com.angelov.cardealer.util;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParserImpl implements XmlParser {
    @Override
    public <O> O parseXml(Class<O> objectClass, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(objectClass);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (O) unmarshaller.unmarshal(new File(path));
    }


    @Override
    public <O> void exportToXml(O object, Class<O> objectClass, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(objectClass);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(object, new File(path));
    }
}
