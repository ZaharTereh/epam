package by.training.epam.task4xml.service.concreteservice.sax.filters;

import org.xml.sax.*;

public abstract class XMLFilterImpl implements XMLFilter, EntityResolver, DTDHandler, ContentHandler, ErrorHandler {

    public XMLFilterImpl() { super(); }
    public XMLFilterImpl(XMLReader parent) {
        super();
        setParent(parent);
    }


}

