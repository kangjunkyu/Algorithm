import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(checkD(x1, y1, p1, q1, x2, y2, p2, q2)) {
				System.out.println("d");
			}else if(checkC(x1, y1, p1, q1, x2, y2, p2, q2)) {
				System.out.println("c");
			}else if(checkB(x1, y1, p1, q1, x2, y2, p2, q2)) {
				System.out.println("b");
			}else {
				System.out.println("a");
			}
		}
	}

	private static boolean checkD(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
		// TODO Auto-generated method stub
		if(p1 < x2) return true;
		if(p2 < x1) return true;
		if(y1 > q2) return true;
		if(q1 < y2) return true;
		return false;
	}

	private static boolean checkC(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
		// TODO Auto-generated method stub
		if(x1 == p2 && y1 == q2) return true;
		if(x1 == p2 && q1 == y2) return true;
		if(p1 == x2 && q1 == y2) return true;
		if(p1 == x2 && y1 == q2) return true;
		return false;
	}

	private static boolean checkB(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
		// TODO Auto-generated method stub
		if(x1 == p2) return true;
		if(p1 == x2) return true;
		if(y1 == q2) return true;
		if(q1 == y2) return true;
		return false;
	}
}