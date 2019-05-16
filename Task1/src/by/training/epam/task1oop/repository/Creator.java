package by.training.epam.task1oop.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for create Repository.
 */
public class Creator {
    /**
     * Logger for this class.
     */
    private static final Logger logger = LogManager.getLogger(Repository.class.getName());
    /**
     * Boolean variable which contain info about Repository
     * (if Repository was created this variable contains 1).
     */
    private static boolean repositoryIsCreated = false;

    /**
     * Method for create Repository.
     * @return new Repository object.
     * @throws Exception
     */
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
