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
 * Class which consist list of Tickets and methods to work with this list.
 */
public class Repository {
    /**
     * Logger for this class.
     */
    private static final Logger logger = LogManager.getLogger(Repository.class.getName());
    /**
     * Counter which take ID for objects.
     */
    private int counter_id = 0;
    /**
     * File which contains objects in string form.
     */
    private File fileOfObjects = new File("data/Tickets.txt");
    /**
     * Temporary list which takes and contains objects in string form from file.
     */
    public ArrayList<String[]> listStringsObjects = new ArrayList<>();
    /**
     * List which contains concrete objects.
     */
    public ArrayList<Ticket> listObjects = new ArrayList<>();
    /**
     * List which contains objects after search.
     */
    public ArrayList<Ticket> listForSearch = new ArrayList<>();

    /**
     * Method for reading objects in string form and writing their at ArrayList listStringObjects.
     * @param fileOfObjects-file which contains objects in string form.
     */
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

    /**
     * Method for adding objects from listStringsObjects(34) to listObjects(38).
     */
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

    /**
     * Method for writing objects from listObject to file.
     */
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

    /**
     * Method which calls readFile(48) and parseListStringsObjects(74).
     */
    public void readObjectsFromFile(){
        readFile(fileOfObjects);
        parseListStringsObjects();
    }

    /**
     * Method for calling validation method, checking for errors and writing objects in listObjects
     * @param object-array of params in string form.
     */
    public void addObject(String[] object){
        TicketFactory ticketFactory;
        if (Validation.validation(object)) {
            logger.debug("Validation was successful");
            ticketFactory = TicketFactory.createConcreteFactory(Type.valueOf(object[0]));
            listObjects.add(ticketFactory.createTicket(object,counter_id));
            logger.debug("Was created object with "+counter_id+" ID");
            counter_id++;
        }
    }

    /**
     * Method for delete objects from listObjects by ID.
     * @param ID-number of index which will delete.
     */
    public void deleteObject(int ID){
       try{
           listObjects.remove(ID);
           logger.debug("Element with "+ID+" was deleted");
       }catch (Exception ex){
           logger.error(ex.getMessage());
       }
    }

    /**
     * Method for sort.
     * @param comparator-condition which indicates how sort list.
     */
    public void sortObject(Comparator<Ticket> comparator){
        listObjects.sort(comparator);
        logger.debug("List was sorted by "+comparator.getClass()+" comparator");
    }

    /**
     * Method for search certain tickets.
     * @param specification-condition how search tickets.
     */
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

    /**
     * Default constructor with package-private modifier.
     */
    Repository(){
    }

}
