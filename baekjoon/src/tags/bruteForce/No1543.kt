package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1543
 */
fun main() {
    val document = readln()
    val word = readln()
    println(document.split(word).size - 1)
}
