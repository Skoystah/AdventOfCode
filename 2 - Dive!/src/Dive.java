import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dive {
    public static void main(String[] args) throws IOException {

        BufferedReader objReader = new BufferedReader(new FileReader("/Users/geertdooms/Documents/repos/AdventOfCode/2 - Dive!/src/input.txt"));
        List<Bearing> readings = new ArrayList<>();

        String input;
        String[] line;

        while ((input = objReader.readLine()) != null) {
            line = input.split(" ");
            readings.add(new Bearing(line[0],Integer.parseInt(line[1])));
        }

        int horizontal = 0;
        int depth  = 0;
        int aim = 0;

        for (Bearing bearing : readings) {
            switch (bearing.getAction()) {
                case "forward":
                    horizontal += bearing.amount;
                    depth+= bearing.amount * aim;
                    break;
                case "down":
                    aim += bearing.amount;
                    break;
                case "up":
                    aim -= bearing.amount;
                    break;
            }
            if (depth <= 0) {
                System.out.println("uhoh going above water" + depth);
            }
        }

        System.out.println(horizontal*depth );

    }
}

