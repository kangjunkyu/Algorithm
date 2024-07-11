import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }else{
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
            
        int bookingLength = book_time.length;
        int[][] time = new int[bookingLength][2];
        for(int i = 0; i < bookingLength; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            //청소시간 10분 추가
            end += 10;
            //만약 청소 시간을 포함한 시간이 60분을 초과한다면 +40을 해줘야 시간이 바뀐다.
            //여기서 질문하는 사람이 많은데 시를 담당하는 부분은 나머지 연산자 100을 할 경우 분만 남게 된다.
            if(end%100 > 60){
                end += 40;
            }
            
            time[i][0] = start;
            time[i][1] = end;
        }
        
        //이제 청소시간을 더한 후 int로 전환된 룸 예약시간이 time 배열에 저장이 되었다.
        //그럼 이제 몇개의 방이 필요한지를 세는 로직이 필요한데 이는 생각보다 간단하다.
        
        ArrayList<Integer> needRoom = new ArrayList<>();
        for(int i = 0; i < bookingLength; i++){
    // 배열을 돌 때마다 필요 방의 종료 시간을 정렬시켜서 가장 빨리 끝나는 방을 먼저 확인할 수 있도록 함
           Collections.sort(needRoom);
    
    // 예약이 이미 찼는지 확인
            boolean check = false;

    for (int j = 0; j < needRoom.size(); j++) {
        // 현재 예약 시작 시간이 가장 빨리 끝나는 방의 종료 시간 이후라면
        if (time[i][0] >= needRoom.get(j)) {
            // 해당 방의 종료 시간을 현재 예약의 종료 시간으로 업데이트
            needRoom.set(j, time[i][1]);
            check = true;
            break;
            }
        }
            if (!check) {
                // 현재 예약을 수용할 수 있는 빈 방이 없다면 새로운 방 추가
                needRoom.add(time[i][1]);
            }
            
        }
        answer = needRoom.size();
        return answer;
    }
}