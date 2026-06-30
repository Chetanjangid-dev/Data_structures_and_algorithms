class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
     Set<Integer> set1 = new HashSet<>();
     Set<Integer> set2 = new HashSet<>();
    List<Integer> res=new ArrayList<>();
    for(int i=0;i<nums1.length;i++){
        set1.add(nums1[i]);
    }//n time and n space 
    for(int i=0;i<nums2.length;i++){
        set2.add(nums2[i]);
    }  // n time and n space
    for(int x: set1){
        if(set2.contains(x)){
         res.add(x);
        }
    }
    int[] arr=new int[res.size()];
    for(int i=0;i<res.size();i++){
        arr[i]=res.get(i);
    }
    return arr;
    }
}