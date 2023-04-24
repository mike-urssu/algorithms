package tags.string

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/1919
 */
fun main() {
    val str1 = readln()
    val str2 = readln()

    val characters1 = IntArray(26)
    val characters2 = IntArray(26)

    str1.forEach { characters1[it - 'a']++ }
    str2.forEach { characters2[it - 'a']++ }

    val count = (0 until 26).sumOf { abs(characters1[it] - characters2[it]) }
    println(count)
}
