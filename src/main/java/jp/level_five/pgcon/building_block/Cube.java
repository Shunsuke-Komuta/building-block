package jp.level_five.pgcon.building_block;

public abstract class Cube {
    public static final String[] FACE_NAMES = {"front", "back", "left", "right", "top", "bottom"};
    
    protected static int cubeCount;
    protected int cubeID;
    protected String[] colorIDs;
    
    public abstract String getFaceID(int i);
    
    public static void initilizeCubeCount() {
        cubeCount = 0;
    }
    
    protected void realize(String colors) {
        cubeID = ++cubeCount;
        colorIDs = colors.split(" ");
    }

    
    public int getCubeCount() {
        return cubeID;
    }
    
    public String[] getColors() {
        return colorIDs;
    }
    
}
