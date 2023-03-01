package step2.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;

import lab01.tdd.CirculaListImpl;

public class CirculaListIteratorImpl implements CircularList{

    
    public enum Direction{
        FORWARD, BACKWARD;
    };

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

    

    private class CircularIterator<Integer> implements Iterator<Integer>{

        private CirculaListImpl circulaListImpl = new CirculaListImpl();
        Direction direction;

        public CircularIterator(List<Integer> list,Direction direction){
            list.forEach(element->{
                this.circulaListImpl.add((int) element);
            });
            this.direction = direction;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return (Integer) (this.direction == Direction.FORWARD ? 
            circulaListImpl.next().get() : circulaListImpl.previous().get());
        }

    }
    
}
/**
 *
 */
