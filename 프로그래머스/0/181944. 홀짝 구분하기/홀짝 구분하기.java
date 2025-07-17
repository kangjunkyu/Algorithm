import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s;
        if(n % 2 == 0){
            s = n +  " is even";
        }else {
            s = n+ " is odd";
        }
        System.out.print(s);
    }
}