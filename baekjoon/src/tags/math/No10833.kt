package tags.math

/**
 * https://www.acmicpc.net/problem/10833
 */
fun main() {
    val n = readln().toInt()
    var remainder = 0
    repeat(n) {
        val (students, apples) = readln().split(" ").map { it.toInt() }
        remainder += apples % students
    }
    println(remainder)
}
