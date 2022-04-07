package level2

import java.util.*
import kotlin.collections.ArrayList

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
class StringCompression {
    private lateinit var substrings: LinkedList<String>
    private lateinit var counts: ArrayList<Int>

    fun solution(string: String): Int {
        var length = string.length
        for (lengthOfSubstring in 1..length / 2)
            length = length.coerceAtMost(getLength(string, lengthOfSubstring))
        return length
    }

    private fun getLength(string: String, lengthOfSubstring: Int): Int {
        compressString(string, lengthOfSubstring)

        val builder = StringBuilder()
        for (i in counts.indices) {
            if (counts[i] != 1)
                builder.append(counts[i])
            builder.append(substrings.pop())
        }

        val currentIndexOfString = string.length / lengthOfSubstring * lengthOfSubstring
        if (string.length > currentIndexOfString)
            builder.append(string.substring(currentIndexOfString))

        return builder.length
    }

    private fun compressString(string: String, lengthOfSubstring: Int) {
        substrings = LinkedList()
        counts = arrayListOf()

        for (i in 0 until string.length / lengthOfSubstring) {
            val substring = string.substring(i * lengthOfSubstring, (i + 1) * lengthOfSubstring)
            if (substrings.peekLast() != substring) {
                substrings.add(substring)
                counts.add(1)
            } else
                counts[counts.size - 1]++
        }
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
