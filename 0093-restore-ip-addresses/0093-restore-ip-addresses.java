class Solution {
    List<String> ans ;
    StringBuilder sb;
    String s;
    boolean valid(int i,int j){
       if(j-i+1<=1) return true;
       //leadning zero check
       if(s.charAt(i) == '0') return false;
       //len check
       if(j-i+1>3) return false;
       int n  = Integer.parseInt(s.substring(i,j+1));
       if(n>=0 && n<=255 ) return true;
       return false;
    } 
    void combo(int i,int dots){
        if(i== s.length()) return ;
        if(dots == 0 && valid(i,s.length()-1)){
            String temp = s.substring(i,s.length());
            sb.append(temp);
            ans.add(sb.toString());
            sb.delete(sb.length()-temp.length(),sb.length());
            return ;
        }

        if(i<s.length()-1){
          sb.append(s.charAt(i)+""+".");
          combo(i+1,dots-1);
          sb.delete(sb.length()-2,sb.length());
        }
        if(i+1<s.length()-1 && valid(i,i+1)){ 
         sb.append(s.charAt(i)+""+s.charAt(i+1)+".");
         combo(i+2,dots-1);
         sb.delete(sb.length()-3,sb.length());
        }
        if(i+2<s.length()-1 &&  valid(i,i+2) ){
         sb.append(s.charAt(i)+""+s.charAt(i+1)+""+s.charAt(i+2)+".");
         combo(i+3,dots-1);
         sb.delete(sb.length()-4,sb.length());
        } 
        return ;
    }
    public List<String> restoreIpAddresses(String s) {
        this.s=s;
        this.ans =  new ArrayList<>();
        this.sb = new StringBuilder();
        combo(0,3);
        return ans;
    }
}