package exercises.extentions

fun String.isPermutationOfPalindrome(): Boolean {
    if (this.length < 2) {
        return true
    }
    val sorted = this.toCharArray().sortedArray()
    val chars = sorted.distinct()

    if (sorted.size % 2 == 0) {
        for (c in chars) {
            val n = sorted.count { x -> x == c }
            if (n % 2 != 0) {
                return false
            }
        }
        return true
    } else {
        var oneNotMatch = false
        for (c in chars) {
            val n = sorted.count { x -> x == c }
            if (n % 2 != 0) {
                when {
                    oneNotMatch -> return false
                    else -> oneNotMatch = true
                }
            }
        }
        return true
    }
}
