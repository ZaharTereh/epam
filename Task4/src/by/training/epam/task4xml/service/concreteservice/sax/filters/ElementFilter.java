package by.training.epam.task4xml.service.concreteservice.sax.filters;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class ElementFilter extends XMLFilterImpl {

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement in ElementFilter");
        super.startElement(uri+"2", localName, qName, attributes);
    }
}
