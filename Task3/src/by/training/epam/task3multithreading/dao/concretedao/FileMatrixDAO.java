package by.training.epam.task3multithreading.dao.concretedao;

import by.training.epam.task3multithreading.dao.MatrixDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileMatrixDAO implements MatrixDAO {

    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(FileMatrixDAO.class.getName());
    private  File file = new File("data/matrix.txt");

    @Override
    public String readMatrix() {

        StringBuilder text = new StringBuilder("");
        try {
            logger.debug("Reading from "+file.getName()+" file...");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
            bufferedReader.close();
            logger.debug("Reading was successful");
        }catch (IOException ex){
            logger.error(ex.getMessage());
        }
        return text.toString();
    }
}
