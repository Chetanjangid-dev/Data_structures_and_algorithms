class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_hash={}
        s_hash={}
        for i in range(len(t)):
            t_hash[t[i]]=t_hash.get(t[i],0)+1
        first=0
        second=0
        min_len_str=''
        min_len_str_len=len(s)
        approved_times=0
        n=len(s)
        while second<n:
            if  s[second] in t_hash :
             s_hash[s[second]]=s_hash.get(s[second],0)+1
             if s_hash[s[second]]==t_hash[s[second]]:
               approved_times+=1
            while approved_times== len(t_hash):
                    if min_len_str_len>=second-first+1:
                     min_len_str=s[first:second+1]
                     min_len_str_len=second-first+1
                    if s[first] in s_hash:
                     s_hash[s[first]]=s_hash[s[first]]-1
                     if s_hash[s[first]]<t_hash[s[first]]:
                        approved_times-=1
                    first+=1
            second+=1
        return min_len_str
        
