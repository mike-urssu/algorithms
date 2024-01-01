package tags.bellman_ford

/**
 * https://www.acmicpc.net/problem/1865
 */
import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val tc = reader.readLine().toInt()
    repeat(tc) {
        val (n, m, w) = reader.readLine().split(" ").map { it.toInt() }
        val paths = getPaths(m, w)

        if (canRewind(n, paths)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun getPaths(m: Int, w: Int): MutableList<Triple<Int, Int, Int>> {
    val paths = mutableListOf<Triple<Int, Int, Int>>()
    repeat(m) {
        val (s, e, t) = reader.readLine().split(" ").map { it.toInt() }
        paths.add(Triple(s, e, t))
        paths.add(Triple(e, s, t))
    }
    repeat(w) {
        val (s, e, t) = reader.readLine().split(" ").map { it.toInt() }
        paths.add(Triple(s, e, -t))
    }
    return paths
}

private const val MAX = 1_000_000_000

private fun canRewind(n: Int, paths: MutableList<Triple<Int, Int, Int>>): Boolean {
    val times = IntArray(n + 1) { MAX }

    for (i in 1 until n) {
        for ((s, e, t) in paths) {
            if (times[e] > times[s] + t) {
                times[e] = times[s] + t
            }
        }
    }

    return paths.any { (s, e, t) -> times[e] > times[s] + t }
}
