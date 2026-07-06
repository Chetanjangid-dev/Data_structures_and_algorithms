var minDays = function(bloomDay, m, k) {
      if((m*k)>bloomDay.length){
        return -1
      }
      let low=1
      let high=Math.max(...bloomDay)
      while(low<high){
        let mid=Math.floor((low+high)/2)
        let flowerscollected=0
        let grps=0
        for(let i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                flowerscollected+=1
            }
            else{
                grps+=Math.floor(flowerscollected/k)
                flowerscollected=0
            }
        }
        grps+=Math.floor(flowerscollected/k)
        if(grps<m){
            low=mid+1
        }
        else{
            high=mid
        }
      }
      return low
};