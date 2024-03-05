package exercises.datastructures.queue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class QueueTest {

    private val queue = Queue<Int>()

    @Test
    fun add() {
        queue.add(1)

        assertThat(queue.isEmpty()).isFalse()
    }

    @Test
    fun pop() {
        queue.add(1)
        queue.add(2)
        queue.add(3)

        assertThat(queue.pop()).isEqualTo(1)
        assertThat(queue.peek()).isEqualTo(2)
    }

    @Test
    fun peek() {
        queue.add(1)
        queue.add(2)

        assertThat(queue.peek()).isEqualTo(1)
    }

    @Test
    fun isEmpty() {
        assertThat(queue.isEmpty()).isTrue()

        queue.add(3)
        queue.add(4)
        queue.add(5)

        assertThat(queue.isEmpty()).isFalse()
    }

    @Test
    fun drain() {
        queue.add(1)
        queue.add(2)
        queue.add(3)

        queue.pop()
        queue.pop()
        queue.pop()

        assertThat(queue.isEmpty()).isTrue()

        assertThrows<EmptyStackException>(queue::pop)
    }
}
