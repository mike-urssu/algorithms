package tags.math

/**
 * https://www.acmicpc.net/problem/5032
 */
fun main() {
    val (e, f, c) = readln().split(" ").map { it.toInt() }
    var sum = 0
    var bottles = e + f
    while (bottles >= c) {
        sum += bottles / c
        bottles = bottles / c + bottles % c
    }
    println(sum)
}
