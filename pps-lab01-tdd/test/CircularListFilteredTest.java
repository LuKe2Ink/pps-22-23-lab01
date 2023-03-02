import step2.tdd.CirculaListIteratorImpl;
import step3.tdd.CircularListIteratorFilteredImpl;
import step3.tdd.FilteredIterator;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.*;


public class CircularListFilteredTest {

    private CircularListIteratorFilteredImpl circularList;

    @BeforeEach
    void testTodo(){
        circularList = new CircularListIteratorFilteredImpl();
    }

    private void popolateList(){
        for (int i=1; i<=3; i++){
            this.circularList.add(i);
        }
    }

    @Test
    void testInitialization(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void testAddWithSize(){
        this.circularList.add(5);
        assertEquals(1, this.circularList.size());
        popolateList();
        assertEquals(4, this.circularList.size());
    }

    @Test
    void testFilteredIterator(){
        popolateList();
        FilteredIterator<Integer> circularIterator = this.circularList.filteredNext((element)->((Integer) element)>1);
        assertEquals(Optional.empty(), circularIterator.nextFiltered());
        assertEquals(Optional.of(2), circularIterator.nextFiltered());
        assertEquals(Optional.of(3), circularIterator.nextFiltered());
        assertEquals(Optional.empty(), circularIterator.nextFiltered());
    }

}
