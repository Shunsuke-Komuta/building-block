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
        Cube cube = new Cube(colors);
        
        int actual = cube.getCubeCount();
        
        assertEquals(1, actual);
    }
    
    @Test
    public void test2IsExpectedWhenCubeIsTwiceNew() {
        String colors1 = "1 2 3 4 5 6";
        String colors2 = "1 2 3 4 5 6";
        Cube cube1 = new Cube(colors1);
        Cube cube2 = new Cube(colors2);
        
        int actual1 = cube1.getCubeCount();
        int actual2 = cube2.getCubeCount();
        
        assertEquals(1, actual1);
        assertEquals(2, actual2);
    }
    
    @Test
    public void testArrayIsExpected() {
        String colors = "1 2 3 4 5 6";
        Cube cube = new Cube(colors);
        
        String[] actuals = cube.getColors();
        
        assertEquals("1", actuals[0]);
        assertEquals("2", actuals[1]);
        assertEquals("3", actuals[2]);
        assertEquals("4", actuals[3]);
        assertEquals("5", actuals[4]);
        assertEquals("6", actuals[5]);
    }
    
    @Test
    public void test0IsExpectedWhenCubeHasNoRelation() {
        Cube cube = new Cube("1 2 3 4 5 6");
        
        int actual = cube.getCountOfRelation(Cube.FRONT);
        
        assertEquals(0, actual);
    }
    
    @Test
    public void test1IsExpectedWhenCubeHasOneRelation() {
        Cube light = new Cube("1 2 3 4 5 6");
        Cube heavier = new Cube("6 7 8 9 10 11");
        light.setRelation(Cube.BOTTOM, Cube.FRONT, heavier);
        
        int actual1 = light.getCountOfRelation(Cube.TOP);
        int actual2 = light.getCountOfRelation(Cube.BOTTOM);
        
        assertEquals(1, actual1);
        assertEquals(0, actual2);
    }
    
    @Test
    public void test2IsExpectedWhenCubeHasRelations() {
        Cube light = new Cube("1 2 3 4 5 6");
        Cube heavier = new Cube("6 7 8 9 6 11");
        Cube moreHeavier = new Cube("12 7 13 14 15 16");
        heavier.setRelation(Cube.BACK, Cube.BACK, moreHeavier);
        light.setRelation(Cube.BOTTOM, Cube.TOP, heavier);
        light.setRelation(Cube.BOTTOM, Cube.FRONT, heavier);
        
        int actual = light.getCountOfRelation(Cube.TOP);
        
        assertEquals(2, actual);
    }
    
    @Test
    public void testReturnDstFaceIDWhenCubeHasRelation() {
        Cube light = new Cube("1 2 3 4 5 6");
        Cube heavier = new Cube("6 7 8 9 10 11");
        light.setRelation(Cube.BOTTOM, Cube.FRONT, heavier);
        
        int[] actual = light.getDstTopFaceID(Cube.TOP);
        
        assertEquals(2, actual[0]);
        assertEquals(Cube.FRONT, actual[1]);
    }
}
