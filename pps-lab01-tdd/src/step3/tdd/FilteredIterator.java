package step3.tdd;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import step2.tdd.CircularIterator;

public class FilteredIterator<Integer> extends CircularIterator<Integer>{
    private Predicate filter;

    public FilteredIterator(List<Integer> list, Direction direction, Predicate filter) {
        super(list, direction);
        this.filter = filter;
    }

    public Optional<Integer> nextFiltered() {
        Integer element = (Integer) circulaListImpl.next().get();
        return Optional.ofNullable(this.filter.test(element) ? element : null);
    }

}
