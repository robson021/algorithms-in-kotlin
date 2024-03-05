package exercises.datastructures.queue

import java.util.*

private class Node<T>(val value: T, var next: Node<T>? = null)

class Queue<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun add(e: T) {
        val node = Node(e)
        if (tail == null) {
            head = node
        } else {
            tail!!.next = node
        }
        tail = node
    }

    fun pop(): T {
        if (head == null) {
            throw EmptyStackException()
        }
        val value = head!!.value
        if (head!!.next == null) {
            head = null
            tail = null
        } else {
            head = head!!.next
        }
        return value
    }

    fun peek(): T = if (head == null) {
        throw EmptyStackException()
    } else {
        head!!.value
    }

    fun isEmpty() = head == null
}
