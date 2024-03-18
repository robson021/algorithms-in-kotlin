package exercises.datastructures.queue

import java.time.LocalDateTime

interface Pet {
    val name: String
    val arrivalTime: LocalDateTime
}

data class Dog(override val name: String, override val arrivalTime: LocalDateTime) : Pet
data class Cat(override val name: String, override val arrivalTime: LocalDateTime) : Pet

class AnimalShelter {
    private val dogs = Queue<Dog>()
    private val cats = Queue<Cat>()

    fun adoptOldestPet(): Pet {
        val dog = dogs.peek()
        val cat = cats.peek()

        return when {
            cat.arrivalTime.isBefore(dog.arrivalTime) -> cats.pop()
            else -> dogs.pop()
        }
    }

    fun adoptOldestCat() = cats.pop()

    fun adoptOldestDog() = dogs.pop()

    fun shelterNewPet(p: Pet) {
        when (p) {
            is Dog -> dogs.add(p)
            else -> cats.add(p as Cat)
        }
    }
}
