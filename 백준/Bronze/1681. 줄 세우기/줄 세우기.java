import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String NOT_INCLUDED_NUM;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //학생 수와 포함되면 안될 수를 받는다.
        int studentNum = Integer.parseInt(st.nextToken());
        NOT_INCLUDED_NUM = st.nextToken();
        //결과로 출력할 count를 만든다.
        int count = 0;
        
        //학생을 모두 확인할 때 까지 카운트는 증가한다.
        while (studentNum>0){
            count++;
            
            //만약 카운트에 제외를 할 수가 포함되어 있다면, 학생수는 감소시킨다.
            if (!String.valueOf(count).contains(NOT_INCLUDED_NUM)){
                studentNum--;
            }
        }
        // 총 몇번을 확인했는지 출력한다. 그건 제일 큰 수가 될테니까.
        // 하나하나 확인하려면 배열을 만들어서 넣어야겠지?
        System.out.print(count);
    }

}