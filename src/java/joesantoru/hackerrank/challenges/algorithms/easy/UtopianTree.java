package joesantoru.hackerrank.challenges.algorithms.easy;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/utopian-tree
 */
public class UtopianTree {
    public static void main(String[] args) {
        //Enter your code here. Read input from STDIN. Print output to STDOUT
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            boolean first = true;
            while((line=br.readLine())!=null){
                // initial height of 1
                int height = 1;

                // odd cycles - doubles
                // even cycles - +1
                if(!first)
                {
                    // then its the number of cycles
                    for(int i = 1; i<=Integer.parseInt(line); i++)
                    {
                        // if it's even (summer)
                        if( i%2 == 0)
                        {
                            height = height + 1;
                        }
                        else
                        {
                            height = height * 2;
                        }
                    }
                    System.out.println(height);
                }
                first = false;
            }

        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
