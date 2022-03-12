import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bingo {
    public static void main(String[] args) throws IOException {

        BufferedReader objReader = new BufferedReader(new FileReader("/Users/geertdooms/Documents/repos/AdventOfCode/4 - Giant Squid/src/input.txt"));
        List<Board> boards = new ArrayList<>();

        //read bingo draws
        int [] draws = Arrays.stream(objReader.readLine().split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();

        objReader.readLine();
        String input;

        //read bingo boards
        while ((input = objReader.readLine()) != null) {
            if (!input.isBlank()) {
                int[][] newBoard = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    int[] newRow = Arrays.stream(input.trim().split("\\s+")).mapToInt(s -> Integer.parseInt(s)).toArray();
                    for (int j = 0; j < 5; j++) {
                        newBoard[i][j] = newRow[j];
                    }
                    input = objReader.readLine();
                }
                boards.add(new Board(newBoard));
            }
        }

        //perform bingo draw
        int boardsWon = 0;

        outerloop:
        for (int d : draws) {
            for (Board b : boards) {
                if (b.hasWon != true) {
                    if (b.checkHasWon(d)) {
                        System.out.println("Winner! Value " + b.boardValue() * d);
                        boardsWon++;
                        //break outerloop;
                    }
                }
            }
            if (boardsWon == boards.size()) {
                break outerloop;
            }
        }
    }
}

