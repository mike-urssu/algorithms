package tags.greedy

/**
 * https://www.acmicpc.net/problem/14487
 */
fun main() {
    readln()
    val costs = readln().split(" ").map { it.toInt() }
    println(costs.sum() - costs.max())
}
