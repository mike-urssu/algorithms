package level2

import java.util.*

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
class StringCompression {
    fun solution(string: String): Int {
        var length = string.length
        for (i in 1..length / 2)
            length = length.coerceAtMost(getLength(string, i))
        return length
    }

    private fun getLength(string: String, lengthOfSlice: Int): Int {
        val substrings = LinkedList<String>()
        val counts = arrayListOf<Int>()

        for (i in 0 until string.length / lengthOfSlice) {
            val substring = string.substring(i * lengthOfSlice, (i + 1) * lengthOfSlice)
            if (substrings.peekLast() != substring) {
                substrings.add(substring)
                counts.add(1)
            } else
                counts[counts.size - 1]++
        }

        val builder = StringBuilder()
        for (i in counts.indices) {
            if (counts[i] != 1)
                builder.append(counts[i])
            builder.append(substrings.pop())
        }
        if (string.length > string.length / lengthOfSlice * lengthOfSlice)
            builder.append(string.substring((string.length / lengthOfSlice) * lengthOfSlice))

        return builder.length
    }
}

fun main() {
    val stringCompression = StringCompression()
    println(stringCompression.solution("aabbaccc") == 7)
    println(stringCompression.solution("ababcdcdababcdcd") == 9)
    println(stringCompression.solution("abcabcdede") == 8)
    println(stringCompression.solution("abcabcabcabcdededededede") == 14)
    println(stringCompression.solution("xababcdcdababcdcd") == 17)
}
