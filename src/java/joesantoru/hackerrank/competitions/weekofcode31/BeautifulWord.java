package joesantoru.hackerrank.competitions.weekofcode31;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/contests/w31/challenges/beautiful-word
 */
public class BeautifulWord {
    private static final Set VOWELS = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    // Print 'Yes' if the word is beautiful or 'No' if it is not.
    public static void main(String[] args) {
        char prev = ' ';

        Scanner in = new Scanner(System.in);
        String w = in.next();
        char[] letters = w.toCharArray();

        String isBeautiful = "Yes";
        for(char letter : letters) {
            if(letter == prev) {
                isBeautiful = "No";
            }
            else if(VOWELS.contains(letter) && VOWELS.contains(prev)) {
                isBeautiful = "No";
            }
            prev = letter;
        }

        System.out.println(isBeautiful);
    }
}
