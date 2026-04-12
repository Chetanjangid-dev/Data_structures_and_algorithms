var longestPalindrome = function(s) {
  let hashmap=new Map();
  let max_len=0
  let max_odd_number=0
  let hasodd=0
  for (let i=0;i<s.length;i++){
    hashmap.set(s[i],(hashmap.get(s[i])||0)+1)
  }
  for(let freq of hashmap.values()){
    if (freq%2===0 && freq>0){
        max_len+=freq
    }
    else{
    max_len+=(freq-1)
   hasodd=1
    }
  }
  if (hasodd){
    return max_len+1
  }
  else{
    return max_len
  }
};
