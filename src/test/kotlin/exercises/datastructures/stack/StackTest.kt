package exercises.datastructures.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StackTest {
    @Test
    fun `add new elements to an empty stack`() {
        val stack = Stack<Char>()
        stack.push('A')
        stack.push('B')
        stack.push('C')

        assertThat(stack.isEmpty()).isFalse()
        assertThat(stack.peek()).isEqualTo('C')
    }

    @Test
    fun `pop all top elements of a stack until it is empty`() {
        val stack = Stack(5)
        stack.push(4)
        stack.push(3)
        stack.push(2)
        stack.push(1)

        (1..5).forEach {
            val v = stack.pop()
            assertThat(v).isEqualTo(it)
        }
        assertThat(stack.isEmpty()).isTrue()
    }

    @Test
    fun `pop form empty stack`() {
        val stack = Stack<String>()
        assertThat(stack.pop()).isNull()
    }
}
