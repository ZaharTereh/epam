package by.training.epam.task2tree.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReaderFiles {
    private static final Logger logger = LogManager.getLogger(ReaderFiles.class.getName());

    public static String readFile(File file) {
        StringBuilder text = new StringBuilder("");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                text.append(line+"\n");
            }

        }catch (IOException ex){
           logger.error(ex.getMessage());
        }
        return text.toString();
    }
}
