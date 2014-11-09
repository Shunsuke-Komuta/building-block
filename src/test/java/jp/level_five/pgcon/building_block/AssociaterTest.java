package jp.level_five.pgcon.building_block;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Test;

public class AssociaterTest {
    
    @After
    public void tearDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test
    public void test2backIsExpected() {
        List<String> cubes = new ArrayList<String>();
        String colors1 = "1 2 3 4 5 6";
        cubes.add(colors1);
        String colors2 = "6 1 2 3 4 5";
        cubes.add(colors2);
        
        Associater associater = new Associater();
        Map<String, List<String>> association = associater.createAssociations(cubes);

        List<String> actual = association.get("1 front");
        
        assertEquals("2 back", actual.get(0));
        }
    
    @Test
    public void testNullIsExpected() {
        List<String> cubes = new ArrayList<String>();
        cubes.add("1 2 3 4 5 6");
        cubes.add("2 2 2 2 2 2");
        
        Associater associater = new Associater();
        
        Map<String, List<String>> association = associater.createAssociations(cubes);
        List<String> actual = association.get("1 front");
        
        assertTrue(actual.isEmpty());
    }
    
    @Test
    public void test3ResultsAreExpectedWhen3Maching() {
        List<String> cubes = new ArrayList<String>();
        cubes.add("1 2 3 4 5 6");
        cubes.add("7 7 7 1 1 1");
        
        Associater associater = new Associater();
        
        Map<String, List<String>> association = associater.createAssociations(cubes);
        List<String> actual = association.get("1 front");
        
        assertEquals("2 right", actual.get(0));
        assertEquals("2 top", actual.get(1));
        assertEquals("2 bottom", actual.get(2));
    }
    
    @Test
    public void test2ResultsAreExpectedWhen2MachingBySomeCubes() {
        List<String> cubes = new ArrayList<String>();
        cubes.add("1 2 3 4 5 6");
        cubes.add("7 1 7 7 7 7");
        cubes.add("7 7 1 7 7 7");
        
        Associater associater = new Associater();
        
        Map<String, List<String>> association = associater.createAssociations(cubes);
        List<String> actual = association.get("1 front");
        
        assertEquals("2 back", actual.get(0));
        assertEquals("3 left", actual.get(1));
    }
}

