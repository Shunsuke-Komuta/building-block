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
    public void test1IsExpectedWhenCubeIsOnlyOneNew() {
        String colors = "1 2 3 4 5 6";
        Cube cube = new Relation(colors);
        
        int actual = cube.getCubeCount();
        
        assertEquals(1, actual);
    }
    
    @Test
    public void test2IsExpectedWhenCubeIsTwiceNew() {
        String colors1 = "1 2 3 4 5 6";
        Cube cube1 = new Relation(colors1);
        String colors2 = "1 2 3 4 5 6";
        Cube cube2 = new Relation(colors2);
        
        int actual1 = cube1.getCubeCount();
        int actual2 = cube2.getCubeCount();
        
        assertEquals(1, actual1);
        assertEquals(2, actual2);
    }
    
    @Test
    public void testArrayIsExpected() {
        String colors = "1 2 3 4 5 6";
        Cube cube = new Relation(colors);
        
        String[] actuals = cube.getColors();
        
        assertEquals("1", actuals[0]);
        assertEquals("2", actuals[1]);
        assertEquals("3", actuals[2]);
        assertEquals("4", actuals[3]);
        assertEquals("5", actuals[4]);
        assertEquals("6", actuals[5]);
    }
    
}
