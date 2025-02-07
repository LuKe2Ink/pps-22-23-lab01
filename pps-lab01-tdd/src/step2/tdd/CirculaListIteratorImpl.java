package step2.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;

import lab01.tdd.CirculaListImpl;
import step2.tdd.CircularIterator.Direction;

public class CirculaListIteratorImpl implements CircularListIterator{

    private List<Integer> list;
    private int index;

    public CirculaListIteratorImpl(){
        this.list = new ArrayList();
        this.index = 0;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new CircularIterator<>(this.list, Direction.FORWARD);
    }

    @Override
    public Iterator<java.lang.Integer> backwardIterator() {
        return new CircularIterator<>(this.list, Direction.BACKWARD);
    }
    
}
/**
 *
 */
