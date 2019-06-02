package by.training.epam.task2tree.controller;

import by.training.epam.task2tree.comparator.Sort;
import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.parser.TextParser;
import by.training.epam.task2tree.reader.ReaderFiles;
import by.training.epam.task2tree.writer.WriterFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Class for manage Tree-Component.
 */
public class Controller {
    /**
     * Instance in object-controller(for SingleTon)
     */
    private static Controller controller;
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(Controller.class.getName());
    /**
     * Tree-Component.
     */
    private Component component;
    /**
     * Method for read text from file and parse this text in Tree.
     */
    public void createComponent() {
        File file = new File("data/input.txt");
        String text = ReaderFiles.readFile(file);
        component = new TextParser().parse(text);
    }
    /**
     * Method for collect text from Tree.
     * @return String text.
     */
    public String getText() {
        return component.toString();
    }
    /**
     * Method for write Tree in file.
     */
    public void writeTextInFile() {
        File file = new File("data/output.txt");
        WriterFiles.writeInFile(getText(),file);
    }
    /**
     * Method for sort Tree.
     */
    public void sort(Sort comparator){
        comparator.sort(component);
    }
    /**
     * Method which create controller(with SingleTon pattern).
     * @return instance in object-controller or create
     * new object-controller.
     */
    public static Controller getInstance(){
        if(controller == null){
            controller = new Controller();
            logger.debug("Controller was successful created");
        }
        return controller;
    }

    /**
     * Private constructor.
     */
    private Controller(){
    }
}
