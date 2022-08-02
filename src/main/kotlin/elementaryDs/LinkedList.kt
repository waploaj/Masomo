package elementaryDs

//LinkedList - is a collection of values arranged in liner, unidirectional sequence.
//LinkedList has theoretical advantage over contagious storage such as kotlin Array or ArrayList.
//-constant time insertion and removal from font of the list
//-Reliable performance characteristics
data class Node<T>(var value:T, var next:Node<T>? = null){
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}

class LinkedList<T>:Iterable<T>{
    private var head:Node<T>? =  null
    private var tail:Node<T>? = null
    var size = 0
        private set

    private fun isEmpty():Boolean{
        return size == 0
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }



    override fun toString(): String {
        return if (isEmpty()){
            "list is Empty"
        }else{
            head.toString()
        }
    }

    fun push(value: T){
        head = Node(value, head)
        if (tail == null){
            tail = head
        }
        size++
    }

    fun append(value: T){
       if (isEmpty()){
           push(value)
           return
       }
       tail?.next = Node(value)
       tail = tail?.next
       size++
    }

/* Insertion Operation - This requires two-steps
    1.- Find the particular node in the list.
    2. Insert the new Node after that node.
* */

    fun nodeAt(index:Int):Node<T>{
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode!!
    }

    fun insertAt(value: T, afterNode:Node<T>):Node<T>?{
        if (tail == null){
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    private fun pop():T? {
        if (isEmpty())size--
        head = head?.next
        val result = head?.value
        if (!isEmpty())tail=null
        return result
    }

    fun removeLast():T?{
        val head = head?:return null
        if (head.next == null)return pop()
        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null){
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAt(node: Node<T>):T?{
       val result = node.next?.value
        if (node.next == tail){
            tail = node
        }

        if (node.next != null)size--
        node.next = node.next?.next
        return result
    }



}