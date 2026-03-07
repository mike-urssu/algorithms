package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/13333
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    for (k in n downTo 1) {
        if (k <= numbers[n - k]) {
            println(k)
            return
        }
    }
    println(0)
}
