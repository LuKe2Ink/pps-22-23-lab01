package step2.tdd;

import java.util.Iterator;
import java.util.Optional;

/**
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 * Example: with a list like {1,2,3}, the first call of next() returns 1, the second call returns 2,
 * the third returns 3, the fourth returns 1, and so on. Call to previous() goes in the other way.
 */
public interface CircularListIterator {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * create an Iterator that goes only forward
     * @return an iterator containing the next elements
     */
    Iterator<Integer> forwardIterator();

    /**
     * create an Iterator that goes only backward
     * @return an iterator containing the previous elements
     */
    Iterator<Integer> backwardIterator();
    
}
