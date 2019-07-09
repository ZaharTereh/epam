package by.training.epam.task4xml.service.concreteservice.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.training.epam.task4xml.bean.Operator;
import by.training.epam.task4xml.bean.TariffWithCalls;
import by.training.epam.task4xml.bean.TariffWithoutCalls;
import by.training.epam.task4xml.service.Parser;
import by.training.epam.task4xml.service.concreteservice.parsertostring.ParserInString;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ParserDOM implements Parser{

    @Override
    public List<List<String>> parse(String fileName) {
        org.apache.xerces.parsers.DOMParser parser = new  org.apache.xerces.parsers.DOMParser();
        List<TariffWithoutCalls> tariffs = new ArrayList<>();
        try {
            parser.parse(fileName);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList tariffWithoutCallsNodes = root.getElementsByTagName("tariff_without_calls");
            NodeList tariffWithCallsNodes = root.getElementsByTagName("tariff_with_calls");


            parseTariffWithoutCalls(tariffWithoutCallsNodes,tariffs);
            parseTariffWithCalls(tariffWithCallsNodes,tariffs);

        }catch (IOException ex){
            ex.getMessage();
        }
        catch (SAXException ex){
            ex.getMessage();
        }

        return ParserInString.inString(tariffs);
    }
    private Element getSingleChild(Element element, String childName){
        NodeList list = element.getElementsByTagName(childName);
        Element child = (Element) list.item(0);
        return child;
    }

    private void parseTariffWithoutCalls(NodeList tariffWithoutCallsNodes,List<TariffWithoutCalls> tariffs){
        for (int i = 0; i < tariffWithoutCallsNodes.getLength(); i++) {
            TariffWithoutCalls tariffWithoutCalls = new TariffWithoutCalls();
            Element element = (Element) tariffWithoutCallsNodes.item(i);

            tariffWithoutCalls.setPayroll(Double.parseDouble(element.getAttribute("payroll")));
            tariffWithoutCalls.setDate(element.getAttribute("registration"));
            tariffWithoutCalls.setName(getSingleChild(element,"name").getTextContent());
            tariffWithoutCalls.setOperator(Operator.valueOf(getSingleChild(element,"operator_name").getTextContent().toUpperCase()));
            tariffWithoutCalls.setMegabytes(Integer.parseInt(getSingleChild(element,"internet_traffic").getAttribute("megabytes")));
            tariffWithoutCalls.setPriceForOneMB(Double.parseDouble(getSingleChild(element,"internet_traffic").getAttribute("price_for_1MB")));
            tariffWithoutCalls.setPriceForConnect(Double.parseDouble(getSingleChild(getSingleChild(element,"options"),"connect_price").getTextContent()));

            tariffs.add(tariffWithoutCalls);
        }
    }
    private void parseTariffWithCalls(NodeList tariffWithCallsNodes,List<TariffWithoutCalls> tariffs){
        for (int i = 0; i < tariffWithCallsNodes.getLength(); i++) {
            TariffWithCalls tariffWithCalls = new TariffWithCalls();
            Element element = (Element) tariffWithCallsNodes.item(i);

            tariffWithCalls.setPayroll(Double.parseDouble(element.getAttribute("payroll")));
            tariffWithCalls.setNumber(Long.parseLong(element.getAttribute("number")));
            tariffWithCalls.setDate(element.getAttribute("registration"));
            tariffWithCalls.setName(getSingleChild(element,"name").getTextContent());
            tariffWithCalls.setOperator(Operator.valueOf(getSingleChild(element,"operator_name").getTextContent().toUpperCase()));
            tariffWithCalls.setMegabytes(Integer.parseInt(getSingleChild(element,"internet_traffic").getAttribute("megabytes")));
            tariffWithCalls.setPriceForOneMB(Double.parseDouble(getSingleChild(element,"internet_traffic").getAttribute("price_for_1MB")));
            tariffWithCalls.setPriceInside(Double.parseDouble(getSingleChild(element,"call_prices").getAttribute("inside")));
            tariffWithCalls.setPriceOutside(Double.parseDouble(getSingleChild(element,"call_prices").getAttribute("outside")));
            tariffWithCalls.setPriceLendline(Double.parseDouble(getSingleChild(element,"call_prices").getAttribute("lendline")));
            tariffWithCalls.setFreeMinutes(Integer.parseInt(getSingleChild(element,"free_minutes").getTextContent()));
            tariffWithCalls.setPriceForSms(Double.parseDouble(getSingleChild(element,"sms").getAttribute("price")));
            tariffWithCalls.setMaxLengthSms(Short.parseShort(getSingleChild(element,"sms").getAttribute("max_length")));
            tariffWithCalls.setPriceForConnect(Double.parseDouble(getSingleChild(getSingleChild(element,"options_for_call"),"connect_price").getTextContent()));
            tariffWithCalls.setTariffication(getSingleChild(getSingleChild(element,"options_for_call"),"tariffication").getTextContent());

            Element elementLikeNumbers = getSingleChild(getSingleChild(element,"options_for_call"),"like_numbers");
            NodeList numbers = elementLikeNumbers.getElementsByTagName("number");
            for (int j = 0;j < numbers.getLength();j++){
                tariffWithCalls.setLikeNumber(numbers.item(j).getTextContent());
            }

            tariffs.add(tariffWithCalls);
        }
    }
}
