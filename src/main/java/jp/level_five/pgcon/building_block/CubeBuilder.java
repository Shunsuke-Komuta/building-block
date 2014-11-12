package jp.level_five.pgcon.building_block;

import java.util.ArrayList;
import java.util.List;

public class CubeBuilder {
    
    private String[] faceNames = {"front", "back", "left", "right", "top", "bottom"};
    private List<Cube> cubes;
    
    public CubeBuilder(List<String> cubeColors) {
        cubes = createCubes(cubeColors);
        Associater associater = new Associater();
        associater.setRelations(cubes);
    }
    
    private List<Cube> createCubes(List<String> cubeColors) {
        List<Cube> cubes = new ArrayList<Cube>();
        for (String cubeColor : cubeColors) {
            Cube cube = new Cube(cubeColor);
            cubes.add(cube);
        }
        return cubes;
    }
    
    public List<String> build() {
        List<String> builtCubes = buildCube(cubes);
        if (builtCubes.isEmpty()) {
            String stringTopFaceID = getAnyTopFaceID();
            builtCubes.add(stringTopFaceID);
        }
        return builtCubes;
    }
    
    private List<String> buildCube(List<Cube> cubes) {
        int[] dstTopFaceID = findTopFaceIDOfAll(cubes);
        ArrayList<String> builtCubes = new ArrayList<String>();
        while (hasNext(dstTopFaceID)) {
            int dstCubeCount = dstTopFaceID[0];
            int dstFaceIndex = dstTopFaceID[1];
            Cube cube = cubes.get(dstCubeCount - 1);
            dstTopFaceID = cube.getDstTopFaceID(dstFaceIndex);
            String result = dstCubeCount + " " + faceNames[dstFaceIndex];
            builtCubes.add(result);
        }
        return builtCubes;
    }
    
    private int[] findTopFaceIDOfAll(List<Cube> cubes) {
        int maxCountOfRelation = 0;
        int[] topFaceID = new int[2];
        for (Cube cube : cubes) {
            for (int i = 0; i < 6; i++) {
                int countOfRelation = cube.getCountOfRelation(i);
                if (maxCountOfRelation < countOfRelation) {
                    maxCountOfRelation = countOfRelation;
                    topFaceID[0] = cube.getCubeCount();
                    topFaceID[1] = i;
                }
            }
        }
        return topFaceID;
    }
    
    private boolean hasNext(int[] topFaceIDOfAllCubes) {
        return topFaceIDOfAllCubes[0] != 0;
    }
    
    private String getAnyTopFaceID() {
        Cube cube = cubes.get(0);
        String stringTopFaceID = cube.getCubeCount() + " " + faceNames[Cube.TOP];
        return stringTopFaceID;
    }
}
