package exercises.datastructures.stack

import org.slf4j.LoggerFactory
import java.util.*

data class Plate(private val id: String = UUID.randomUUID().toString())

class StackOfPlates(private val threshold: Int = 5) {
    private val stacks = Stack(Stack<Plate>())
    private var currentStack = this.stacks.peek()!!
    private var numberOfStacks = 1
    private var currentStackSize = 0

    fun pushNewPlate() {
        if (currentStackSize >= threshold) {
            log.info("Threshold reached. Creating a new stack of plates.")
            stacks.push(Stack())
            currentStackSize = 0
            currentStack = stacks.peek()!!
            ++numberOfStacks
        }
        currentStack.push(Plate())
        ++currentStackSize
    }

    fun pop(): Plate {
        if (numberOfStacks == 1 && currentStack.isEmpty()) {
            throw RuntimeException("No plates nor stacks")
        }
        if (currentStack.isEmpty()) {
            stacks.pop()
            currentStack = stacks.peek()!!
            currentStackSize = threshold
            --numberOfStacks
        }
        --currentStackSize
        return currentStack.pop()!!
    }

    fun peekPlate() = currentStack.peek()

    fun isEmpty() = numberOfStacks == 1 && currentStack.isEmpty()

    fun getNumberOfStack() = numberOfStacks

    fun getCurrentStackSize() = currentStackSize

    fun totalPlatesNumber() = currentStackSize + (numberOfStacks - 1) * threshold

    companion object {
        private val log = LoggerFactory.getLogger(StackOfPlates::class.java)
    }
}
