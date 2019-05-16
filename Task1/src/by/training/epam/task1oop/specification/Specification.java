package by.training.epam.task1oop.specification;

import by.training.epam.task1oop.entity.Ticket;

/**
 * Interface for searching object by specific criterion.
 */
public interface Specification {
    boolean search(Ticket ticket);
}
