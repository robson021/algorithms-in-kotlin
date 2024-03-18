package exercises.datastructures.queue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class AnimalShelterTest {
    private val shelter = run {
        val shelter = AnimalShelter()
        val time = LocalDateTime.now()
        for (i in 1..99) {
            val rng = (0..1).random()
            val arrivalTime = time.plusDays(i.toLong())
            when {
                rng == 1 -> shelter.shelterNewPet(Dog("Dog $i", arrivalTime))
                else -> shelter.shelterNewPet(Cat("Cat $i", arrivalTime))
            }
        }
        shelter
    }

    @Test
    fun `adopt dog and cat`() {
        val dog = shelter.adoptOldestDog()
        val cat = shelter.adoptOldestCat()

        assertThat(dog).isNotNull()
        assertThat(cat).isNotNull()
    }

    @Test
    fun `adopt oldest pet`() {
        val pet1 = shelter.adoptOldestPet().arrivalTime
        val pet2 = shelter.adoptOldestPet().arrivalTime
        val pet3 = shelter.adoptOldestPet().arrivalTime

        assertThat(pet1).isBefore(pet2)
        assertThat(pet2).isBefore(pet3)
    }

}
