package by.training.epam.task1oop.validation;

import by.training.epam.task1oop.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;

public class Validation {

    public static boolean validation(String[] params){

        final int MINIMAL_DIFFERENCE_BETWEEN_DAYS = 0;
        final int MINIMAL_NUMBER_OF_SHOPS = 0;

        try {

            Type type = Type.valueOf(params[0]);
            Transport.valueOf(params[4]);
            DateFormat dataStart = DateFormat.parseDate(params[5]);
            DateFormat dataEnd = DateFormat.parseDate(params[6]);
            int numberOfIngestion = Integer.parseInt(params[7]);

            switch (type){
                case VACATION:break;

                case CRUISE:break;

                case SHOPPING:
                    int numberOfShops = Integer.parseInt(params[9]);
                    if(numberOfShops < MINIMAL_NUMBER_OF_SHOPS ){
                        return false;
                    }

                case EXCURSION:break;

                case TREATMENT:break;

            }


            if (dataEnd.compareTo(dataStart) < MINIMAL_DIFFERENCE_BETWEEN_DAYS) {
                return false;
            }

            if (numberOfIngestion < 0 || numberOfIngestion > 5) {
                return false;
            }

                return true;

        }catch (IllegalArgumentException ex){
            return false;
        }
    }
}
