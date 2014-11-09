package jp.level_five.pgcon.building_block;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class RelationTest {
    
    @After
    public void tearDown() {
        Cube.initilizeCubeCount();
    }
    
    @Test
    public void test1_frontIsExpected() {
        Relation relation = new Relation("1 2 3 4 5 6");
        
        String actual = relation.getFaceID(0);
        
        assertEquals("1 front", actual);
    }
    
    @Test
    public void test1_backIsExpected() {
        Relation relation = new Relation("1 2 3 4 5 6");
        
        String actual = relation.getFaceID(1);
        
        assertEquals("1 back", actual);
    }
    
    @Test
    public void test2_frontIsExpected() {
        new Relation("1 2 3 4 5 6");
        Relation relation = new Relation("7 8 9 10 11 12");
        
        String actual = relation.getFaceID(0);
        
        assertEquals("2 front", actual);
    }
}
