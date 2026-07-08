class Solution {
    public int scheduleCourse(int[][] courses) {
        int completed=0;
        int currentday=0;
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
       PriorityQueue<int[]> h = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for(int i=0;i<courses.length;i++){
            if(courses[i][0]+currentday<=courses[i][1]){
                currentday+=courses[i][0];
                h.offer(new int[]{courses[i][0],courses[i][1]} );
                completed++;
            }
            else{
                if(h.isEmpty()==false && h.peek()[0]>=courses[i][0]){
                  //dont need to increse or decrese course i just replced the course with  less reuireddays and high deadline
                  currentday-=h.poll()[0];
                  currentday+=courses[i][0];
                  h.offer(new int[]{courses[i][0],courses[i][1]});
                }
                else{
                    //skip the course if you dont find a completd course with high reuired days then currnet
                    continue;
                }
            }
        }
        return completed;
    }
}