package jp.level_five.pgcon.building_block;

import java.util.List;

public class Associater {
    
    public void setRelations(List<Cube> cubes) {
        for (int i = cubes.size(); i > 0; i--) {
            int cubeCount = i;
            Cube dstCube = cubes.get(cubeCount - 1);
            findSameColors(cubes, cubeCount, dstCube);
        }
    }
    
    private void findSameColors(List<Cube> cubes, int dstCubeCount, Cube dstCube) {
        String[] dstColors = dstCube.getColors();
        for (int i = 0; i < dstColors.length; i++) {
            for (int j = dstCubeCount - 1; j > 0; j--) {
                int srcCubeCount = j;
                Cube srcCube = cubes.get(srcCubeCount - 1);
                findSameColor(srcCube, dstCube, i);
            }
        }
    }
    
    private void findSameColor(Cube srcCube, Cube dstCube, int dstFaceIndex) {
        String[] dstColors = dstCube.getColors();
        String dstColor = dstColors[dstFaceIndex];
        int srcFaceIndex = 0;
        for (String srcColor : srcCube.getColors()) {
            if (srcColor.equals(dstColor)) {
                int srcTopFaceIndex = getOpositeFaceIndex(srcFaceIndex);
                setRelation(srcCube, srcTopFaceIndex, dstCube, dstFaceIndex);
            }
            srcFaceIndex++;
        }
    }
    
    private void setRelation(Cube srcCube, int srcTopFaceIndex, Cube dstCube, int dstFaceIndex) {
        int relationCount = dstCube.getCountOfRelation(dstFaceIndex);
        relationCount++;
        int maxRelationCount = srcCube.getCountOfRelation(srcTopFaceIndex);
        if (maxRelationCount < relationCount) {
            srcCube.setRelationCount(srcTopFaceIndex, relationCount);
            int[] dstFaceID = createID(dstCube, dstFaceIndex);
            srcCube.setDstFaceID(srcTopFaceIndex, dstFaceID);
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
    
    private int[] createID(Cube dstCube, int dstFaceIndex) {
        int[] dstFaceID = {dstCube.getCubeCount(), dstFaceIndex};
        return dstFaceID;
    }
}
