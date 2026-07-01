class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || s.length()==0){
            return "";
        }
        HashMap<Character, Integer> t_hash = new HashMap<>();
        HashMap<Character, Integer> s_hash = new HashMap<>();  
        int first=0;
        int second=0;      
        Integer p1=null;
        Integer p2=null;
        int min_wind_len=Integer.MAX_VALUE;
        for (int i=0;i<t.length();i++){
            if(t_hash.containsKey(t.charAt(i))){
                t_hash.put(t.charAt(i),t_hash.get(t.charAt(i))+1 );
            }
            else{
                  t_hash.put(t.charAt(i),1 );
            }
        }
        //we will use a avr that shows if  s string window canotains all the reuired ele of t with freq s>= freq t of all elements
        int approvedtimes=0;
        while(second<s.length()){
           if(s_hash.containsKey(s.charAt(second))){
                s_hash.put(s.charAt(second),s_hash.get(s.charAt(second))+1 );
            }
            else{
                  s_hash.put(s.charAt(second),1 );
            }
            if(t_hash.containsKey(s.charAt(second)) &&  s_hash.get(s.charAt(second)) == t_hash.get(s.charAt(second))){
                approvedtimes+=1;

            }
            //sare elemnt approcved ho chuke h
           while(first<=second && approvedtimes==t_hash.size()){
             if(second-first+1<=min_wind_len){
               p1=first;
               p2=second;
               min_wind_len=second-first+1; 
             }
             s_hash.put(s.charAt(first), s_hash.get(s.charAt(first))-1);
             if(t_hash.containsKey(s.charAt(first))){     
                 if( t_hash.get(s.charAt(first)) > s_hash.get(s.charAt(first)) ){
                        approvedtimes-=1;
                  }
             }
             if(s_hash.get(s.charAt(first))==0 ){
                s_hash.remove(s.charAt(first));
             }
             first+=1; 
           }
        second+=1;
        }
     if(p1==null && p2==null){
        return "";
     }
     return s.substring(p1,p2+1);
    }
}