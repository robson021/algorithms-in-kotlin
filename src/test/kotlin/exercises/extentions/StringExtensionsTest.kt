package exercises.extentions

import org.junit.jupiter.api.Assertions.*
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

    @Test
    fun `compress string`() {
        assertEquals("a", "a".compress())
        assertEquals("abc", "abc".compress())
        assertEquals("abcdef", "abcdef".compress())
        assertEquals("a4B2C2", "aaaaBBCC".compress())
        assertEquals("a4b3c2d5e4", "aaaabbbccdddddeeee".compress())
        assertEquals("a4b3c2d5e1", "aaaabbbccddddde".compress())
    }

    @Test
    fun `check if the sting has unique characters`() {
        assertTrue("".hasUniqueChars())
        assertTrue("abcd 123".hasUniqueChars())
        assertFalse("abc dd 123".hasUniqueChars())
        assertFalse(" 1 ".hasUniqueChars())
    }

}
