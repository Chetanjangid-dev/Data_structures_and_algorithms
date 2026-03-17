class Solution(object):
    def isHappy(self, n):
        number_was=n
        sqaure=0
        while sqaure!=1:
         sqaure=0
         while (n%10)!=n:
            digit=n%10
            sqaure+=(digit*digit)
            n=n-digit
            n=n//10
         if n%10==n:
            sqaure+=n*n
         if sqaure==1:
            return True
         elif sqaure==number_was:
            print("bad number")
            return False
         else:
            n=sqaure
                
