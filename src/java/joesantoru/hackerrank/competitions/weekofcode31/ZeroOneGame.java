package joesantoru.hackerrank.competitions.weekofcode31;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/contests/w31/challenges/zero-one-game
 */
public class ZeroOneGame {
    private static final String PLAYER_BOB = "Bob";
    private static final String PLAYER_ALICE = "Alice";

    public static void main(String[] args) {
        ZeroOneGame solution = new ZeroOneGame();
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] sequence = new int[n];
            for(int sequence_i=0; sequence_i < n; sequence_i++){
                sequence[sequence_i] = in.nextInt();
            }

            // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
            String currentWinner = solution.processSequence(sequence);
            System.out.println(currentWinner);
        }
    }

    private String processSequence(int[] sequence) {
        String currentWinner = PLAYER_BOB;
        if(sequence.length > 2) {
            int prevLeftIndex = 0;
            int leftIndex = 0;
            for (int i = 1; i < sequence.length-1; i++) {
                int prevLeft = sequence[prevLeftIndex];
                int left = sequence[leftIndex];
                int right = sequence[i+1];

                if(left == 0 && right == 0) {
                    currentWinner = toggleCurrentWinner(currentWinner);

                    // now that we got rid of one, see if we can now get rid of the "left"
                    if(leftIndex > 0 && prevLeftIndex != leftIndex) {
                        if(prevLeft == 0 && right == 0) {
                            currentWinner = toggleCurrentWinner(currentWinner);
                            leftIndex = prevLeftIndex;
                        }
                    }
                }
                else {
                    prevLeftIndex = leftIndex;
                    leftIndex = i;
                }
            }
        }
        return currentWinner;
    }

    private String toggleCurrentWinner(String currentWinner) {
        return PLAYER_BOB.equals(currentWinner) ? PLAYER_ALICE : PLAYER_BOB;
    }
}
