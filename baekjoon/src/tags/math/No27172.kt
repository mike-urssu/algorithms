package tags.math

/**
 * https://www.acmicpc.net/problem/27172
 */
fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val isVisited = BooleanArray(1_000_001).apply {
        numbers.forEach { this[it] = true }
    }
    val scores = IntArray(1_000_001)
    numbers.forEach {
        (it * 2..1_000_000 step it).forEach { j ->
            if (isVisited[j]) {
                scores[it]++
                scores[j]--
            }
        }
    }
    println(numbers.joinToString(" ") { scores[it].toString() })
}
