package exercises.extentions

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StringExtensionsTest {

    @Test
    fun `is permutation of palindrome`() {
        assertTrue("kajakkajak".isPermutationOfPalindrome())
        assertTrue("kajakajak".isPermutationOfPalindrome())
        assertTrue("aaabbbcccbbbaaa".isPermutationOfPalindrome())
        assertTrue("a".isPermutationOfPalindrome())
        assertTrue("aba".isPermutationOfPalindrome())
        assertTrue("aabcc".isPermutationOfPalindrome())
        assertTrue("aabbbaa".isPermutationOfPalindrome())

        assertFalse("abcd".isPermutationOfPalindrome())
        assertFalse("ab".isPermutationOfPalindrome())
        assertFalse("kajakk".isPermutationOfPalindrome())
    }

}
