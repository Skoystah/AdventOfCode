import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bingo {
    public static void main(String[] args) throws IOException {

        BufferedReader objReader = new BufferedReader(new FileReader("/Users/geertdooms/Documents/repos/AdventOfCode/3 - Binary Diagnostic/src/input.txt"));
        List<String> readings = new ArrayList<>();

        String input;

        while ((input = objReader.readLine()) != null) {
            readings.add(input);
        }

        int readingsLength = readings.get(0).length();

        int[] ones = new int[readingsLength];
        for (int i : ones) {
            i = 0;
        }

        for (String reading : readings) {
            for (int i = 0; i < readingsLength; i++) {
                if (reading.charAt(i) == '1') {
                    ones[i]++;
                }
            }
        }

        char[] gamma = new char[ones.length];
        char[] epsilon = new char[ones.length];

        for (int i = 0; i < ones.length; i++) {
            if (ones[i] > readings.size()/2) {
                gamma[i] = '1';
                epsilon[i] = '0';
            } else {
                gamma[i] = '0';
                epsilon[i] = '1';
            }
        }
        int gammavalue = Integer.parseInt(String.valueOf(gamma), 2);
        int epsilonvalue = Integer.parseInt(String.valueOf(epsilon), 2);
        System.out.println(gammavalue*epsilonvalue );

    }
}

