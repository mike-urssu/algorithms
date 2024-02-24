package tags.data_structures

/**
 * https://www.acmicpc.net/problem/11003
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque
import java.util.StringTokenizer

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))
private val d = StringBuilder()

fun main() {
    var tokens = StringTokenizer(reader.readLine())
    val n = tokens.nextToken().toInt()
    val l = tokens.nextToken().toInt()

    tokens = StringTokenizer(reader.readLine())
    val numbers = IntArray(n) { tokens.nextToken().toInt() }

    val deque = ArrayDeque<Int>()
    for (i in numbers.indices) {
        val number = numbers[i]
        while (deque.isNotEmpty() && numbers[deque.last] > number) {
            deque.removeLast()
        }
        deque.addLast(i)
        if (deque.first <= i - l) {
            deque.pop()
        }
        d.append("${numbers[deque.first]} ")
    }

    writer.write(d.toString())
    writer.flush()
}
