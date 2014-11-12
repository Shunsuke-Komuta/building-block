package jp.level_five.pgcon.building_block;

public class Cube {
    public static final int FRONT = 0;
    public static final int BACK = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int TOP = 4;
    public static final int BOTTOM = 5;
    
    private static int cubeCount;
    
    private final int cubeID;
    private String[] colorIDs;
    
    private int[] maxRelationCountArray = new int[6];
    private int[][] dstFaceIDs = new int[6][2];
    
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
    
    public void setRelationCount(int topFaceIndex, int relationCount) {
        maxRelationCountArray[topFaceIndex] = relationCount;
    }
    
    public int getCountOfRelation(int faceIndex) {
        return maxRelationCountArray[faceIndex];
    }
    
    public void setDstFaceID(int topFaceIndex, int[] dstFaceID) {
        dstFaceIDs[topFaceIndex] = dstFaceID;
    }
    
    public int[] getDstTopFaceID(int topFaceIndex) {
        int[] dstTopFaceID = dstFaceIDs[topFaceIndex];
        return dstTopFaceID;
    }

}
