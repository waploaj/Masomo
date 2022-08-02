package elementaryDs

import java.lang.IndexOutOfBoundsException

/**
 * The kotlin Standard Library has a set of interface that helps to define what's expected of particular type
 *Each of these interface guarantees characteristic and performers.
 *
 * sample of each interface represent
 * Tier 1:- Iterable - provide sequential access of its element via iterator
 * Tier 2:- Collection - provide additional functionality, allowing to check if collection contain particular -
 * element or a collection of element
 * Tier 3:- Mutable - provide mutableiterator, which allow removing item from given collection.
 * Tier 4:- MutableCollection - provide the method to alter collection EXample(add and remove item from collection-
 * even clear the entire collection)
 * */

class LinkedListIterator<T>(
    private val list:LinkedList<T>
):Iterator<T>{
    private var index = 0
    private var lastNode:Node<T>? = null

    override fun hasNext(): Boolean {
        return index<list.size
    }

    override fun next(): T {
        if (index>=list.size)throw IndexOutOfBoundsException()
        lastNode = if (index == 0){
            list.nodeAt(0)
        }else{
            lastNode?.next
        }
        index++
        return lastNode!!.value
    }
}