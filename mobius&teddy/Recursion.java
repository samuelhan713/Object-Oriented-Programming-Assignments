import java.util.Arrays;
public class Recursion {
  
    //Part 1 MOBIUS
  
    public static boolean isEven(int n) {
        return (n % 2 == 0);
    }

    static int x = 1;
    static String[] array;
    public static String[] mobius(String s1, String s2) {
        String combinedString = s1 + s2;
        if (x == 1) {
            array = new String[combinedString.length()];
            array[0] = combinedString;
        }
        if (x < combinedString.length()) {
            array[x] = helperMethod(combinedString, x++);
            mobius(s1, s2);
        }
        x = 1;
        return array;
    }

    public static String helperMethod(String str, int x) { //performs the actual cycling of the letters in the string
        return str.substring(x) + str.substring(0, x);
    }

  
    //Part 2 TEDDY BEAR GAME
  
    /*
    You start with a given number of teddy bears.
    Each step of the game you have the choice to do one of the following options:
            1.) Receive "X" increment bears.
            2.) Get rid of "X" increment of your bears.
            3.) If you have an even amount of bears, you can get rid of exactly half of yours bears.
		4.) If you have an even number of bears, you can get an additional number of bears equal to half your current number of bears (* 1.5)
		*If you fail to obtain the goal within 10 steps, the method returns -1.
            * Otherwise, return the total amount of steps required to get the desired amount of bears.
     */

    static int count = 0;
    public static int teddy(int initial, int goal, int increment) {

        if (helperMethod(initial, goal, increment, count) && count <= 10) {
            return count;
        } else if (count >= 10) {
            count = 0;
            return -1;
        } else {
            count++;
            return teddy(initial, goal, increment);
        }
    }

    public static boolean helperMethod(int initial, int goal, int increment, int n) {
        if (initial == goal) {
            return true;
        } else if (n == 0) {
            return false;
        } else if (helperMethod(initial + increment, goal, increment, n-1)) {
            return true;
        } else if (helperMethod(initial-increment, goal, increment, n-1)) {
            return true;
        } else if (isEven(initial) && helperMethod(initial/2, goal, increment, n-1)) {
            return true;
        } else if (isEven(initial) && helperMethod(initial + initial/2, goal, increment, n-1)) {
            return true;
        } else {
            return false;
        }
    }
}

