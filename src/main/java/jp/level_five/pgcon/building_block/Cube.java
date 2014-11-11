package jp.level_five.pgcon.building_block;

public class Cube {
    public static final int FRONT = 0;
    public static final int BACK = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int TOP = 4;
    public static final int BOTTOM = 5;
    
    private static int cubeCount;
    private static String[] faceNames = {"front", "back", "left", "right", "top", "bottom"};
    
    private final int cubeID;
    private String[] colorIDs;
    private int[] maxfaceRelationCount = {0, 0, 0, 0, 0, 0};
    private String[] dstFaceIDs = {"", "", "", "", "", ""};
    
    public static void initilizeCubeCount() {
        cubeCount = 0;
    }
    
    public Cube(String colors) {
        cubeID = ++cubeCount;
        colorIDs = colors.split(" ");
    }
    
    public int getCubeCount() {
        return cubeID;
    }
    
    public String[] getColors() {
        return colorIDs;
    }
    
    public int getRelationCount(int faceIndex) {
        return maxfaceRelationCount[faceIndex];
    }
    
    public void setRelation(int srcFaceIndex, int dstFaceIndex, Cube heavier) {
        int relationCount = heavier.getRelationCount(dstFaceIndex);
        relationCount++;
        int opositeFaceIndex = getOpositeFaceIndex(srcFaceIndex);
        int maxRelationCount = getRelationCount(opositeFaceIndex);
        if (maxRelationCount < relationCount) {
            maxfaceRelationCount[opositeFaceIndex] = relationCount;
            String dstFaceID = heavier.createID(dstFaceIndex);
            setDstFaceID(opositeFaceIndex, dstFaceID);
        }
    }
    
    private int getOpositeFaceIndex(int faceIndex) {
        int opositeFaceIndex = 0;
        if (faceIndex % 2 == 1) {
            opositeFaceIndex = faceIndex - 1;
        } else {
            opositeFaceIndex = faceIndex + 1;
        }
        return opositeFaceIndex;
    }
    
    private String createID(int dstFaceIndex) {
        return cubeID + " " + faceNames[dstFaceIndex];
    }
    
    private void setDstFaceID(int opositeFaceIndex, String dstFaceID) {
        dstFaceIDs[opositeFaceIndex] = dstFaceID;
    }
    
    public String[] getDstFaceIDs() {
        return dstFaceIDs;
    }
    
}
