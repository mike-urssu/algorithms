package tags.backtracking

/**
 * https://www.acmicpc.net/problem/6443
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.SortedSet

private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var s: String
private lateinit var counts: IntArray
private lateinit var set: SortedSet<String>
private lateinit var combination: CharArray

fun main() {
    val n = readln().toInt()
    repeat(n) {
        s = readln()
        counts = IntArray(26) { s.count { c -> c - 'a' == it } }
        set = sortedSetOf()
        combination = CharArray(s.length)

        combination(0)

        set.forEach { writer.write("$it\n") }
        writer.flush()
    }
}

private fun combination(index: Int) {
    if (index == combination.size) {
        set.add(combination.joinToString(""))
        return
    }

    (0 until 26).forEach { i ->
        if (counts[i] > 0) {
            counts[i]--
            combination[index] = 'a' + i
            combination(index + 1)
            counts[i]++
        }
    }
}
