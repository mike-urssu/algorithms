package tags.data_structures

/**
 * https://www.acmicpc.net/problem/1717
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var parents: IntArray

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    parents = IntArray(n + 1) { it }
    repeat(m) {
        val (option, a, b) = reader.readLine().split(" ").map { it.toInt() }
        if (option == 0) {
            union(a, b)
        } else {
            if (find(a) == find(b)) {
                writer.write("YES\n")
            } else {
                writer.write("NO\n")
            }
        }
    }
    writer.flush()
}

private fun union(a: Int, b: Int) {
    val a2 = find(a)
    val b2 = find(b)
    if (a2 >= b2) {
        parents[a2] = b2
    } else {
        parents[b2] = a2
    }
}

private fun find(n: Int): Int {
    if (parents[n] == n) {
        return n
    }
    parents[n] = find(parents[n])
    return parents[n]
}
