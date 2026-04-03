class Solution(object):
    def isValid(self, s):
        #if stack becomes bull at end when we aree applying cancel poutiong paraanthesis then its true
        def check(a):
            if a=="(" or a=="[" or a=="{":
               return True
            else:
                return False
        def reverse(a):
            if a==")":
                return "("
            if a=="]":
                return "["
            if a=="}":
                return "{"
        stack=[]
        i=0
        while i<len(s):
            if check(s[i]):
                stack.append(s[i])   
            else:
                if stack and reverse(s[i])==stack[-1]:
                    stack.pop()
                else:
                    return False
            i+=1
        return not stack
