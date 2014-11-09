package jp.level_five.pgcon.building_block;

public class Relation extends Cube{
    
    public Relation(String colors) {
        realize(colors);
    }
    
    public String getFaceID(int i) {
        return cubeID + " " + FACE_NAMES[i];
    }
    

}
