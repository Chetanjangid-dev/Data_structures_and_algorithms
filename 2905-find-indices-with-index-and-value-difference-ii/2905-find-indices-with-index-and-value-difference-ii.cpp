class Solution {
public:
    vector<int> findIndices(vector<int>& nums, int id, int vd) {
        int n=nums.size();

        vector<int> ans;
        int ind1=0;
        int ind2=0;
        int x=nums[0],y=nums[0];
        //x, ind1->max element record
        //y, ind2->min element record
        for(int i=id;i<n;i++){
            if(nums[i-id] > x){
                x = nums[i-id];
                ind1 = i-id;
            }
            if(nums[i-id] < y){
                y = nums[i-id];
                ind2 = i-id;
            }
            if(abs(nums[i] - nums[ind1])>=vd){
                return {ind1,i};
            }
            if(abs(nums[i] - nums[ind2])>=vd){
                return {ind2,i};
            }
        }
        return {-1,-1};
    }
};