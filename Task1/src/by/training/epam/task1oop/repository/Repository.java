package by.training.epam.task1oop.repository;

import by.training.epam.task1oop.enm.Type;
import by.training.epam.task1oop.entity.Ticket;
import by.training.epam.task1oop.factory.TicketFactory;
import by.training.epam.task1oop.specification.Specification;
import by.training.epam.task1oop.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class that consist list of Tickets and methods to work with this list.
 */
public class Repository {
    private static final Logger logger = LogManager.getLogger(Repository.class.getName());

    private int counter_id = 0;

    private File fileOfObjects = new File("src/data/Tickets.txt");

    public ArrayList<String[]> listStringsObjects = new ArrayList<>();
    public ArrayList<Ticket> listObjects = new ArrayList<>();
    public ArrayList<Ticket> listForSearch = new ArrayList<>();

    private void readFile(File fileOfObjects) {
        try {
            logger.debug("Reading from "+fileOfObjects.getName()+" file...");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOfObjects));
            String line;
            String[] objectParams;

            while ((line = bufferedReader.readLine()) != null) {

                objectParams = line.split("/");
                listStringsObjects.add(objectParams);

            }
            bufferedReader.close();
            logger.debug("Was added "+listStringsObjects.size()+" elements to ArrayList<String>");
            logger.debug("Reading was successful");
        }
        catch (IOException ex) {
            logger.error(ex.getMessage());
        }

    }
    private void parseListStringsObjects(){

        if(!listObjects.isEmpty()){
            listObjects.clear();
        }

        int numberOfObjects = listStringsObjects.size();

        for (int i = 0; i < numberOfObjects;i++) {
            addObject(listStringsObjects.get(i));
        }
        listStringsObjects.clear();
        logger.debug("Was correct recorded and added "+ listObjects.size() +" elements to ArrayList<Ticket>");
    }


    public void saveObject(){
        try {
            logger.debug("Writing objects to "+fileOfObjects.getName()+" file...");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOfObjects));
            String line = "";
            for (Ticket ticket:listObjects) {
                line+=ticket.formStringToWrite()+"\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
            logger.debug("Writing was successful");
        }
        catch (Exception ex) {
            logger.debug(ex.getMessage());
        }

    }
    public void readObjectsFromFile(){
        readFile(fileOfObjects);
        parseListStringsObjects();
    }

    public void addObject(String[] object){
        TicketFactory ticketFactory;
        if (Validation.validation(object)) {
            logger.debug("Validation was successful");
            ticketFactory = TicketFactory.createConcretFactory(Type.valueOf(object[0]));
            listObjects.add(ticketFactory.createTicket(object,counter_id));
            logger.debug("Was created object with "+counter_id+" ID");
            counter_id++;
        }
    }
    public void deleteObject(int ID){
       try{
           listObjects.remove(ID);
           logger.debug("Element with "+ID+" was deleted");
       }catch (Exception ex){
           logger.error(ex.getMessage());
       }
    }

    public void sortObject(Comparator<Ticket> comparator){
        listObjects.sort(comparator);
        logger.debug("List was sorted by "+comparator.getClass()+" comparator");
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
        logger.debug("Was searched by "+specification.getClass());
    }


    Repository(){
    }

}
