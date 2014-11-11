package jp.level_five.pgcon.building_block;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssociaterTest {
    private List<String> cubes;
    private Associater associater;
    
    @Before
    public void setUp() {
        cubes = new ArrayList<String>();
        associater = new Associater();
    }
    
    @After
    public void tearDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test
    public void test2backIsExpected() {
        String colors1 = "1 2 3 4 5 6";
        String colors2 = "1 1 1 1 6 1";
        cubes.add(colors1);
        cubes.add(colors2);
        associater = new Associater();
        List<Cube> association = associater.setRelations(cubes);
        Cube light = association.get(0);
        String[] dstFaceIDs = light.getDstFaceIDs();
        
        String actual = dstFaceIDs[Cube.TOP];
        
        assertEquals("2 top", actual);
        }
    
    @Test
    public void testNullCharcterIsExpected() {
        cubes.add("1 2 3 4 5 6");
        cubes.add("7 7 7 7 7 7");
        List<Cube> association = associater.setRelations(cubes);
        Cube light = association.get(0);
        String[] dstFaceIDs = light.getDstFaceIDs();
        
        String actual = dstFaceIDs[Cube.FRONT];
        
        assertEquals("", actual);
    }
    
    @Test
    public void test3topIsExpected() {
        cubes.add("1 2 3 4 5 6");
        cubes.add("7 7 7 7 7 7");
        cubes.add("7 7 7 7 6 7");
        List<Cube> association = associater.setRelations(cubes);
        Cube light = association.get(0);
        String[] dstFaceIDs = light.getDstFaceIDs();
        
        String actual = dstFaceIDs[Cube.TOP];
        
        assertEquals("3 top", actual);
    }
    
    @Test
    public void test2IsExpectedWhen2BlocksAreBuilt() {
        cubes.add("1 2 3 4 5 6");
        cubes.add("7 7 7 7 6 7");
        cubes.add("7 7 7 7 6 7");
        List<Cube> association = associater.setRelations(cubes);
        Cube light = association.get(0);

        int actual = light.getRelationCount(Cube.TOP);
        
        assertEquals(2, actual);
    }
}

