package org.codeForces.nvl800;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/*It seems like the year of 2013 came only yesterday. Do you know a curious fact? The
year of 2013 is the first year after the old 1987 with only distinct digits.

Now you are suggested to solve the following problem: given a year number, find the
minimum year number which is strictly larger than the given one and has only distinct digits.
 */
public class BeautifulDay {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int year= leer.nextInt();

        while (true){
            year+=1;
            int m = year/1000;
            int c = year / 100 % 10;
            int d = year / 10 % 10;
            int u = year % 10;

            if (m!=c && m!=d && m!=u && c!=d && c!=u && d!=u){
                System.out.println(year);
                break;
            }
        }




    }
}
