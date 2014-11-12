package jp.level_five.pgcon.building_block;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssociaterTest {
    private List<String> cubeColors;
    private Associater associater;
    
    @Before
    public void setUp() {
        cubeColors = new ArrayList<String>();
        associater = new Associater();
    }
    
    @After
    public void tearDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test
    public void test2TOPIsExpected() {
        String colors1 = "1 2 3 4 5 6";
        String colors2 = "1 1 1 1 6 1";
        cubeColors.add(colors1);
        cubeColors.add(colors2);
        List<Cube> cubes = createCubes(cubeColors);
        associater.setRelations(cubes);
        Cube light = cubes.get(0);
        
        int[] actual = light.getDstTopFaceID(Cube.TOP);
        
        assertEquals(2, actual[0]);
        assertEquals(Cube.TOP, actual[1]);
        }
    
    @Test
    public void test00IsExpected() {
        cubeColors.add("1 2 3 4 5 6");
        cubeColors.add("7 7 7 7 7 7");
        List<Cube> cubes = createCubes(cubeColors);
        associater.setRelations(cubes);
        Cube light = cubes.get(0);
        
        int[] actual = light.getDstTopFaceID(Cube.TOP);
        
        assertEquals(0, actual[0]);
        assertEquals(0, actual[1]);

    }
    
    @Test
    public void test3topIsExpected() {
        cubeColors.add("1 2 3 4 5 6");
        cubeColors.add("7 7 7 7 7 7");
        cubeColors.add("7 7 7 7 6 7");
        List<Cube> cubes = createCubes(cubeColors);
        associater.setRelations(cubes);
        Cube light = cubes.get(0);
        
        int[] actual = light.getDstTopFaceID(Cube.TOP);
        
        assertEquals(3, actual[0]);
        assertEquals(Cube.TOP, actual[1]);
    }
    
    @Test
    public void test2IsExpectedWhen2BlocksAreBuilt() {
        cubeColors.add("1 2 3 4 5 6");
        cubeColors.add("7 7 7 7 6 7");
        cubeColors.add("7 7 7 7 6 7");
        List<Cube> cubes = createCubes(cubeColors);
        associater.setRelations(cubes);
        Cube light = cubes.get(0);

        int actual = light.getCountOfRelation(Cube.TOP);
        
        assertEquals(2, actual);
    }
    
    private List<Cube> createCubes(List<String> cubeColors) {
        List<Cube> cubes = new ArrayList<Cube>();
        for (String cubeColor : cubeColors) {
            Cube cube = new Cube(cubeColor);
            cubes.add(cube);
        }
        return cubes;
    }

}

