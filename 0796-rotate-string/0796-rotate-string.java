class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)){
            return true;
        }
         StringBuilder  sb  = new StringBuilder(s);
        int rotation_limit = s.length()-1;
        for(int i = 1 ; i<= rotation_limit ;i++){
            char rem = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(rem);
            System.out.println("comparing  "+goal+" and "+sb.toString());
            if(goal.equals(sb.toString())){

                return true;
            }
        } 
        return false;
    }
}