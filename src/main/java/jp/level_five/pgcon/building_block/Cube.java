package jp.level_five.pgcon.building_block;

public class Cube {
    private static int cubeCount_;
    
    private final String[] faceColors_;
    private final int cubeNumber_;
    
    public static void initilizeCubeCount() {
        cubeCount_ = 0;
    }
    
    public Cube(String[] faceColors) {
        cubeNumber_ = ++cubeCount_;
        faceColors_ = faceColors;
    }
    
    public String[] getFaceColors() {
        return faceColors_;
    }
    
    public int getNumber() {
        return cubeNumber_;
    }
    
}
