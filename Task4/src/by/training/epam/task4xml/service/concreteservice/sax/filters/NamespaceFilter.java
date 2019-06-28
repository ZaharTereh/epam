package by.training.epam.task4xml.service.concreteservice.sax.filters;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class NamespaceFilter extends XMLFilterImpl {

    public NamespaceFilter(XMLReader reader) {
        super(reader);
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException
    {
        System.out.println("startPrefixMapping in NamespaceFilter -" + prefix + ", " + uri);
        super.startPrefixMapping(prefix, uri+"2");
    }
}
