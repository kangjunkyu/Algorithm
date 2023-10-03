
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	int sugar = sc.nextInt();
	int count = 0;
	
	while(true) {
		if(sugar% 5 == 0) {
			count += sugar/5;
			System.out.println(count);
			break;
		}if(sugar < 3) {
			System.out.println(-1);
			break;
		}
		sugar-=3;
		count++;
	}
	}
}