import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sonar {
    public static void main(String[] args) throws IOException {

        BufferedReader objReader = new BufferedReader(new FileReader("/Users/geertdooms/Documents/repos/AdventOfCode/1 - Sonar Sweep/src/input.txt"));
        List<Integer> readings = new ArrayList<>();

        String input;

        while ((input = objReader.readLine()) != null) {
            readings.add(Integer.parseInt(input));
        }

        int count = 0;

        for (int i = 3; i < readings.size(); i++) {
            if ((readings.get(i - 2) + readings.get(i - 1) + readings.get(i)) >
                    (readings.get(i - 3) + readings.get(i - 2) + readings.get(i - 1))) {
                count ++;
            }

        }

        System.out.println(count);

    }
}
