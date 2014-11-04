package jp.level_five.pgcon.building_block;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(reader.readLine());
            List<Cube> cubes = new LinkedList<Cube>();
            for (int i = 0; i < count; i++) {
                String string = reader.readLine();
                String[] sides = string.split(" ");
                cubes.add(new Cube(sides));
            }
            CubeBuilder cubeBuilder = new CubeBuilder(cubes);
            List<String> builtCubes = cubeBuilder.getBuiltCubes();
            
            System.out.println(builtCubes.size());
            for (String cubeFaceData : builtCubes) {
                System.out.println(cubeFaceData);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
