package by.training.epam.task2tree.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Class for read text from file.
 */
public class ReaderFiles {
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(ReaderFiles.class.getName());
    /**
     * Method for read text from file.
     * @param file - file which will read.
     * @return String - text.
     */
    public static String readFile(final File file) {
        StringBuilder text = new StringBuilder("");
        try {
            logger.debug("Reading from "+file.getName()+" file...");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line + "\n");
            }
            bufferedReader.close();
            logger.debug("Reading was successful");
        }catch (IOException ex){
           logger.error(ex.getMessage());
        }
        return text.toString();
    }
    private ReaderFiles(){}
}
