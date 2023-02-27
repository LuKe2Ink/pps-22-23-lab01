package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CirculaListImpl implements CircularList{

    private List<Integer> list;
    private int index;

    public CirculaListImpl(){
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
    public Optional<Integer> next() {
        if(!isEmpty()){
            int current = list.get(index);
            this.index = this.index+1;
            if(this.index > list.size()-1)
                reset();
            return Optional.of(current);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        if(!isEmpty()){
            int current = list.get(index);
            this.index = this.index-1;
            return Optional.of(current);
        }
        return Optional.empty();
    }

    @Override
    public void reset() {
        this.index = 0;
    }
}
