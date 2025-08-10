package tags.implementation

/**
 * https://www.acmicpc.net/problem/30033
 */
fun main() {
    val n = readln().toInt()
    val expected = readln().split(" ").map { it.toInt() }.toIntArray()
    val actual = readln().split(" ").map { it.toInt() }.toIntArray()
    val count = (0 until n).count { i -> actual[i] >= expected[i] }
    println(count)
}
