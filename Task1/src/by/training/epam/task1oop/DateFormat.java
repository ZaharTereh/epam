package by.training.epam.task1oop;

    public class DateFormat implements Comparable<DateFormat>{
    private int year;
    private int mounth;
    private int day;

     public static DateFormat parseDate(String date) throws IllegalArgumentException {
         String[] dateString = date.split(" ");
         int[] dateInteger = new int[dateString.length];
         for (int i = 0; i < dateString.length; i++) {
             dateInteger[i] = Integer.valueOf(dateString[i]);
         }
         return new DateFormat(dateInteger[0], dateInteger[1], dateInteger[2]);
     }

    @Override
    public int compareTo(DateFormat o) {
            if(getYear() < o.getYear()){return -1;}
            else if(getYear() > o.getYear()){return 1;}
            else {
                if(getMounth() < o.getMounth()){return -1;}
                else if(getMounth() > o.getMounth()){return 1;}
                else {
                    if(getDay() < o.getDay()){return -1;}
                    else if(getDay() > o.getDay()){return 1;}
                    else {return 0;}
                }

            }
        }

    public String getDate(){
        return (getYear()+" "+getMounth()+" "+getDay());
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMounth() {
        return mounth;
    }
    public void setMounth(int mounth) {
        this.mounth = mounth;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public DateFormat(int year,int mounth,int day)throws IllegalArgumentException{

        final int MINIMAL_YEAR = 2019;
        final int MAXIMAL_YEAR = 2030;
        final int MINIMAL_MOUNTH = 1;
        final int MAXIMAL_MOUNTH = 12;
        final int MINIMAL_DAY = 1;
        final int MAXIMAL_DAY = 31;

        final int JANUARY = 1;
        final int February = 2;
        final int March = 3;
        final int April = 4;
        final int May = 5;
        final int June = 6;
        final int July = 7;
        final int August = 8;
        final int September = 9;
        final int October = 10;
        final int November = 11;
        final int December = 12;

        if (year < MINIMAL_YEAR || year > MAXIMAL_YEAR ){
            throw new IllegalArgumentException();
        }
        if (mounth < MINIMAL_MOUNTH || mounth > MAXIMAL_MOUNTH ){
            throw new IllegalArgumentException();
        }
        if (day < MINIMAL_DAY || day > MAXIMAL_DAY ){

            throw new IllegalArgumentException();
        }
/*
        if((mounth == JANUARY || mounth == March || mounth == May || mounth == July || mounth == August || mounth == October|| mounth == December) && (day > 31 || day < 0))
        {
            System.out.println("31");
            throw new IllegalArgumentException();
        }else if((mounth == April || mounth == November || mounth == September || mounth == June) && day > 30 && day < 0){
            System.out.println("30");
            throw new IllegalArgumentException();
        }else if (mounth == February && (day!=28 && day != 29)){
            System.out.println("28");
            throw new IllegalArgumentException();
        }
*/
        setYear(year);
        setMounth(mounth);
        setDay(day);
    }
}
