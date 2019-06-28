package by.training.epam.task4xml.service.concreteservice.stax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.training.epam.task4xml.bean.Operator;
import by.training.epam.task4xml.bean.TariffWithCalls;
import by.training.epam.task4xml.bean.TariffWithoutCalls;
import by.training.epam.task4xml.service.concreteservice.TagName;

public class StAXHandler {

    private TariffWithoutCalls tariffWithoutCalls = null;
    private TariffWithCalls tariffWithCalls = null;

    public  List<TariffWithoutCalls> parse(XMLStreamReader reader) throws XMLStreamException {
        List<TariffWithoutCalls> tariffs = new ArrayList<>();

        TagName tag = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {

                case XMLConstants.START_ELEMENT:
                    tag = TagName.valueOf(reader.getLocalName().toUpperCase());
                    switch (tag) {
                        case TARIFF_WITH_CALLS:
                            tariffWithCalls = new TariffWithCalls();
                            Double payroll = Double.parseDouble(reader.getAttributeValue(null, "payroll"));
                            tariffWithCalls.setPayroll(payroll);
                            Long number = Long.parseLong(reader.getAttributeValue(null, "number")) ;
                            tariffWithCalls.setNumber(number);
                            String registration = reader.getAttributeValue(null,"registration");
                            tariffWithCalls.setDate(registration);
                            break;
                        case TARIFF_WITHOUT_CALLS:
                            tariffWithoutCalls = new TariffWithoutCalls();
                            Double pay = Double.parseDouble(reader.getAttributeValue(null, "payroll"));
                            tariffWithoutCalls.setPayroll(pay);
                            String registrat = reader.getAttributeValue(null,"registration");
                            tariffWithoutCalls.setDate(registrat);
                            break;
                    }
                    break;

                case XMLConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    if (tariffWithCalls != null) {
                        parseTariffWithCalls(tag,text,reader);
                    } else {
                        parseTariffWithoutCalls(tag,text,reader);
                    }
                    break;

                case XMLConstants.END_ELEMENT:
                    tag = TagName.valueOf(reader.getLocalName().toUpperCase());
                    switch (tag) {
                        case TARIFF_WITH_CALLS:
                            tariffs.add(tariffWithCalls);
                            tariffWithCalls = null;
                            break;
                        case TARIFF_WITHOUT_CALLS:
                            tariffs.add(tariffWithoutCalls);
                            tariffWithoutCalls = null;
                            break;
                    }
            }

        }
        return tariffs;
    }
    private void parseTariffWithCalls(TagName tag,String text,XMLStreamReader reader){
        switch (tag) {
            case NAME:
                tariffWithCalls.setName(text);
                break;
            case OPERATOR_NAME:
                tariffWithCalls.setOperator(Operator.valueOf(text.toUpperCase()));
                break;
            case CALL_PRICES:
                tariffWithCalls.setPriceInside(Double.parseDouble(reader.getAttributeValue(null,"inside")));
                tariffWithCalls.setPriceOutside(Double.parseDouble(reader.getAttributeValue(null,"outside")));
                tariffWithCalls.setPriceLendline(Double.parseDouble(reader.getAttributeValue(null,"lendline")));
                break;
            case FREE_MINUTES:
                tariffWithCalls.setFreeMinutes(Integer.parseInt(text));
                break;
            case NUMBER:
                tariffWithCalls.setLikeNumber(text);
                break;
            case CONNECT_PRICE:
                tariffWithCalls.setPriceForConnect(Double.parseDouble(text));
                break;
            case TARIFFICATION:
                tariffWithCalls.setTariffication(text);
                break;
            case INTERNET_TRAFFIC:
                tariffWithCalls.setMegabytes(Integer.parseInt(reader.getAttributeValue(null,"megabytes")));
                tariffWithCalls.setPriceForOneMB(Double.parseDouble(reader.getAttributeValue(null,"price_for_1MB")));
                break;
            case SMS:
                tariffWithCalls.setPriceForSms(Double.parseDouble(reader.getAttributeValue(null,"price")));
                tariffWithCalls.setMaxLengthSms(Short.parseShort(reader.getAttributeValue(null,"max_length")));
                break;
            default:
                break;
        }
    }
    private void parseTariffWithoutCalls(TagName tag,String text,XMLStreamReader reader) {
        switch (tag) {
            case NAME:
                tariffWithoutCalls.setName(text);
                break;
            case OPERATOR_NAME:
                tariffWithoutCalls.setOperator(Operator.valueOf(text.toUpperCase()));
                break;
            case CONNECT_PRICE:
                tariffWithoutCalls.setPriceForConnect(Double.parseDouble(text));
                break;
            case INTERNET_TRAFFIC:
                tariffWithoutCalls.setMegabytes(Integer.parseInt(reader.getAttributeValue(null,"megabytes")));
                tariffWithoutCalls.setPriceForOneMB(Double.parseDouble(reader.getAttributeValue(null,"price_for_1MB")));
                break;
            default:
                break;
        }
    }
}
