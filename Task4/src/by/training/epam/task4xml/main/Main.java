package by.training.epam.task4xml.main;

import by.training.epam.task4xml.controller.CommandProvider;
import by.training.epam.task4xml.controller.command.Command;
import by.training.epam.task4xml.service.concreteservice.dom.ParserDOM;
import by.training.epam.task4xml.service.concreteservice.sax.SAXParser;
import by.training.epam.task4xml.service.concreteservice.stax.StAXParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        /*Console.run();
        SAXParser saxParser = new SAXParser();
        saxParser.parse("data/tariffs.xml");

        StAXParser stAXParser = new StAXParser();
        stAXParser.parse("data/tariffs.xml");

        ParserDOM domParser = new ParserDOM();
        domParser.parse("data/tariffs.xml");*/
        CommandProvider provider = new CommandProvider();
        Command command = provider.getCommand("SAX");
        List<List<String>> list = command.execute("B:/Java/Task4/data/tariffs.xml");

        for (List<String> object : list) {
            for (String info : object) {
                System.out.println(info + " ");
            }
        }
    }
}
