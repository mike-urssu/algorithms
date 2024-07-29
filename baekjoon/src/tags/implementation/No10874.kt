package tags.implementation

/**
 * https://www.acmicpc.net/problem/10874
 */
fun main() {
    val answers = IntArray(10) { j -> j % 5 + 1 }
    val n = readln().toInt()
    (1..n).filter {
        val solutions = readln().split(" ").map { it.toInt() }.toIntArray()
        solutions.contentEquals(answers)
    }.forEach { println(it) }
}
