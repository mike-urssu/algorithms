package tags.greedy

/**
 * https://www.acmicpc.net/problem/14720
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    var count = 0
    var milk = 0
    numbers.forEach { v ->
        if (v == milk) {
            count++
            milk = (milk + 1) % 3
        }
    }
    println(count)
}
