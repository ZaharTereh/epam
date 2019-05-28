package by.training.epam.task2tree.comparator;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.enm.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class which consist methods for sorting sentences by number of concrete sing.
 */
public class SortSentencesBySign implements Sort {
    /**
     * Logger for write information about application.
     */
    private static final Logger logger = LogManager.getLogger(SortSentencesBySign.class.getName());
    private Character sign;
    /**
     * Rule how to compare two objects.
     * @param o1 - first object.
     * @param o2 - second object.
     * @return -1 if less; 0 if equal; 1 if bigger.
     */
    @Override
    public int compare(Component o1, Component o2) {
        Integer temp1 = new Integer(0);
        Integer temp2 = new Integer(0);

        String sentence1 = o1.getText();
        String sentence2 = o2.getText();
        int size1 = sentence1.length();
        int size2 = sentence2.length();

        for(int i = 0;i < size1;i++){
            if(sign.equals(sentence1.charAt(i))){
                temp1++;
            }
        }
        for(int i = 0;i < size2;i++){
            if(sign.equals(sentence2.charAt(i))){
                temp2++;
            }
        }
        return temp1.compareTo(temp2);
    }
    /**
     * Method for sorting us composite.
     * @param component - which are sorted.
     */
    @Override
    public void sort(Component component) {
        if (component.getType() == Type.PARAGRAPH) {
            component.getList().sort(this);
        } else {
            for (Component temp : component.getList()) {
                sort(temp);
            }
        }
        logger.debug("Sort was successful!");
    }
    public SortSentencesBySign(Character sign){
        this.sign = sign;
    }
}
