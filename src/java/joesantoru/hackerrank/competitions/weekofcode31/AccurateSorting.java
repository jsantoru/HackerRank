package joesantoru.hackerrank.competitions.weekofcode31;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/contests/w31/challenges/accurate-sorting
 */
public class AccurateSorting {
    public static void main(String[] args) {
        AccurateSorting solution = new AccurateSorting();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }

            solution.processLine(a);

            if(solution.inOrder(a)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }

    private boolean inOrder(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(i != 0) {
                if(array[i-1] != array[i] - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void processLine(int[] array) {
        boolean swappedAny = false;
        int prev = array[0];
        for(int i = 0; i < array.length; i++) {
            int curr = array[i];

            // if they're out of order, swap if we can
            if(prev > curr && isSwappable(prev, curr)) {
                array[i-1] = curr;
                array[i] = prev;
                swappedAny = true;
            }
            prev = array[i];
        }

        if(swappedAny) {
            processLine(array);
        }
    }

    private boolean isSwappable(int prev, int curr) {
        if(prev - curr == 1) {
            return true;
        }
        return false;
    }
}
