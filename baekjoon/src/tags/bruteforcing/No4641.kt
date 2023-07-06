package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/4641
 */
fun main() {
    while (true) {
        val numbers = readln().split(" ").map { it.toInt() }
        if (numbers.first() == -1) {
            break
        }
        println(numbers.count { it != 0 && numbers.contains(it * 2) })
    }
}
