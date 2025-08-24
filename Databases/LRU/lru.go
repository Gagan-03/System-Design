package main

type Node struct {
	Key   int
	Value int
	Prev  *Node
	Next  *Node
}

func NewNode(key, val int) *Node {
	return &Node{
		Key:   key,
		Value: val,
		Prev:  nil,
		Next:  nil,
	}
}

type LRUCache struct {
	Capacity int
	CacheMap map[int]*Node
	Head     *Node
	Tail     *Node
}

func NewLRUCache(capacity int) *LRUCache {
	resCache := LRUCache{
        Capacity: capacity,
        CacheMap: make(map[int]*Node), 
    }
	resCache.Head = NewNode(-1, -1)
	resCache.Tail = NewNode(-1, -1)
	resCache.Head.Next = resCache.Tail
	resCache.Tail.Prev = resCache.Head

	return &resCache
}

func (cache *LRUCache) Get(key int) int {
	resNode, ok := cache.CacheMap[key]
	if !ok {
		return -1
	}
	cache.remove(resNode)
	cache.add(resNode)
	return resNode.Value
}

func (cache *LRUCache)add (node *Node) {
	temp := cache.Head.Next
	cache.Head.Next = node
	node.Prev = cache.Head
	node.Next = temp
	temp.Prev = node
}

func (cache *LRUCache)remove (node *Node) {
	nextNode := node.Next
	prevNode := node.Prev
	prevNode.Next = nextNode
	nextNode.Prev = prevNode
}

func (cache *LRUCache) Put(key, val int) {
	if resNode, ok := cache.CacheMap[key]; ok {
        resNode.Value = val
        cache.remove(resNode)
        cache.add(resNode)
        return
    }

	nodeToAdd := NewNode(key, val)
	cache.add(nodeToAdd)
	cache.CacheMap[key] = nodeToAdd

	if len(cache.CacheMap) > cache.Capacity {
		NodeToDelete := cache.Tail.Prev
		cache.remove(NodeToDelete)
		delete(cache.CacheMap, NodeToDelete.Key)
	}
}
