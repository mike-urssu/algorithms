package tags.sorting

/**
 * https://www.acmicpc.net/problem/11292
 */
fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        val info = Array(n) {
            val input = readln().split(" ")
            val name = input[0]
            val height = input[1].toDouble()
            name to height
        }
        val max = info.maxOf { it.second }
        println(info.filter { it.second == max }.joinToString(" ") { it.first })
    }
}
