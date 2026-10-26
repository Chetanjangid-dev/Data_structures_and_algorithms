class Solution {
    public String multiply(String num1, String num2) {
       if(num1.equals("0") || num2.equals("0")) return "0";
       if(num1.equals("1")) return num2;
       if(num2.equals("1")) return num1;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int[] prev =new int[num1.length() + num2.length()];
        while(p1>=0){
             p2 = num2.length()-1;
             int number = (num1.charAt(p1)-'0');
             int zeroestobeadded= num1.length()-1- p1;
             int carry = 0;
             int index = prev.length - zeroestobeadded-1;
             while(p2>=0){
                int res =number*(num2.charAt(p2) - '0');
                res +=carry;
                res += prev[index];
                carry = 0;
                if(res > 9){
                     carry = res/10;
                     res = res%10;
                }
                prev[index]=res;
                index--;
                p2--;
             }
             while(carry>=1){
                int res = 0;
                res=res+prev[index]+carry;
                carry=0;
                if(res>9){
                    carry = res/10;
                     res = res%10;
                }
                prev[index] = res;
                index--;
             }
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