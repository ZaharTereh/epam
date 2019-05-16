package by.training.epam.task1oop.date;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for work with date which contains year,month,day and some methods for work with their.
 */
public class DateFormat implements Comparable<DateFormat>{

    static final Logger logger = LogManager.getLogger(DateFormat.class.getName());

    private int year;
    private int month;
    private int day;

    /**
     * Method which parse string and create object with year,month and day.
     * @param date-date in string form.
     * @return new object which contains year,month and day.
     * @throws IllegalArgumentException
     */
     public static DateFormat parseDate(String date) throws IllegalArgumentException {
         String[] dateString = date.split(" ");
         int[] dateInteger = new int[dateString.length];
         for (int i = 0; i < dateString.length; i++) {
             dateInteger[i] = Integer.valueOf(dateString[i]);
         }
         return new DateFormat(dateInteger[0], dateInteger[1], dateInteger[2]);
     }

        /**
         * Testing of this method contained in SortByDate[End,Start]Test class.
         * Method for compare objects of this DataFormat class.
         * @param o-Date with which is compared object by this. reference.
         * @return -1 if less; 0 if equal; 1 if bigger.
         */
    @Override
    public int compareTo(DateFormat o) {
            if(getYear() < o.getYear()){return -1;}
            else if(getYear() > o.getYear()){return 1;}
            else {
                if(getMonth() < o.getMonth()){return -1;}
                else if(getMonth() > o.getMonth()){return 1;}
                else {
                    if(getDay() < o.getDay()){return -1;}
                    else if(getDay() > o.getDay()){return 1;}
                    else {return 0;}
                }

            }
        }

    public String getDate(){
        return (getYear()+" "+getMonth()+" "+getDay());
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Constructor which contain validation.
     * @param year- concrete year.
     * @param month-concrete month.
     * @param day-concrete day.
     * @throws IllegalArgumentException
     */
    public DateFormat(int year,int month,int day)throws IllegalArgumentException{

        final int MINIMAL_YEAR = 2019;
        final int MAXIMAL_YEAR = 2030;
        final int MINIMAL_MONTH = 1;
        final int MAXIMAL_MONTH = 12;
        final int MINIMAL_DAY = 1;
        final int MAXIMAL_DAY = 31;

        final int FEBRUARY = 2;
        final int APRIL = 4;
        final int JUNE = 6;
        final int SEPTEMBER = 9;
        final int NOVEMBER = 11;

        final int MAXIMAL_DAY_IN_FEBRUARY = 29;
        final int MAXIMAL_DAY_IN_APRIL = 30;



        if (year < MINIMAL_YEAR || year > MAXIMAL_YEAR ){
            logger.error("Illegal year recorded");
            throw new IllegalArgumentException();
        }
        if (month < MINIMAL_MONTH || month > MAXIMAL_MONTH ){
            logger.error("Illegal month recorded");
            throw new IllegalArgumentException();
        }
        if (day < MINIMAL_DAY || day > MAXIMAL_DAY ){
            logger.error("Illegal day recorded");
            throw new IllegalArgumentException();
        }


       if((month == APRIL || month == NOVEMBER || month == SEPTEMBER || month == JUNE) && (day>MAXIMAL_DAY_IN_APRIL)){
           logger.error("Illegal day recorded(31 day in " + month +" month)");
            throw new IllegalArgumentException();
        }else if (month == FEBRUARY && day>MAXIMAL_DAY_IN_FEBRUARY){
           logger.error("Illegal day recorded(more than 29 days in " + month +" month)");
            throw new IllegalArgumentException();
        }

        setYear(year);
        setMonth(month);
        setDay(day);
    }
}
