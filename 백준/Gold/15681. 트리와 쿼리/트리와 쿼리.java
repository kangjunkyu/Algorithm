
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, R, Q;
	static ArrayList<Integer>[] list;
	static int[] child;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 트리 정점 수 (간선은 트리 노드 수의 -1)
		R = Integer.parseInt(st.nextToken()); // 루트의 번호(시작점)
		Q = Integer.parseInt(st.nextToken()); // 쿼리의 수(답의 개수)
		
		child = new int[N+1]; // 트리를 돌며 각 값에 대한 정보를 저장할 배열
		list = new ArrayList[N+1]; // 트리
		
		Arrays.fill(child, 1); //모두 1로 초기화
		
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			list[U].add(V);
			list[V].add(U);
		}
		
		check(R, -1); //조건문을 위해 루트노드는 -1로 지정한 후 시작한다.
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < Q; i++) {
			int idx = Integer.parseInt(br.readLine());
			sb.append(child[idx]).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	private static void check(int idx, int parent) {
		//싸이클은 없어야한다
		for(int next : list[idx]) {
			// 다시 부모노드로 돌아가지 않도록 조건문을 건다.
			if(parent != next) {
				check(next, idx);
			}
		}
		if(parent != -1) { //루트노드에서 시작하니까 처음 배열을 제외하곤 모두 아래 조건으로
			child[parent] += child[idx];
		}
	}
}
