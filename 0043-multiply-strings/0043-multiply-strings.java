class Solution {
    String concatenate(String str1,String str2){
        if(str1.equals("0")) return str2;
        if(str2.equals("0")) return str1;
        int p1 = str1.length()-1;
        int p2 = str2.length()-1;
        int carry =0;
         StringBuilder sb =  new StringBuilder();
        while(p1 >=0 && p2>=0){
           
            int res = (str1.charAt(p1) - '0')+(str2.charAt(p2) - '0');
            res+=carry;
            carry=0;
            if(res>9){
                carry=1;
                res-=10;
            }
            sb.append(res+"");
            p1--;
            p2--;
        }
        while(p1>=0){
            int res = (str1.charAt(p1) - '0')+(carry);
            carry=0;
            if(res>9){
                carry=1;
                res-=10;
            }
            sb.append(res+"");
            p1--;
        }
        while(p2>=0){
            int res = (str2.charAt(p2) - '0')+(carry);
            carry=0;
            if(res>9){
                carry=1;
                res-=10;
            }
            sb.append(res+"");
            p2--;
        }
        if(carry == 1) sb.append("1");
        return sb.reverse().toString();
    }
    public String multiply(String num1, String num2) {
       if(num1.equals("0") || num2.equals("0")) return "0";
       if(num1.equals("1")) return num2;
       if(num2.equals("1")) return num1;
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        String prev = "0";
        while(p1>=0){
             p2 = num2.length()-1;
             StringBuilder sb  =  new StringBuilder();
             int carry = 0;
             while(p2>=0){
                int intermediate = (num1.charAt(p1)-'0')*(num2.charAt(p2) - '0');
                intermediate +=carry;
                carry = 0;
                if(intermediate > 9){
                     carry = intermediate/10;
                     intermediate = intermediate%10;
                }
                sb.append(intermediate+"");
                p2--;
             }
             if(carry >=1 ){
                sb.append(carry+"");
             }
             sb = sb.reverse();
             for(int  i = 0 ;i<(num1.length()-1)-p1;i++){
                sb.append("0");
             }
             String curr = sb.toString();
             System.out.println("adding "+prev+" and "+curr);
             prev = concatenate(prev,curr);
             System.out.println("go res = "+prev);
             p1--;
        }
        return prev;
    }
}