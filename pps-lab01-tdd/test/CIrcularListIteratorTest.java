

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.jupiter.api.*;

import step2.tdd.CirculaListIteratorImpl;

public class CIrcularListIteratorTest {
    
    private CirculaListIteratorImpl circularList;

    @BeforeEach
    void testTodo(){
        circularList = new CirculaListIteratorImpl();
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
    void testForwardIterator(){
        popolateList();
        Iterator<Integer> circularIterator = this.circularList.forwardIterator();
        assertEquals((Integer) 1, circularIterator.next());
        assertEquals((Integer) 2, circularIterator.next());
        assertEquals((Integer) 3, circularIterator.next());
        assertEquals((Integer) 1, circularIterator.next());
    }

    @Test
    void testBackwardIterator(){
        popolateList();
        Iterator<Integer> circularIterator = this.circularList.backwardIterator();
        assertEquals((Integer) 1, circularIterator.next());
        assertEquals((Integer) 3, circularIterator.next());
        assertEquals((Integer) 2, circularIterator.next());
        assertEquals((Integer) 1, circularIterator.next());
    }

}
