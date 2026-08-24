class Solution {
    public int hIndex(int[] citations) {
        int low,high,mid,papers,h_index;
        low = 0;
        high = citations.length-1;
        while(low<high){
            mid = (low+high)/2;
            papers = citations.length-mid;
           if(citations[mid] < papers){
               low = mid+1;
           }
           else{
               high = mid;
           }
        }
         papers = citations.length-low;
        if(citations[low]<papers){
            return citations[low];
        }
        return papers;
    }
}



//jb hum mid nikal rhe tb hum dekh rhe kya hamara arr[mid] no of papers se jyada ya qual h kya if i fyes then the  papers is a vlaid  ciattions 

//but jaruri thodi yhi papers final h index ho ho ksta h left side me hume  papers k eaul arr[mid] mile ya same curr jese duplaucte mile isse apapers increse honge jo ki eventully decide krta h h inde xkp so better ans csn be on left side but since the mid is vaid so we weill keep it by high=mid  ab agr letf me lete hi manlo ki hamre arr[mid] no of papers se km ho thebn iska mtlb ki curr no of apers can be valid bcz we dont have papers which have ciations>=papers  so the curr mid cant be answer = so just remove it by low= mid+1; ad ho ksta right me jake even hamre no of apeprs km ho jaye but hammre un papers ki ciations atleats papers k equla  ya juada ho ksti h bcz right side e arr[mid] bdh rha h and apers km ho rhe 

//and jb lopp end hoga tb bbhi hum dkehnge ki kya no of papers >cictiaons[low] se to ciations [low]hi h index hogi kyuki hamre pass atleast ciatiosn[low] papers h jinki ciation atelst ciatiobbs[low] h and agr cciations[low] jayfda h no of paers km to no of paers will e beh index bcz we w have sstlreast papers paers which have atkeats papers ciations 