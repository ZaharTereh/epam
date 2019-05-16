package by.training.epam.task1oop.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Creator {
    private static final Logger logger = LogManager.getLogger(Repository.class.getName());
    private static boolean repositoryIsCreated = false;
    public static Repository createRepository() throws Exception{
        if(repositoryIsCreated){
            logger.error("Attempt to create a second repository");
            throw  new Exception("Attempt to create a second repository");
        }
        else {
         repositoryIsCreated = true;
         logger.debug("Repository was successful created");
         return new Repository();
        }
    }
}
