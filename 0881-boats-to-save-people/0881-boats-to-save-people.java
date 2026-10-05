class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int first = 0 ;
        int second = people.length-1;;
        int boats = 0 ;
        while(first<=second){
           int total_weight = people[first] + people[second];
           if(total_weight <= limit){
            first++;
           }
           second--;
           boats++;
        }  
        return boats;
    }
}