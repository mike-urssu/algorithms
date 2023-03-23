package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/13410
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val max = (1..k).maxOf { (n * it).toString().reversed().toInt() }
    println(max)
}
