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
    
    private int[] maxfaceRelationCount = new int[6];
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
    
    public int getCountOfRelation(int faceIndex) {
        return maxfaceRelationCount[faceIndex];
    }
    
    public void setRelation(int srcFaceIndex, int dstFaceIndex, Cube heavier) {
        int relationCount = heavier.getCountOfRelation(dstFaceIndex);
        relationCount++;
        int srcTopFaceIndex = getOpositeFaceIndex(srcFaceIndex);
        int maxRelationCount = getCountOfRelation(srcTopFaceIndex);
        if (maxRelationCount < relationCount) {
            maxfaceRelationCount[srcTopFaceIndex] = relationCount;
            int[] dstFaceID = heavier.createID(dstFaceIndex);
            setDstFaceID(srcTopFaceIndex, dstFaceID);
        }
    }
    
    private void setDstFaceID(int opositeFaceIndex, int[] dstFaceID) {
        dstFaceIDs[opositeFaceIndex] = dstFaceID;
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
    
    public int[] createID(int dstFaceIndex) {
        int[] dstFaceID = {cubeID, dstFaceIndex};
        return dstFaceID;
    }
    
    public int[] getDstTopFaceID(int srtTopFaceIndex) {
        int[] dstTopFaceID = dstFaceIDs[srtTopFaceIndex];
        return dstTopFaceID;
    }
}
