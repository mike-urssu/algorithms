package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1145
 */
fun main() {
    val numbers = readln().split(" ").map { it.toInt() }

    var i = 1
    while (true) {
        if (numbers.count { i % it == 0 } >= 3) {
            break
        }
        i++
    }

    println(i)
}
