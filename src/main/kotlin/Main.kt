import complexity.multiplicationBoard
import complexity.pseudoBinaryContains
import elementaryDs.LinkedList
import elementaryDs.Node

fun main(args: Array<String>) {
    val node1 = Node(value = 1)
    val node2 = Node(value = 3)
    val node3 = Node(value = 4)

    node1.next = node2
    node2.next= node3

    var list = LinkedList<Int>()
    list.push(3)
    list.push(value = 4)
    list.push(value = 5)
    list.append(12)
    var middleNode = list.nodeAt(1)
    for (i in 1..3){
        middleNode = list.insertAt(-1*i, middleNode!!)!!
    }
    println(list)
    for (items in list){
        println(items)
    }

    var lists = LinkedList<Int>()
    lists.push(1)
    lists.push(2)
    lists.push(3)
    println(lists)

    for (item in lists){
        println("Double: ${item *2}")
    }




}