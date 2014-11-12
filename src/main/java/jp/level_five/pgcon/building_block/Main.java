package jp.level_five.pgcon.building_block;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = Integer.parseInt(reader.readLine());
            List<String> cubeColors = new ArrayList<String>();
            for (int i = 0; i < count; i++) {
                String string = reader.readLine();
                cubeColors.add(string);
            }
            CubeBuilder cubeBuilder = new CubeBuilder(cubeColors);
            List<String> builtCubes = cubeBuilder.build();
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
