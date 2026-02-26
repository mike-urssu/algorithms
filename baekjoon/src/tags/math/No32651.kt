package tags.math

/**
 * https://www.acmicpc.net/problem/32651
 */
fun main() {
    val n = readln().toInt()
    val remember = if (n <= 100_000 && n % 2024 == 0) {
        "Yes"
    } else {
        "No"
    }
    println(remember)
}
