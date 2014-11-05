package jp.level_five.pgcon.building_block;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class CubeBuilderTest {
    
    @After
    public void teraDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testWhenCubeOfCubesIsNull() {
        List<Cube> cubes = new ArrayList<Cube>();
        
        new CubeBuilder(cubes);
    }

    
    @Test
    public void test2IsExpectedWhenOpositefaceIs2() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        String actual = cubeBuilder.getOpositeface("1 front");
        
        assertEquals("1 back", actual);
    }
    
    @Test
    public void test1IsExpectedWhenOpositefaceIs1() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        String actual = cubeBuilder.getOpositeface("1 back");
        
        assertEquals("1 front", actual);
    }
    
    @Test
    public void test4IsExpectedWhenOpositefaceIs4() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        String actual = cubeBuilder.getOpositeface("1 left");
        
        assertEquals("1 right", actual);
    }
    
    @Test
    public void test2CubesAreBuilt() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"7", "8", "9", "10", "11", "1"};
        cubes.add(new Cube(faces2));
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        List<String> actual = cubeBuilder.getBuiltCubes();
        
        assertEquals("1 back", actual.get(0));
        assertEquals("2 bottom", actual.get(1));
    }
    
    @Test
    public void test2CubesAreBuiltWhenSecondCubeIsNoRelation() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"7", "8", "9", "10", "11", "12"};
        cubes.add(new Cube(faces2));
        String[] faces3 = {"13", "14", "15", "16", "17", "1"};
        cubes.add(new Cube(faces3));
        
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        List<String> actual = cubeBuilder.getBuiltCubes();
        
        assertEquals("1 back", actual.get(0));
        assertEquals("3 bottom", actual.get(1));
    }
    
    @Test
    public void test3CubesAreBuilt() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"100", "2", "3", "4", "5", "6"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"7", "8", "300", "100", "10", "11"};
        cubes.add(new Cube(faces2));
        String[] faces3 = {"12", "13", "14", "15", "16", "300"};
        cubes.add(new Cube(faces3));
        
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        List<String> actual = cubeBuilder.getBuiltCubes();
        
        assertEquals("1 back", actual.get(0));
        assertEquals("2 right", actual.get(1));
        assertEquals("3 bottom", actual.get(2));
    }
    
    @Test
    public void testOutput() {
        List<Cube> cubes = new ArrayList<Cube>();
        String[] faces1 = {"1", "1", "1", "2", "2", "2"};
        cubes.add(new Cube(faces1));
        String[] faces2 = {"3", "3", "3", "3", "3", "3"};
        cubes.add(new Cube(faces2));
        String[] faces3 = {"1", "2", "3", "1", "2", "3"};
        cubes.add(new Cube(faces3));
        
        CubeBuilder cubeBuilder = new CubeBuilder(cubes);
        
        List<String> actual = cubeBuilder.getBuiltCubes();
        System.out.println(actual);
    }
    
     @Test
     public void testNoCubeIsBuilt() {
     List<Cube> cubes = new ArrayList<Cube>();
     String[] faces1 = {"1", "2", "3", "4", "5", "6"};
     cubes.add(new Cube(faces1));
     String[] faces2 = {"7", "8", "9", "10", "11", "12"};
     cubes.add(new Cube(faces2));
     String[] faces3 = {"13", "14", "15", "16", "17", "18"};
     cubes.add(new Cube(faces3));
    
     CubeBuilder cubeBuilder = new CubeBuilder(cubes);
    
     List<String> actual = cubeBuilder.getBuiltCubes();
     System.out.println(actual);
    
     assertEquals("1 top", actual.get(0));
     }
}
