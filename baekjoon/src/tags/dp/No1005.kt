package tags.dp

import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val t = reader.readLine().toInt()
    repeat(t) {
        val (n, k) = reader.readLine().split(" ").map { it.toInt() }
        val delay = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        val directions = getDirections(n, k)

        val w = reader.readLine().toInt() - 1
        println(getDelay(delay, directions, w))
    }
}

private fun getDirections(n: Int, k: Int) =
    Array(n) { mutableListOf<Int>() }
        .apply {
            repeat(k) {
                val (src, dst) = reader.readLine().split(" ").map { it.toInt() - 1 }
                this[dst].add(src)
            }
        }

private fun getDelay(delay: IntArray, directions: Array<MutableList<Int>>, dst: Int): Int {
    return delay[dst] + (directions[dst].maxOfOrNull { getDelay(delay, directions, it) } ?: 0)
}
