import java.math.BigInteger;
class Solution {
  int[] compare(int a, int b) {

    String s1 = String.valueOf(a);
    String s2 = String.valueOf(b);

    String ab = s1 + s2;
    String ba = s2 + s1;

    if (ba.compareTo(ab) > 0)
        return new int[]{b, a};

    return new int[]{a, b};
}
    public String largestNumber(int[] nums) {
        for(int  i = 0 ; i <nums.length;i++){
          for(int  j = 0 ; j<nums.length-1;j++){
            int[]  ans = compare(nums[j],nums[j+1]);
               nums[j]= ans[0];
               nums[j+1] = ans[1];
          }
        }
        boolean numbercomes = false;
        StringBuilder sb =  new StringBuilder();
        for(int   i =0;i<nums.length-1;i++){
            if(!numbercomes && nums[i] == 0){
                continue;
            }
            numbercomes = true;
            sb.append(nums[i]+"");
        }
        sb.append(nums[nums.length-1]+"");
        return sb.toString();
    }
}