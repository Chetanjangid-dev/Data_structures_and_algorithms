class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        first=0
        second=0
        max_len=0
        hashmap={}
        max_count=0
        while second<len(s):
                hashmap[s[second]]=hashmap.get(s[second],0)+1
                max_count=max(hashmap[s[second]],max_count)
                while second-first+1 - max_count>k:
                        hashmap[s[first]]-=1
                        if hashmap[s[first]]==0:
                                del hashmap[s[first]]
                        first+=1
                max_len=max(second-first+1,max_len)
                second+=1
        return max_len
