package by.training.epam.task4xml.service.concreteservice.sax;

import by.training.epam.task4xml.bean.Operator;
import by.training.epam.task4xml.bean.TariffWithCalls;
import by.training.epam.task4xml.bean.TariffWithoutCalls;
import by.training.epam.task4xml.service.concreteservice.TagName;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {

    private ArrayList<TariffWithoutCalls> tariffsList = new ArrayList<>();
    private TariffWithoutCalls tariffWithoutCalls;
    private TariffWithCalls tariffWithCalls;
    private StringBuilder text;
    private Attributes tagAttributes;

    public ArrayList<TariffWithoutCalls> getTariffsList() {
        return tariffsList;
    }

    public void startDocument() throws SAXException {
        System.out.println("Parsing SAX started...");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing SAX ended.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName + ", qName: " + qName);
        text = new StringBuilder();
        tagAttributes = attributes;
        if (qName.equals("tariff_with_calls")) {
            tariffWithCalls = new TariffWithCalls();
            tariffWithCalls.setPayroll((Double.parseDouble(attributes.getValue("payroll"))));
            tariffWithCalls.setNumber(Long.parseLong(attributes.getValue("number")));
            tariffWithCalls.setDate(attributes.getValue("registration"));
        }
        if (qName.equals("tariff_without_calls")) {
            tariffWithoutCalls = new TariffWithoutCalls();
            tariffWithoutCalls.setPayroll((Double.parseDouble(attributes.getValue("payroll"))));
            tariffWithoutCalls.setDate(attributes.getValue("registration"));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        TagName tag = TagName.valueOf(qName.toUpperCase());
        if (tariffWithCalls != null) {
            parseTariffWithCalls(tag);
        } else {
            parseTariffWithoutCalls(tag);
        }
    }

    private void parseTariffWithCalls(TagName tag){
        switch (tag) {
            case NAME:
                tariffWithCalls.setName(text.toString());
                break;
            case OPERATOR_NAME:
                tariffWithCalls.setOperator(Operator.valueOf(text.toString().toUpperCase()));
                break;
            case CALL_PRICES:
                tariffWithCalls.setPriceInside(Double.parseDouble(tagAttributes.getValue("inside")));
                tariffWithCalls.setPriceOutside(Double.parseDouble(tagAttributes.getValue("outside")));
                tariffWithCalls.setPriceLendline(Double.parseDouble(tagAttributes.getValue("lendline")));
                break;
            case FREE_MINUTES:
                tariffWithCalls.setFreeMinutes(Integer.parseInt(text.toString()));
                break;
            case NUMBER:
                tariffWithCalls.setLikeNumber(text.toString());
                break;
            case CONNECT_PRICE:
                tariffWithCalls.setPriceForConnect(Double.parseDouble(text.toString()));
                break;
            case TARIFFICATION:
                tariffWithCalls.setTariffication(text.toString());
                break;
            case INTERNET_TRAFFIC:
                tariffWithCalls.setMegabytes(Integer.parseInt(tagAttributes.getValue("megabytes")));
                tariffWithCalls.setPriceForOneMB(Double.parseDouble(tagAttributes.getValue("price_for_1MB")));
                break;
            case SMS:
                tariffWithCalls.setPriceForSms(Double.parseDouble(tagAttributes.getValue("price")));
                tariffWithCalls.setMaxLengthSms(Short.parseShort(tagAttributes.getValue("max_length")));
                break;

            case TARIFF_WITH_CALLS:
                tariffsList.add(tariffWithCalls);
                tariffWithCalls = null;
                break;
            default:
                break;
        }
    }
    private void parseTariffWithoutCalls(TagName tag) {
        switch (tag) {
            case NAME:
                tariffWithoutCalls.setName(text.toString());
                break;
            case OPERATOR_NAME:
                tariffWithoutCalls.setOperator(Operator.valueOf(text.toString().toUpperCase()));
                break;
            case CONNECT_PRICE:
                tariffWithoutCalls.setPriceForConnect(Double.parseDouble(text.toString()));
                break;
            case INTERNET_TRAFFIC:
                tariffWithoutCalls.setMegabytes(Integer.parseInt(tagAttributes.getValue("megabytes")));
                tariffWithoutCalls.setPriceForOneMB(Double.parseDouble(tagAttributes.getValue("price_for_1MB")));
                break;
            case TARIFF_WITHOUT_CALLS:
                tariffsList.add(tariffWithoutCalls);
                tariffWithoutCalls = null;
                break;
            default:
                break;
        }
    }




    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw (exception);
    }


}