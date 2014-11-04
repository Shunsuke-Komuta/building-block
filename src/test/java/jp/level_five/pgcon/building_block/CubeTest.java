package jp.level_five.pgcon.building_block;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class CubeTest {
    
    @After
    public void tearDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test
    public void testArrayIsExpected() {
        String[] faces = {"1", "2", "3", "4", "5", "6"};
        Cube cube = new Cube(faces);
        
        String[] actuals = cube.getFaceColors();
        
        assertEquals("1", actuals[0]);
        assertEquals("2", actuals[1]);
        assertEquals("3", actuals[2]);
        assertEquals("4", actuals[3]);
        assertEquals("5", actuals[4]);
        assertEquals("6", actuals[5]);
    }
    
    @Test
    public void test1IsExpectedWhenCubeIsOnlyOneNew() {
        String[] faces = {"1", "2", "3", "4", "5", "6"};
        Cube cube = new Cube(faces);
        
        int actual = cube.getNumber();
        
        assertEquals(1, actual);
    }
    
    @Test
    public void test2IsExpectedWhenCubeIsTwiceNew() {
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        Cube cube1 = new Cube(faces1);
        String[] faces2 = {"3", "5", "6", "1", "2", "4",};
        Cube cube2 = new Cube(faces2);
        
        int actual1 = cube1.getNumber();
        int actual2 = cube2.getNumber();
        
        assertEquals(1, actual1);
        assertEquals(2, actual2);
    }
}
