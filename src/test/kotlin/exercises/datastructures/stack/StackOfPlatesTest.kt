package exercises.datastructures.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StackOfPlatesTest {

    private val stackOfPlates = StackOfPlates()

    @Test
    fun `new stack is created when threshold is reached`() {
        stackOfPlates.pushNewPlate()
        stackOfPlates.pushNewPlate()
        stackOfPlates.pushNewPlate()
        stackOfPlates.pushNewPlate()
        stackOfPlates.pushNewPlate()

        assertThat(stackOfPlates.getNumberOfStack()).isEqualTo(1)
        assertThat(stackOfPlates.getCurrentStackSize()).isEqualTo(5)

        stackOfPlates.pushNewPlate()
        stackOfPlates.pushNewPlate()
        stackOfPlates.pushNewPlate()

        assertThat(stackOfPlates.getNumberOfStack()).isEqualTo(2)
        assertThat(stackOfPlates.getCurrentStackSize()).isEqualTo(3)

        assertThat(stackOfPlates.totalPlatesNumber()).isEqualTo(8)
    }

    @Test
    fun `remove from 2 stack of plates`() {
        val initialNumberOfPlates = 9
        (1..initialNumberOfPlates).forEach { _ ->
            stackOfPlates.pushNewPlate()
        }
        assertThat(stackOfPlates.totalPlatesNumber()).isEqualTo(initialNumberOfPlates)

        stackOfPlates.pop()
        stackOfPlates.pop()
        stackOfPlates.pop()

        assertThat(stackOfPlates.totalPlatesNumber()).isEqualTo(initialNumberOfPlates - 3)
        assertThat(stackOfPlates.getNumberOfStack()).isEqualTo(2)

        stackOfPlates.pop()
        stackOfPlates.pop()
        stackOfPlates.pop()

        assertThat(stackOfPlates.totalPlatesNumber()).isEqualTo(initialNumberOfPlates - 6)
        assertThat(stackOfPlates.getNumberOfStack()).isEqualTo(1)
    }

    @Test
    fun `drain all stacks`() {
        val initialNumberOfPlates = 12
        (1..initialNumberOfPlates).forEach { _ ->
            stackOfPlates.pushNewPlate()
            assertThat(stackOfPlates.peekPlate()).isNotNull
        }

        assertThat(stackOfPlates.totalPlatesNumber()).isEqualTo(initialNumberOfPlates)

        (1..initialNumberOfPlates).forEach { _ ->
            stackOfPlates.pop()
        }

        assertThat(stackOfPlates.isEmpty()).isTrue()
        assertThrows<RuntimeException>("No plates nor stacks", stackOfPlates::pop)
    }

}
