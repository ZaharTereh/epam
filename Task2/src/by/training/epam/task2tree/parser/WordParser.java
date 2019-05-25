package by.training.epam.task2tree.parser;

import by.training.epam.task2tree.component.Component;
import by.training.epam.task2tree.component.Composite;
import by.training.epam.task2tree.enm.Type;

import java.util.ArrayList;

public class WordParser implements Parser {
    private Parser nextParser = new SymbolParser();

    @Override
    public Component parse(String word) {
        Component component = new Composite(Type.WORD);
        int size = word.length();
        ArrayList<String> symbols = new ArrayList<>();
        Character c;
        for(int i=0; i<size; i++){
            c = word.charAt(i);
            symbols.add(c.toString());
        }

        for (String string : symbols){
            component.add(nextParser.parse(string));
        }
        return component;
    }
}
