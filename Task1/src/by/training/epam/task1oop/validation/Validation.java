package by.training.epam.task1oop.validation;

import by.training.epam.task1oop.date.DateFormat;
import by.training.epam.task1oop.enm.Transport;
import by.training.epam.task1oop.enm.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {
    private static final Logger logger = LogManager.getLogger(Validation.class.getName());

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
                case VACATION://on the future
                    break;

                case CRUISE://on the future
                    break;

                case SHOPPING:
                    int numberOfShops = Integer.parseInt(params[9]);
                    if(numberOfShops < MINIMAL_NUMBER_OF_SHOPS ){
                        logger.error("Incorrect number of Shops");
                        return false;
                    }

                case EXCURSION://on the future
                    break;

                case TREATMENT://on the future
                    break;

            }


            if (dataEnd.compareTo(dataStart) < MINIMAL_DIFFERENCE_BETWEEN_DAYS) {
                logger.error("Incorrect date(date of start bigger than date of end)");
                return false;
            }

            if (numberOfIngestion < 0 || numberOfIngestion > 5) {
                logger.error("Incorrect number of ingestion");
                return false;
            }

                return true;

        }catch (IllegalArgumentException ex){
            logger.error("Incorrect data format");
            return false;
        }
    }
}
