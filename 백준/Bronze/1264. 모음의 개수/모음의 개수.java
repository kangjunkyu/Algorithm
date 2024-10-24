import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch;
        char[] array = {'a','e','i','o','u'};

        while(true){
            String line = sc.nextLine();
            int cnt = 0;

            if (line.equals("#")){
                break;
            }

            for (int i = 0; i<line.length(); i++){
                line = line.toLowerCase();
                ch = line.charAt(i);


                for(char element : array){
                    if(element == ch){
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }
}