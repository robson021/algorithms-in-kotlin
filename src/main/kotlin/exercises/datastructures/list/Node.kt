package exercises.datastructures.list

import org.slf4j.LoggerFactory


data class Node(val value: Int, var next: Node? = null) {

    fun addToTail(v: Int) {
        var pointer: Node = this
        while (pointer.next != null) {
            pointer = pointer.next!!
        }
        pointer.next = Node(v)
        log.info("New node added: $v")
    }

    fun deleteElement(head: Node, v: Int): Node? {
        if (head.value == v) {
            log.info("Deleting head: $head")
            return head.next
        }

        var p1: Node = head
        var p2: Node? = p1.next

        while (p2 != null && p2.value != v) {
            p1 = p2
            p2 = p2.next
        }
        log.info("Deleting node: ${p2?.value}")
        p1.next = p2?.next
        return head
    }

    fun removeDuplicates(head: Node) {
        val values = HashSet<Int>()
        var p = head
        while (true) {
            if (values.contains(p.value)) {
                deleteElement(head, p.value)
            }
            if (p.next == null) {
                break
            }
            values.add(p.value)
            p = p.next!!
        }
    }

    fun removeDuplicatesNoBuffer(head: Node) {
        if (head.next == null) {
            return
        }
        var p1 = head
        while (true) {
            var p2 = p1
            while (p2.next != null) {
                if (p1.value == p2.next?.value) {
                    p2.next = p2.next!!.next
                } else {
                    p2 = p2.next!!
                }
            }
            if (p1.next == null) {
                break
            }
            p1 = p1.next!!
        }
    }

    fun findNthElementFromTheEnd(head: Node, n: Int): Node {
        var counter = 1
        var p = head
        while (p.next != null) {
            p = p.next!!
            counter++
        }
        val toTraverse = counter - n

        p = head
        for (i in 0 until toTraverse) {
            p = p.next!!
        }
        return p
    }

    companion object {
        private val log = LoggerFactory.getLogger(Node::class.java)
    }
}

