package by.training.epam.task4xml.service.concreteservice.parsertostring;

import by.training.epam.task4xml.bean.TariffWithCalls;
import by.training.epam.task4xml.bean.TariffWithoutCalls;

import java.util.ArrayList;
import java.util.List;

public class ParserInString {

    public static List<List<String>> inString(List<TariffWithoutCalls> list){
        List<List<String>> result = new ArrayList<>();

        for (int i =0; i < list.size();i++){
            List<String> object = new ArrayList<>();
            try {
                object.add(String.valueOf(list.get(i).getPayroll()));
                object.add(list.get(i).getDate());
                object.add(list.get(i).getName());
                object.add(list.get(i).getOperator().toString());
                object.add(String.valueOf(list.get(i).getMegabytes()));
                object.add(String.valueOf(list.get(i).getPriceForOneMB()));
                object.add(String.valueOf(list.get(i).getPriceForConnect()));

                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getNumber()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getPriceInside()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getPriceOutside()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getPriceLendline()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getFreeMinutes()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getPriceForSms()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getMaxLengthSms()));
                object.add(String.valueOf(((TariffWithCalls)list.get(i)).getTariffication()));

                String likeNumbers = "";
                for (int j = 0;j <((TariffWithCalls)list.get(i)).getSizeLikeNumbers();j++) {
                    likeNumbers+=((TariffWithCalls) list.get(i)).getLikeNumber(j)+"\n";
                }
                object.add(likeNumbers);

            }catch (ClassCastException ex){
                System.out.println(ex.getMessage());
                for (int j = 0; j < 9; j++){
                    object.add("-");
                }
            }finally {
                result.add(object);
            }

        }

        return result;
    }

    private ParserInString(){}
}
