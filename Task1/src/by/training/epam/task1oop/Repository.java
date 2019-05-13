package by.training.epam.task1oop;

import by.training.epam.task1oop.entity.Ticket;
import by.training.epam.task1oop.factory.TicketFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Repository {

    File fileOfObjects = new File("Tickets.txt");
    File fileOfObjectToAdd = new File("ObjectToAdd.txt");

    ArrayList<String[]> listStringsObjects = new ArrayList<>();
    ArrayList<Ticket> listObjects = new ArrayList<>();
    ArrayList<Ticket> listForSearch = new ArrayList<>();

    private void readFile(File fileOfObjects) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOfObjects));
            String line;
            String[] objectParams;

            while ((line = bufferedReader.readLine()) != null) {

                objectParams = line.split("/");
                listStringsObjects.add(objectParams);

            }
            bufferedReader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    private void parseListStringsObjects(){

        int numberOfObjects = listStringsObjects.size();
        TicketFactory ticketFactory;

        for (int i = 0; i < numberOfObjects;i++) {

            if (Validation.validation(listStringsObjects.get(i))) {
                ticketFactory = TicketFactory.createConcretFactory(Type.valueOf(listStringsObjects.get(i)[0]));
                listObjects.add(ticketFactory.createTicket(listStringsObjects.get(i)));
            }
        }
        listStringsObjects.clear();
    }


    public void save(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOfObjects));
            String line = "";
            for (Ticket ticket:listObjects) {
                line+=ticket.formStringToWrite()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void readObjectsFromFile(){
        readFile(fileOfObjects);
        for (int i = 0;i < listStringsObjects.size();i++){
            for(int j = 0;j < listStringsObjects.get(i).length;j++) {
                System.out.println(listStringsObjects.get(i)[j]);
            }
        }
        parseListStringsObjects();
    }
    public void addObject(){
        readFile(fileOfObjectToAdd);
        parseListStringsObjects();
    }
    public void deleteObject(){

    }


    class CompareNumberOfDays implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            if (o1.getNumberOfDays() < o2.getNumberOfDays()) {
                return -1;
            } else if (o1.getNumberOfDays() == o2.getNumberOfDays()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    class DateStartCompare implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            DateFormat obj1;
            DateFormat obj2;
            obj1 = DateFormat.parseDate(o1.getDataStart());
            obj2 = DateFormat.parseDate(o2.getDataStart());
           return obj1.compareTo(obj2);
        }

    }
    class DateEndCompare implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            DateFormat obj1;
            DateFormat obj2;
            obj1 = DateFormat.parseDate(o1.getDataEnd());
            obj2 = DateFormat.parseDate(o2.getDataEnd());
            return obj1.compareTo(obj2);
        }
    }

    public void sortByDateStart(){ listObjects.sort(new DateStartCompare()); }
    public void sortByDateEnd(){ listObjects.sort(new DateEndCompare()); }
    public void sortByNumbersOfDays(){listObjects.sort(new CompareNumberOfDays());}

    public void searchByDate(){
        System.out.print("Enter year:");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        for(Ticket temp:listObjects){
            if(temp.getYearStart() == year){
                System.out.println(temp.formStringToWrite());
            }
        }
    }
}
