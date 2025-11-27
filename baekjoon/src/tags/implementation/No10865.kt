package tags.implementation

/**
 * https://www.acmicpc.net/problem/10865
 */
import java.io.BufferedReader
import java.io.BufferedWriter

private val reader = BufferedReader(System.`in`.reader())
private val writer = BufferedWriter(System.out.writer())

fun main() {
    val (n, m) = reader.readLine()!!.split(' ').map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = reader.readLine()!!.split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    (1..n).forEach { writer.write("${graph[it].size}\n") }
    writer.flush()
}
