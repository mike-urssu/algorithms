package tags.string

/**
 * https://www.acmicpc.net/problem/4659
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "end") {
            break
        }
        if (isValid(s)) {
            println("<$s> is acceptable.")
        } else {
            println("<$s> is not acceptable.")
        }
    }
}

private fun isValid(s: String) =
    containsConsonants(s) && !containsThreeVowelsOrThreeConsonantsInARow(s) && !isCharAppearingTwice(s)

private fun containsConsonants(s: String): Boolean {
    val consonants = listOf('a', 'e', 'i', 'o', 'u')
    return s.any { it in consonants }
}

private fun containsThreeVowelsOrThreeConsonantsInARow(s: String): Boolean {
    val consonants = listOf('a', 'e', 'i', 'o', 'u')
    var isConsonant = s.first() in consonants
    var count = 1
    for (i in 1 until s.length) {
        if (isConsonant) {
            if (s[i] in consonants) {
                count++
            } else {
                isConsonant = false
                count = 1
            }
        } else {
            if (s[i] !in consonants) {
                count++
            } else {
                isConsonant = true
                count = 1
            }
        }
        if (count == 3) {
            return true
        }
    }
    return false
}

private fun isCharAppearingTwice(s: String): Boolean {
    var isEorOAppeared = false
    for (i in 0 until s.lastIndex) {
        isEorOAppeared = if (s[i] == s[i + 1]) {
            if (s[i] == 'e' || s[i] == 'o') {
                if (isEorOAppeared) {
                    return true
                } else {
                    true
                }
            } else {
                return true
            }
        } else {
            false
        }
    }
    return false
}
