package by.training.epam.task1oop.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for create Repository.
 */
public class Creator {
    /**
     * Variable for singleton.
     */
    private  static Repository repository;
    /**
     * Logger for this class.
     */
    private static final Logger logger = LogManager.getLogger(Repository.class.getName());

    /**
     * Method for create Repository.
     * @return new Repository object.
     * @throws Exception
     */
    public static Repository createRepository(){
        if(repository == null){
            repository = new Repository();
            logger.debug("Repository was successful created");
        }
        return repository;
    }
}
