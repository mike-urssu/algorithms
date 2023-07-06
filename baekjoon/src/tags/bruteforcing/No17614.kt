package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17614
 */
fun main() {
    val n = readln().toInt()
    val numbers = listOf('3', '6', '9')
    val count = (1..n).sumOf { number -> number.toString().toCharArray().count { it in numbers } }
    println(count)
}
