package jp.level_five.pgcon.building_block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CubeBuilder {
    
    private Map<String, List<String>> relation;
    private List<String> builtCubes_ = new ArrayList<String>();
    
    public CubeBuilder(List<String> cubeColors) {
        Associater associater = new Associater();
        relation = associater.createAssociations(cubeColors);
    }
    
    public List<String> build() {
        for (String bottomFace : relation.keySet()) {
            List<String> builtCubes = new ArrayList<String>();
            String topFace = getOpositeface(bottomFace);
            builtCubes.add(topFace);
            List<String> relationsToButtom = relation.get(bottomFace);
            next(relationsToButtom, builtCubes);
        }
        return builtCubes_;
    }
    
    private void next(List<String> relationsToButtom, List<String> builtCubes) {
        if (!relationsToButtom.isEmpty()) {
            sortChildren(relationsToButtom, builtCubes);
        } else {
            compare(builtCubes);
        }
    }
    
    private void compare(List<String> builtCubes) {
        if (builtCubes_.size() < builtCubes.size()) {
            builtCubes_ = builtCubes;
        }
        builtCubes = null;
    }
    
    private void sortChildren(List<String> relationsToButtom, List<String> builtCubes) {
        for (String topFace : relationsToButtom) {
            List<String> copyBuiltCubes = new ArrayList<String>(builtCubes);
            copyBuiltCubes.add(topFace);
            String bottomFace = getOpositeface(topFace);
            List<String> relationToBottom = relation.get(bottomFace);
            next(relationToBottom, copyBuiltCubes);
            copyBuiltCubes = null;
        }
        builtCubes = null;
    }
    
    public String getOpositeface(String faceID) {
        String opositeFaceID = null;
        String[] split = faceID.split(" ");
        for (int i = 0; i < Cube.FACE_NAMES.length; i++) {
            if (split[1].equals((Cube.FACE_NAMES[i]))) {
                if (i % 2 == 0) {
                    opositeFaceID = createID(split[0], i + 1);
                } else {
                    opositeFaceID = createID(split[0], i - 1);
                }
            }
        }
        return opositeFaceID;
    }
    
    private String createID(String cubeNumber, int index) {
        return cubeNumber + " " + Cube.FACE_NAMES[index];
    }
}
