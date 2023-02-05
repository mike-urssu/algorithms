package level.silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.SortedSet
import java.util.TreeSet

/**
 * https://www.acmicpc.net/problem/1181
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val sortedSet: SortedSet<String> = TreeSet { it, other ->
        if (it.length == other.length)
            it.compareTo(other)
        else
            it.length.compareTo(other.length)
    }

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        sortedSet.add(reader.readLine())
    }

    sortedSet.forEach { writer.write("$it\n") }
    writer.flush()
}