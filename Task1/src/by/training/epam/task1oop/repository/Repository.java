package by.training.epam.task1oop.repository;

import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.Ticket;
import by.training.epam.task1oop.factory.TicketFactory;
import by.training.epam.task1oop.specification.Specification;
import by.training.epam.task1oop.validation.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Repository {
    public static Repository repository;

    File fileOfObjects = new File("src/data/Tickets.txt");

    public ArrayList<String[]> listStringsObjects = new ArrayList<>();
    public ArrayList<Ticket> listObjects = new ArrayList<>();
    public ArrayList<Ticket> listForSearch = new ArrayList<>();

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

        for (int i = 0; i < numberOfObjects;i++) {
            addObject(listStringsObjects.get(i));
        }
        listStringsObjects.clear();
    }


    public void saveObject(){
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
    public void addObject(String[] object){
        TicketFactory ticketFactory;
        if (Validation.validation(object)) {
            ticketFactory = TicketFactory.createConcretFactory(Type.valueOf(object[0]));
            listObjects.add(ticketFactory.createTicket(object));
        }
    }
    public void deleteObject(int index){
       try{
           listObjects.remove(index);
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    public void sortObject(Comparator<Ticket> comparator){
        listObjects.sort(comparator);
    }
    public void searchObject(Specification specification){

        if(!listForSearch.isEmpty()){
            listForSearch.clear();
        }

        for(Ticket temp:listObjects){
            if(specification.search(temp)){
                listForSearch.add(temp);
            }

        }
    }


    private Repository(){
    }
    public static void getRepository(){
        if(repository == null){
            repository = new Repository();
        }
        else{
            throw  new RuntimeException();
        }
    }
}
