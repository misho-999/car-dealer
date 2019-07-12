package com.angelov.cardealer.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <O> O parseXml(Class<O> objectClass, String path) throws JAXBException;

    <O> void exportToXml(O object, Class<O> objectClass, String path) throws JAXBException;
}
