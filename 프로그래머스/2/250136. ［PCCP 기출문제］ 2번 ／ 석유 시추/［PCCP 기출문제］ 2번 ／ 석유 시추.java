import java.util.*;

class Solution {
    
    static class Node {
        int x;
        int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] oil;
    static boolean[][] check;
    static int[][] land;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        oil = new int[N][M];
        check = new boolean[N][M];
        
        // land = new int[N][M];
        // land 배열 초기화
        this.land = land;
        
        int oilId = 0;
        
        Map<Integer, Integer> oilSize = new HashMap<>();
        
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < M; j++){
                if(land[i][j] == 1 && !check[i][j]){
                    int size = bfs(i, j, oilId);
                    oilSize.put(oilId, size);
                    oilId++;
                }
            }
        }

        int[] oilSum = new int[M];
        
        for (int j = 0; j < M; j++) {  
            Set<Integer> oilSet = new HashSet<>();  
            for (int i = 0; i < N; i++) {  
                if (land[i][j] == 1) {  
                    oilSet.add(oil[i][j]);  
                }  
            }  
            for (int id : oilSet) {  
                oilSum[j] += oilSize.get(id);  
            }  
        }
        Arrays.sort(oilSum);
  
        return oilSum[M-1];  
        
    }
    
    public static int bfs(int x, int y, int id){
        Queue<Node> que = new LinkedList<>();
        
        que.add(new Node(x,y));
        check[x][y] = true;
        int size = 1;
        oil[x][y] = id;
        
        while(!que.isEmpty()){
           Node now = que.poll();  
            for (int i = 0; i < 4; i++) {  
                int nx = now.x + dx[i];  
                int ny = now.y + dy[i];  
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && land[nx][ny] == 1  
                    && !check[nx][ny]) {  
                    que.offer(new Node(nx,ny));  
                    check[nx][ny] = true;  
                    oil[nx][ny] = id;  
                    size++;  
                }  
            }  
        }
        
        return size;
    }
}
