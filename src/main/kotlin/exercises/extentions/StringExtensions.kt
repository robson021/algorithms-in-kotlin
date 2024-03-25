package exercises.extentions

fun String.compress(): String {
    if (this.length < 2) {
        return this
    }

    val sb = StringBuilder()
    val array = this.toCharArray()

    var prevChar: Char? = null

    for (index in 0..array.size - 2) {
        val toCheck = array[index]
        if (prevChar == toCheck) {
            continue
        }
        var counter = 1
        var i = index
        while ((i < array.size - 1) && array[i] == array[i + 1]) {
            counter++
            i++
        }
        sb.append("$toCheck$counter")
        prevChar = toCheck
    }

    val lastChar = array.last()
    if (lastChar != prevChar) {
        sb.append(lastChar)
        sb.append("1")
    }

    return when {
        sb.length < this.length -> sb.toString()
        else -> this
    }
}

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
