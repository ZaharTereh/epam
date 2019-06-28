package by.training.epam.task4xml.service.servicefactory;

import by.training.epam.task4xml.service.Parser;
import by.training.epam.task4xml.service.concreteservice.dom.ParserDOM;
import by.training.epam.task4xml.service.concreteservice.sax.SAXParser;
import by.training.epam.task4xml.service.concreteservice.stax.StAXParser;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private  final Parser dom = new ParserDOM();
    private  final Parser sax = new SAXParser();
    private  final Parser stax = new StAXParser();

    public static ServiceFactory getInstance() {
        return instance;
    }
    public Parser getDom() {
        return dom;
    }
    public Parser getSax() {
        return sax;
    }
    public Parser getStax() {
        return stax;
    }

    private ServiceFactory(){}
}
