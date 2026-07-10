var partition = function(s) {
  function checkifpalindrome(str) {
    let l = 0, r = str.length - 1;
    while (l < r) {
      if (str[l] !== str[r]) return false;
      l++; r--;
    }
    return true;
  } 
let pointer=0
let str=[]
let res=[]
function backtrack(pointer,str){
  // base case
  if (pointer===s.length){
    res.push([...str])
    return
  }
  let ch=""
  let p=pointer
  while (p < s.length){
    ch+=s[p]
    if(checkifpalindrome(ch)){
      str.push(ch)
      // palindrome milte hi
      backtrack(p+1,str)
      ch=str.pop()
    }
    p+=1
  }
  
} 
backtrack(pointer,str)
return res
};