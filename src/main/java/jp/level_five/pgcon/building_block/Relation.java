package jp.level_five.pgcon.building_block;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Relation {
    
    private List<Cube> cubes_;
    private LinkedHashMap<String, List<String>> relation_ = new LinkedHashMap<String, List<String>>();
    
    public LinkedHashMap<String, List<String>> create(List<Cube> cubes) {
        cubes_ = cubes;
        for (Cube lightCube : cubes_) {
            sortLightCubes(lightCube);
        }
        return relation_;
    }
    
    private void sortLightCubes(Cube lightCube) {
        String[] faceColors = lightCube.getFaceColors();
        for (int i = 0; i < 6; i++) {
            String parentFaceID = createID(lightCube, i);
            String faceColor = faceColors[i];
            sortHeavierCubes(lightCube.getNumber(), parentFaceID, faceColor);
        }
    }
    
    private void sortHeavierCubes(int cubeNumber, String faceID, String faceColor) {
        for (int i = cubeNumber; i < cubes_.size(); i++) {
            Cube heavier = cubes_.get(i);
            findSameFace(faceID, faceColor, heavier);
        }
    }
    
    private void findSameFace(String lightFaceID, String lightFaceColor, Cube heavierCube) {
        String[] heavierFaceColors = heavierCube.getFaceColors();
        for (int i = 0; i < 6; i++) {
            if (lightFaceColor.equals(heavierFaceColors[i])) {
                String heavierFaceID = createID(heavierCube, i);
                createRelation(lightFaceID, heavierFaceID);
            }
        }
    }
    
    private void createRelation(String parentID, String childID) {
        List<String> children = relation_.get(parentID);
        if (children == null) {
            children = new ArrayList<String>();
        }
        children.add(childID);
        relation_.put(parentID, children);
    }
    
    private String createID(Cube cube, int index) {
        return cube.getNumber() + " " + CubeBuilder.FACE_NAMES[index];
    }
}
