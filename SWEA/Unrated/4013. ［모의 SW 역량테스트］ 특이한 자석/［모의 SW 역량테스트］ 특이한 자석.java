import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] arr; 
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(br.readLine());
		for(int t=1 ; t<=tc ; t++) {
			map = new int[4][8];
			
		
			int k= Integer.parseInt(br.readLine());
			
			for(int i=0; i<4; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<k ; i++) {
				arr= new int[4];
				st = new StringTokenizer(br.readLine(), " ");
				int idx =Integer.parseInt(st.nextToken())-1;
				int dir=Integer.parseInt(st.nextToken());
				do_rotate(idx,dir);
			}
			
			int total=0;
			
			if(map[0][0]==1) total+=1;
			if(map[1][0]==1) total+=2;
			if(map[2][0]==1) total+=4;
			if(map[3][0]==1) total+=8;
			System.out.println("#"+t+" "+total);
			
		}
	}

	private static void do_rotate(int idx, int dir) {
		// TODO Auto-generated method stub
		arr[idx]=dir;
		
		// 오른쪽
		for(int i=idx+1 ; i<4 ; i++) {
			if(map[i][6]==map[i-1][2]) {
				break;
			}
			else arr[i]= -arr[i-1];
//			System.out.println(arr[i]);
		}
//		print();
		
		//왼쪽
		for(int i=idx-1 ; i>=0 ; i--) {
			if(map[i+1][6] == map[i][2]) {
				break;
			}
			else arr[i] = -arr[i+1];
//			System.out.println(arr[i]);
		}
//		print();
		
		// 돌리기
		for(int i=0; i<4; i++) {
			if(arr[i]==0) continue;
			// 시계
			else if(arr[i] == 1) {
				int tmp=map[i][7];
				for(int j=7 ; j>0 ;j--) {
					map[i][j]=map[i][j-1];
				}
				map[i][0]=tmp;
			}
			// 반시계
			
			else if(arr[i] == -1) {
				
				int tmp=map[i][0];
				for(int j=0; j<7 ; j++) {
					map[i][j]=map[i][j+1];
				}
				map[i][7]=tmp;
			}
		}
		
	}
	static void print() {
		for (int i = 0; i < 4; i++) {
//			System.out.println();
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


}