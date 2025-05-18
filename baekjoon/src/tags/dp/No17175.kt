package tags.dp

/**
 * https://www.acmicpc.net/problem/17175
 */
fun main() {
    val n = readln().toInt()
    val fibonacci = IntArray(51)
    fibonacci[0] = 1
    fibonacci[1] = 1
    (2..50).forEach { i -> fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1] + 1) % 1_000_000_007 }
    println(fibonacci[n])
}
