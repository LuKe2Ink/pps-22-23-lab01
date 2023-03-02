package step3.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import step2.tdd.CircularIterator;
import step2.tdd.CircularListIterator;
import step2.tdd.CircularIterator.Direction;

public class CircularListIteratorFilteredImpl implements CircularListIterator{
    
    private List<Integer> list;
    private int index;

    public CircularListIteratorFilteredImpl(){
        this.list = new ArrayList();
        this.index = 0;
    }

    public void add(int element) {
        this.list.add(element);
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    
    @Override
    public Iterator<Integer> forwardIterator() {
        // TODO Auto-generated method stub
        return new CircularIterator<>(this.list, Direction.FORWARD);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        // TODO Auto-generated method stub
        return new CircularIterator<>(this.list, Direction.BACKWARD);
    }

    public FilteredIterator<Integer> filteredNext(Predicate predicate) {
        return new FilteredIterator(this.list, Direction.FORWARD, predicate);
    }
    
}