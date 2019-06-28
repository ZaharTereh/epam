package by.training.epam.task4xml.service.concreteservice.sax.filters;

import org.xml.sax.XMLReader;

public interface XMLFilter extends XMLReader {
    public abstract void setParent (XMLReader parent);
    public abstract XMLReader getParent ();
}
