class Solution(object):
    def removeNodes(self, head):
        temp=head
        stack=[]
        while temp:
            while stack and temp.val>stack[-1].val:
                 stack.pop()
            stack.append(temp)
            temp=temp.next
        # creting a new chain of nodes
        head=stack[0]
        for i in range(len(stack)-1):
            stack[i].next=stack[i+1]
        stack[-1].next=None
        return head
