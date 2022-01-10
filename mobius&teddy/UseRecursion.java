import java.util.*;

public class UseRecursion {
    public static void main(String[] args) {

        System.out.println("\nPart 1:");
        String s1 = "Hello", s2 = "Java";
        String[] strs = Recursion.mobius(s1, s2);
        for (String s : strs)
            System.out.println(s);

        System.out.println();
        String s3 = "Filthy", s4 = "Frank";
        String[] strs2 = Recursion.mobius(s3, s4);
        for (String s : strs2)
            System.out.println(s);

        System.out.println("\nPart 2:");
        System.out.println("teddy(10,4,2) = " + Recursion.teddy(10, 4, 2));
        System.out.println("teddy(9,5,3) = " + Recursion.teddy(9, 5, 3));
        System.out.println("teddy(15,4,2) = " + Recursion.teddy(15, 4, 2));
        System.out.println("teddy(20,3,5) = " + Recursion.teddy(20, 3, 5));
        System.out.println("teddy(40,5,6) = " + Recursion.teddy(40, 5, 6));
        System.out.println("teddy(30,56,5) = " + Recursion.teddy(30, 56, 5));
        System.out.println("teddy(30,55,4) = " + Recursion.teddy(30, 55, 4));
        System.out.println("teddy(50,100,5) = " + Recursion.teddy(50, 100, 5));
    }

    public static void printArray(int[] digits) {
        for (int i : digits)
            System.out.print(i + " ");
        System.out.println();
    }
}
