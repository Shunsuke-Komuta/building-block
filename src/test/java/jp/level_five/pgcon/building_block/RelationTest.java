package jp.level_five.pgcon.building_block;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class RelationTest {
    
    @After
    public void tearDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test
    public void test2backIsExpected() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"6", "1", "2", "3", "4", "5"};
        cubes.add(new Cube(faces2));
        
        Relation associater = new Relation();
        
        HashMap<String, List<String>> association = associater.create(cubes);
        List<String> actual = association.get("1 front");
        
        assertEquals("2 back", actual.get(0));
    }
    
    @Test
    public void testNullIsExpected() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"2", "2", "2", "2", "2", "2"};
        cubes.add(new Cube(faces2));
        
        Relation associater = new Relation();
        
        HashMap<String, List<String>> association = associater.create(cubes);
        List<String> actual = association.get("1 front");
        
        assertNull(actual);
    }
    
    @Test
    public void test3ResultsAreExpectedWhen3Maching() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"7", "7", "7", "1", "1", "1"};
        cubes.add(new Cube(faces2));
        
        Relation associater = new Relation();
        
        HashMap<String, List<String>> association = associater.create(cubes);
        List<String> actual = association.get("1 front");
        
        assertEquals("2 right", actual.get(0));
        assertEquals("2 top", actual.get(1));
        assertEquals("2 bottom", actual.get(2));
    }
    
    @Test
    public void test2ResultsAreExpectedWhen2MachingBySomeCubes() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"7", "1", "7", "7", "7", "7"};
        cubes.add(new Cube(faces2));
        String[] faces3 = {"7", "7", "1", "7", "7", "7"};
        cubes.add(new Cube(faces3));
        
        Relation associater = new Relation();
        
        HashMap<String, List<String>> association = associater.create(cubes);
        List<String> actual = association.get("1 front");
        
        assertEquals("2 back", actual.get(0));
        assertEquals("3 left", actual.get(1));
    }
}
