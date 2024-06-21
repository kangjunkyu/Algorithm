import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashSet<String> keySet = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            keySet.add(br.readLine());
        }
        
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(",");
            
            for (String s : str) {
                if (keySet.contains(s)) {
                    keySet.remove(s);
                    N--;
                }
            }
            bw.write(N + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}