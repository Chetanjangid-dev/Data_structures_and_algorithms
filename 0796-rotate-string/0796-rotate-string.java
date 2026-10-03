class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)){
            return true;
        }
        StringBuilder  sb  = new StringBuilder(s);
        s  = s + s;
        // now chekc by using kmp  if goal string exists as an substring  of new s i ye sthen  retur true otheriswe false;
        if(s.indexOf(goal)!=-1) return true;
        return false;
    }
}