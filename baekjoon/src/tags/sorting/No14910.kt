package tags.sorting

/**
 * https://www.acmicpc.net/problem/14910
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val isAscending = (1 until numbers.size).all { i -> numbers[i - 1] <= numbers[i] }
    if (isAscending) {
        println("Good")
    } else {
        println("Bad")
    }
}
