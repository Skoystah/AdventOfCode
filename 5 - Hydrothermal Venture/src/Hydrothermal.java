import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hydrothermal {
    public static void main(String[] args) throws IOException {

        BufferedReader objReader = new BufferedReader(new FileReader("/Users/geertdooms/Documents/repos/AdventOfCode/5 - Hydrothermal Venture/src/input.txt"));

        String input;
        int[][] coordinates = new int[999][999];

        //read and process coordinates
        while ((input = objReader.readLine()) != null) {
            if (!input.isBlank()) {

                int[] line = Arrays.stream(input.trim().split("[^\\d]+")).mapToInt(s -> Integer.parseInt(s)).toArray();

                //consider only horizontal or vertical lines
                if (line[0] == line[2]) {
                    if (line[1] < line[3]) {
                        for (int j = line[1]; j <= line[3] ; j++) {
                            coordinates[line[0]][j] ++;
                        }
                    } else {
                            for (int j = line[3]; j <= line[1] ; j++) {
                                coordinates[line[0]][j] ++;
                            }
                    }
                } else {
                    if (line[1] == line[3]) {
                        if (line[0] < line[2]) {
                            for (int i = line[0]; i <= line[2]; i++) {
                                coordinates[i][line[1]]++;
                            }
                        } else {
                            for (int i = line[2]; i <= line[0]; i++) {
                                coordinates[i][line[1]]++;
                            }
                        }
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 999; i++) {
            for (int j = 0; j < 999; j++) {
                if (coordinates[i][j] > 1) {
                    count++;
                }
            }
        }

        System.out.println("number of points is :" + count);
    }
}

