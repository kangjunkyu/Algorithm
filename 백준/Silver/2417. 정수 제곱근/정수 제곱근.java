import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	Long N = sc.nextLong();
	
	Long answer = (long) Math.sqrt(N);
	
	if(answer*answer < N) {
		answer++;
	}
	
	System.out.println(answer);
}
}