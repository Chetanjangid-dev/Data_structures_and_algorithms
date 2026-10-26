class Solution {
    int[] concatenate(int[] curr,int[] prev){        
        int p1 = curr.length-1;
        int p2 = prev.length-1;
        int carry  = 0;
        while(p1>=0 && p2>=0){
            int res  = curr[p1] + prev[p2] + carry;
            carry = 0;
            if(res>9){
                carry = res/10;
                res = res%10;
            }
            curr[p1]=res;
            p1--;
            p2--;
        }
        while(carry>0 && p1>=0){
            curr[p1] = carry + curr[p1];
            carry = 0;
            if(curr[p1]>9){
                carry = curr[p1]/10;
                curr[p1] = curr[p1]%10;
            }
            p1--;
        }
        return curr;
    }
    public String multiply(String num1, String num2) {
       if(num1.equals("0") || num2.equals("0")) return "0";
       if(num1.equals("1")) return num2;
       if(num2.equals("1")) return num1;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int[] prev =new int[num1.length() + num2.length()];
        while(p1>=0){
             p2 = num2.length()-1;
             StringBuilder sb  =  new StringBuilder();
             int[] curr =  new int[prev.length];
             int i = curr.length-1;
             int zeroestobeadded= num1.length()-1- p1;
             while(zeroestobeadded >0){
                curr[i] = 0;
                i--;
                zeroestobeadded--;
             }
             int carry = 0;
             while(p2>=0){
                int intermediate = (num1.charAt(p1)-'0')*(num2.charAt(p2) - '0');
                intermediate +=carry;
                carry = 0;
                if(intermediate > 9){
                     carry = intermediate/10;
                     intermediate = intermediate%10;
                }
                curr[i]=intermediate;
                i--;
                p2--;
             }
             if(carry >=1 ){
                 curr[i]=carry;
             }
             //System.out.println("adding "+prev+" and "+curr);
             prev = concatenate(prev,curr);
             p1--;
        }
        boolean onetimenonzerocomes = false;
        StringBuilder sb =  new StringBuilder();
        for(int  i = 0 ;i<prev.length ;i++){
            if(prev[i] == 0 && onetimenonzerocomes == false) continue;
            sb.append(prev[i]+"");
            onetimenonzerocomes =true;
        }
        return sb.toString();
    }
}