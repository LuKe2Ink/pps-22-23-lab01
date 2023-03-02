package step2.tdd;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import lab01.tdd.CirculaListImpl;

public class CircularIterator<Integer> implements Iterator<Integer>{
    
    public enum Direction{
        FORWARD, BACKWARD;
    };

    protected CirculaListImpl circulaListImpl = new CirculaListImpl();
    protected Direction direction;

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


