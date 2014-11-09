package jp.level_five.pgcon.building_block;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Associater {

    Map<String, List<String>> relations;
    
    public Associater() {
        relations = new LinkedHashMap<String, List<String>>();
    }

    private List<Cube> createCubes(List<String> cubeColors) {
        List<Cube> cubes = new ArrayList<Cube>();
        for (String cubeColor : cubeColors) {
            Cube cube = new Relation(cubeColor);
            cubes.add(cube);
        }
        return cubes;
    }
    
    public Map<String, List<String>> createAssociations(List<String> cubeColors) {
        List<Cube> cubes = createCubes(cubeColors);
        for (Cube srcCube : cubes) {
            int colorCount = 0;
            for (String srcColor : srcCube.getColors()) {
                String srcFaceID = srcCube.getFaceID(colorCount++);
                ArrayList<String> dstFaceIDList = findSameColors(srcCube.getCubeCount(), srcColor, cubes);
                relations.put(srcFaceID, dstFaceIDList);
            }
        }
        return relations;
    }

    private ArrayList<String> findSameColors(int srcCubeCount, String srcColor, List<Cube> cubes) {
        ArrayList<String> dstColorList = new ArrayList<String>();
        for (int i = srcCubeCount; i < cubes.size(); i++) {
            Cube dstCube = cubes.get(i);
            appendDstColors(srcColor, dstColorList, dstCube);
        }
        return dstColorList;
    }

    private void appendDstColors(String srcColor, ArrayList<String> dstColorList, Cube dstCube) {
        String[] dstColors = dstCube.getColors();
        for (int i = 0; i < dstColors.length; i++) {
            if (srcColor.equals(dstColors[i])) {
                String dstFaceID = dstCube.getFaceID(i);
                dstColorList.add(dstFaceID);
            }
        }
    }
    
}
