# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq


class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = tail = ListNode()
        
        n = len(lists)
        heap = []
        for i in range(n):
            if lists[i] is not None:
                heapq.heappush(heap, (lists[i].val,i, lists[i]))

        while heap: 
            val,i, node = heapq.heappop(heap)
            tail.next = node
            tail = tail.next

            if node.next is not None:
                heapq.heappush(heap, (node.next.val,i, node.next))
        
        return dummy.next

       