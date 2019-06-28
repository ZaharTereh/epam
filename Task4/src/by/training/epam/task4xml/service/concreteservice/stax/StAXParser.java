package by.training.epam.task4xml.service.concreteservice.stax;

import by.training.epam.task4xml.bean.TariffWithCalls;
import by.training.epam.task4xml.bean.TariffWithoutCalls;
import by.training.epam.task4xml.service.Parser;
import by.training.epam.task4xml.service.concreteservice.parsertostring.ParserInString;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class StAXParser implements Parser {
    @Override
    public List<List<String>> parse(String fileName){
        List<TariffWithoutCalls> tariffs = null;
        try {
            InputStream input = new FileInputStream(fileName);
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            StAXHandler staxHandler = new StAXHandler();
            tariffs = staxHandler.parse(reader);
        } catch (XMLStreamException ex) {
            ex.getMessage();
        }
        catch (FileNotFoundException ex){
            ex.getMessage();
        }
        return ParserInString.inString(tariffs);
    }

}
