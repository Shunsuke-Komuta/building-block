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
        Cube cube = new Cube("1 2 3 4 5 6");
        cube.setRelationCount(Cube.TOP, 1);
        
        int actual1 = cube.getCountOfRelation(Cube.TOP);
        
        assertEquals(1, actual1);
    }
    
    @Test
    public void test2IsExpectedWhenCubeHasRelations() {
        Cube cube = new Cube("1 2 3 4 5 6");
        cube.setRelationCount(Cube.TOP, 2);
        
        int actual = cube.getCountOfRelation(Cube.TOP);
        
        assertEquals(2, actual);
    }
    
    @Test
    public void testReturnDstFaceIDWhenCubeHasRelation() {
        Cube cube = new Cube("1 2 3 4 5 6");
        cube.setRelationCount(Cube.FRONT, 1);
        cube.setRelationCount(Cube.LEFT, 2);
        cube.setRelationCount(Cube.TOP, 3);
        
        int actual1 = cube.getCountOfRelation(Cube.FRONT);
        int actual2 = cube.getCountOfRelation(Cube.LEFT);
        int actual3 = cube.getCountOfRelation(Cube.TOP);
        
        assertEquals(1, actual1);
        assertEquals(2, actual2);
        assertEquals(3, actual3);
    }
    
    @Test
    public void test2TOPIsExpeceted() {
        Cube srcCube = new Cube("1 2 3 4 5 6");
        int[] dstFaceID = {2, Cube.TOP};
        srcCube.setDstFaceID(Cube.TOP, dstFaceID);
        
        int[] actual = srcCube.getDstTopFaceID(Cube.TOP);
        
        assertEquals(2, actual[0]);
        assertEquals(Cube.TOP, actual[1]);
    }
    
    @Test
    public void test3FRONTIsExpeceted() {
        Cube srcCube = new Cube("1 2 3 4 5 6");
        int[] dstFaceID = {3, Cube.TOP};
        srcCube.setDstFaceID(Cube.FRONT, dstFaceID);
        
        int[] actual = srcCube.getDstTopFaceID(Cube.FRONT);
        
        assertEquals(3, actual[0]);
        assertEquals(Cube.TOP, actual[1]);
    }
}
