class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}
        self.head, self.tail = Node(), Node() # always head.next is LRU and tail.prev is MRU
        self.head.next, self.tail.prev = self.tail, self.head

    def _remove(self, node: Node) -> None:
        node.prev.next, node.next.prev = node.next, node.prev


    def _append(self, node: Node) -> None:
        self.tail.prev.next, node.prev = node, self.tail.prev
        self.tail.prev, node.next = node, self.tail

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1
        node = self.map[key]
        self._remove(node)
        self._append(node)
        return node.value


    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self._remove(self.map[key])
        node = Node(key, value)
        self._append(node)
        self.map[key] = node

        if len(self.map) > self.capacity:
            lru = self.head.next 
            self._remove(lru)
            del self.map[lru.key]
            
           
        




class Node: 

    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.next = self.prev = None