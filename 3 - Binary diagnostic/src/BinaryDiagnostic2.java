import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryDiagnostic2 {
    public static void main(String[] args) throws IOException {

        BufferedReader objReader = new BufferedReader(new FileReader("/Users/geertdooms/Documents/repos/AdventOfCode/3 - Binary Diagnostic/src/input.txt"));
        List<String> readings = new ArrayList<>();

        String input;

        while ((input = objReader.readLine()) != null) {
            readings.add(input);
        }

        int readingsLength = readings.get(0).length();

        List<String> oxygen = new ArrayList<>(readings);
        List<String> co2 = new ArrayList<>(readings);

        int i = 0;
        int oneCount, zeroCount;

        while (oxygen.size() > 1) {

            oneCount = 0;
            zeroCount = 0;

            for (String o : oxygen) {
                if (o.charAt(i) == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            int j = i;

            if (oneCount >= zeroCount) {
                oxygen = oxygen.stream().filter(o -> o.charAt(j) == '1').collect(Collectors.toList());
            } else {
                oxygen = oxygen.stream().filter(o -> o.charAt(j) == '0').collect(Collectors.toList());
            }

            i++;
        }

        i = 0;

        while (co2.size() > 1) {
            oneCount = 0;
            zeroCount = 0;

            for (String c : co2) {
                if (c.charAt(i) == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }

            int j = i;

            if (oneCount >= zeroCount) {
                co2 = co2.stream().filter(c -> c.charAt(j) == '0').collect(Collectors.toList());
            } else {
                co2 = co2.stream().filter(c -> c.charAt(j) == '1').collect(Collectors.toList());
            }

            i++;
        }

        int oxygenRating = Integer.parseInt(String.valueOf(oxygen.get(0)), 2);
        int co2Rating = Integer.parseInt(String.valueOf(co2.get(0)), 2);
        System.out.println(oxygenRating*co2Rating );

    }
}

