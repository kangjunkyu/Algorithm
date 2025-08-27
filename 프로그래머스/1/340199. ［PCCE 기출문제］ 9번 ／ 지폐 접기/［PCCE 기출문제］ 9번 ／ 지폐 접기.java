class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletSmall = 0;
        int walletLarge = 0;
        int billSmall = 0;
        int billLarge = 0;
        
        walletSmall = Math.min(wallet[0], wallet[1]);
        walletLarge = Math.max(wallet[0], wallet[1]);
        billSmall = Math.min(bill[0], bill[1]);
        billLarge = Math.max(bill[0], bill[1]);
        
        
        while(true){
            if(walletLarge < billLarge || walletSmall < billSmall) { 
                billLarge /= 2;
                answer ++;
            }
            if(billLarge < billSmall){ 
                int temp = billLarge;
                billLarge = billSmall;
                billSmall = temp;
            }
            
            if(walletSmall >= billSmall && walletLarge >= billLarge){
                break;
            }
        }
        
        return answer;
    }
}