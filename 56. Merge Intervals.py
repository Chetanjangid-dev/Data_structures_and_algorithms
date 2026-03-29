class Solution(object):
    def merge(self, intervals):
        intervals.sort()
        merge_interval=[]
        pointer=0
        while pointer<len(intervals):
            start=intervals[pointer][0]
            end=intervals[pointer][1]
            while pointer+1<len(intervals ) and end>=intervals[pointer+1][0]:
                end=max(end,intervals[pointer+1][1])
                pointer+=1
            merge_interval.append([start,end])
            pointer+=1
        return merge_interval
            
