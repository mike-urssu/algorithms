package tags.sorting

/**
 * https://www.acmicpc.net/problem/2587
 */
fun main() {
    val numbers = IntArray(5) { readln().toInt() }
    println(numbers.average().toInt())
    println(numbers.sorted()[2])
}
