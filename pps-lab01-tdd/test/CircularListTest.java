import lab01.tdd.CirculaListImpl;
import lab01.tdd.CircularList;

import org.junit.jupiter.api.*;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void testTodo(){
        circularList = new CirculaListImpl();
    }

    private void popolateList(){
        for (int i=1; i<=3; i++){
            this.circularList.add(i);
        }
    }

    @Test
    void testInitialization(){
        assertTrue(this.circularList.isEmpty());
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    void testAddWithSize(){
        this.circularList.add(5);
        assertEquals(1, this.circularList.size());
    }

    @Test
    void testAddWithNext(){
        this.circularList.add(5);
        assertEquals(Optional.of(5), this.circularList.next());
    }

    @Test
    void testAddWithPrevious(){
        this.circularList.add(5);
        assertEquals(Optional.of(5), this.circularList.previous());
    }

    @Test
    void testMultipleNext(){
        popolateList();
        assertEquals(Optional.of(1), this.circularList.next());
        assertEquals(Optional.of(2), this.circularList.next());
        assertEquals(Optional.of(3), this.circularList.next());
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    void testReset(){
        popolateList();
        assertEquals(Optional.of(1), this.circularList.next());
        this.circularList.reset();
        assertEquals(Optional.of(1), this.circularList.next());
    }

    @Test
    void testMultiplePrevious(){
        popolateList();
        assertEquals(Optional.of(1), this.circularList.previous());
        assertEquals(Optional.of(3), this.circularList.previous());
        assertEquals(Optional.of(2), this.circularList.previous());
        assertEquals(Optional.of(1), this.circularList.previous());
    }

}
