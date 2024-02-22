package exercises.datastructures.list

import org.junit.jupiter.api.Test

class SingleLinkedListTest {

    @Test
    fun `add new node to the tail`() {
        val head = createSortedList(4)
        head.addToTail(5)
        assertElements(head, 0, 1, 2, 3, 4, 5)
    }

    @Test
    fun `delete first node`() {
        val toDelete = 0
        val head = createSortedList(5)

        val newHead = head.deleteElement(head, toDelete)

        assertElements(newHead!!, 1, 2, 3, 4, 5)

    }

    @Test
    fun `delete middle node`() {
        val toDelete = 3
        val head = createSortedList(5)

        val newHead = head.deleteElement(head, toDelete)

        assertElements(newHead!!, 0, 1, 2, 4, 5)
    }

    @Test
    fun `delete last node`() {
        val toDelete = 5
        val head = createSortedList(toDelete)

        val newHead = head.deleteElement(head, toDelete)

        assertElements(newHead!!, 0, 1, 2, 3, 4)
    }

    @Test
    fun `delete element from single element list`() {
        val head = Node(0)

        val newHead: Node? = head.deleteElement(head, 0)
        assert(newHead == null)
    }

    @Test
    fun `delete head from 2 element list`() {
        val head = createSortedList(1)

        val newHead = head.deleteElement(head, 0)!!

        assert(newHead.value == 1)
        assert(newHead.next == null)
    }

    @Test
    fun `delete tail from 2 element list`() {
        val head = createSortedList(1)

        val newHead = head.deleteElement(head, 1)!!

        assert(newHead.value == 0)
        assert(newHead.next == null)
    }

    @Test
    fun `remove duplicated elements`() {
        val head = Node(0)
        sequenceOf(1, 5, 3, 5, 2, 6, 5, 4, 6, 2).forEach {
            head.addToTail(it)
        }

        head.removeDuplicates(head)

        assertElements(head, 0, 1, 3, 5, 4, 6, 2)
    }

    @Test
    fun `remove duplicates, no buffer`() {
        val head = Node(0)
        sequenceOf(1, 5, 3, 5, 2, 6, 5, 4, 6, 2).forEach {
            head.addToTail(it)
        }

        head.removeDuplicatesNoBuffer(head)

        assertElements(head, 0, 1, 5, 3, 2, 6, 4)
    }

    @Test
    fun `find Nth node from the end of a list`() {
        val head = Node(9)
        sequenceOf(8, 7, 6, 5, 4, 3, 2, 1, 0).forEach {
            head.addToTail(it)
        }

        val (value) = head.findNthElementFromTheEnd(head, 4)
        assert(value == 3)
    }

    private fun createSortedList(numberOfElements: Int): Node {
        if (numberOfElements < 1) {
            throw RuntimeException("Invalid number of elements to add: $numberOfElements")
        }
        val head = Node(0)
        for (i in 1..numberOfElements) {
            head.addToTail(i)
        }
        return head
    }

    private fun assertElements(head: Node, vararg expected: Int) {
        var p = head
        for (v in expected) {
            assert(p.value == v)
            if (p.next != null) {
                p = p.next!!
            }
        }
    }

}
