package by.training.epam.task2tree.main;

import by.training.epam.task2tree.comparator.SortLexemeByLength;
import by.training.epam.task2tree.comparator.SortParagraphBySentences;
import by.training.epam.task2tree.comparator.SortSentencesBySign;
import by.training.epam.task2tree.repository.Repository;

public class Main {
    public static void main(String[] args) {
        Repository repository = Repository.getInstance();
        repository.createComponent();
        System.out.println(repository.getText());
        repository.sort(new SortParagraphBySentences());
        System.out.println(repository.getText());
        repository.sort(new SortLexemeByLength());
        System.out.println(repository.getText());
        repository.sort(new SortSentencesBySign('a'));
        System.out.println(repository.getText());
    }
}
