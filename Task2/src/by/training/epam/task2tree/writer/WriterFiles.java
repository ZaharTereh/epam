package by.training.epam.task2tree.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 * Class for write text in file.
 */
public class WriterFiles {
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(WriterFiles.class.getName());
    /**
     * File for writing text.
     */
    private static File file = new File("data/output.txt");
    /**
     * Method for read text from file.
     * @param text - text which will recorded.
     */
    public static void writeInFile(String text) {
        try {
            logger.debug("Writing text to "+file.getName()+" file...");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(text);
            bufferedWriter.close();
            logger.debug("Writing was successful");
        } catch (Exception ex) {
            logger.debug(ex.getMessage());
        }
    }
    private WriterFiles(){}
}