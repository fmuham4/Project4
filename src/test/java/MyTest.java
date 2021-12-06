import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
    void NodeTest() {
        int[] p = new int[] {1, 2, 3, 4};
        Node n = new Node(p);
        assertArrayEquals(p, n.getKey());
        assertEquals(Arrays.toString(p), n.getKey2());
        assertEquals(null, n.getParent());
    }
	
	@Test
    void DB_Solver2Test() {
        int[] p = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node n = new Node(p);

        DB_Solver2 s = new DB_Solver2(n, "Welcome to The\n AI 15 Puzzle");
        assertEquals(0, s.findZero(p));

        p = new int[] {4, 1, 2, 3, 5, 9, 6, 7, 8, 0, 10, 11, 12, 13, 14, 15};
        assertEquals(9, s.findZero(p));

        p = new int[] {4, 1, 2, 3, 5, 9, 6, 7, 8, 10, 14, 11, 12, 13, 15, 0};
        assertEquals(15, s.findZero(p));

        p = new int[] {4, 1, 2, 3, 5, 9, 6, 7, 8, 10, 14, 11, 12, 13, 15, 16};
        assertEquals(-1, s.findZero(p));
    }
	
	@Test
    void DB_Solver2Test3() {
        int[] p = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node n = new Node(p);

        DB_Solver2 s = new DB_Solver2(n, "Welcome to The\n AI 15 Puzzle");
        assertTrue(s.goalTest(p));

        s.moveZero(p, s.findZero(p), 10);
        assertFalse(s.goalTest(p));

        s.moveZero(p, s.findZero(p), 15);
        assertFalse(s.goalTest(p));

        s.moveZero(p, s.findZero(p), 0);
        assertFalse(s.goalTest(p));

        s.moveZero(p, s.findZero(p), 15);
        assertFalse(s.goalTest(p));
    }
	
	@Test
    void UserInterfaceTest() {
		
		UserInterface UI = new UserInterface();
		
        int[] p = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        String s = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15";
        int[] p2 = UI.stringToIntArray(s);

        assertArrayEquals(p, p2);

        p = new int[] {5, 14, 4, 1, 7, 15, 12, 2, 13, 0, 6, 10, 8, 9, 3, 11};
        assertNotEquals(p, p2);

        s = "5 14 4 1 7 15 12 2 13 0 6 10 8 9 3 11";
        p2 = UI.stringToIntArray(s);
        assertArrayEquals(p, p2);
    }
	
	
	@Test
    void DB_Solver2Test2() {
        int[] p = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node n = new Node(p);

        DB_Solver2 s = new DB_Solver2(n, "Welcome to The\n AI 15 Puzzle");

        s.moveZero(p, s.findZero(p), 10);
        assertEquals(10, s.findZero(p));

        s.moveZero(p, s.findZero(p), 15);
        assertEquals(15, s.findZero(p));

        s.moveZero(p, s.findZero(p), 0);
        assertEquals(0, s.findZero(p));

        s.moveZero(p, s.findZero(p), 15);
        assertEquals(15, s.findZero(p));
    }
	
	

}
