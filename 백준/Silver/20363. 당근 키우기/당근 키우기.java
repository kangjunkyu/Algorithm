import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); 
		int y = Integer.parseInt(st.nextToken());  
		
		System.out.println((int)(Math.floor(x + y + (Math.min(x, y) / 10))));
	}

}