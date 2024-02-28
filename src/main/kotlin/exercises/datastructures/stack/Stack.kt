package exercises.datastructures.stack

private class Node<T>(val value: T, var next: Node<T>? = null)

class Stack<T>(initVal: T? = null) {
    private var top: Node<T>? = null

    init {
        initVal?.let { top = Node(it) }
    }

    fun push(e: T) = if (top == null) {
        top = Node(e)
    } else {
        val node = Node(e)
        node.next = top
        top = node
    }

    fun pop(): T? {
        val tmp = top
        top = top?.next
        return tmp?.value
    }

    fun peek() = top?.value
    fun isEmpty() = top == null
}
