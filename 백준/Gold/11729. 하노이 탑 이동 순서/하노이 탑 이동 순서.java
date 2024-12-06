import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');
		cnt = 0;
		
		hanoi(N, 1, 2, 3);
		
		
		System.out.println(sb);

	}

	private static void hanoi(int N, int start, int mid, int end) {
//	    System.out.println("Enter: N=" + N + ", start=" + start + ", mid=" + mid + ", end=" + end);

	    if (N == 1) {
//	        System.out.println("Move: " + start + " -> " + end);
	        sb.append(start + " " + end + '\n');
	        return;
	    }

//	    System.out.println("Calling hanoi(N-1, start, end, mid): N=" + (N - 1) + ", start=" + start + ", mid=" + end + ", end=" + mid);
	    hanoi(N - 1, start, end, mid);

//	    System.out.println("Move: " + start + " -> " + end);
	    sb.append(start + " " + end + '\n');

//	    System.out.println("Calling hanoi(N-1, mid, start, end): N=" + (N - 1) + ", start=" + mid + ", mid=" + start + ", end=" + end);
	    hanoi(N - 1, mid, start, end);

//	    System.out.println("Exit: N=" + N + ", start=" + start + ", mid=" + mid + ", end=" + end);
	}

}