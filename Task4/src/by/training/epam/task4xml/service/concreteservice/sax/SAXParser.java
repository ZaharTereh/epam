package by.training.epam.task4xml.service.concreteservice.sax;

import java.io.IOException;
import java.util.List;
import by.training.epam.task4xml.service.Parser;
import by.training.epam.task4xml.service.concreteservice.parsertostring.ParserInString;
import by.training.epam.task4xml.service.concreteservice.sax.filters.ElementFilter;
import by.training.epam.task4xml.service.concreteservice.sax.filters.NamespaceFilter;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXParser implements Parser{
    @Override
    public List<List<String>> parse(String fileName){
        SAXHandler handler = new SAXHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            NamespaceFilter namespaceFilter = new NamespaceFilter(reader);
            ElementFilter elementFilter = new ElementFilter();
            elementFilter.setParent(namespaceFilter);
            elementFilter.setContentHandler(handler);

            elementFilter.parse(new InputSource(fileName));
        }catch (SAXException ex){
            ex.getMessage();
        }catch (IOException ex){
            ex.getMessage();
        }
        return ParserInString.inString(handler.getTariffsList());
    }
}
