package tags.implementation

/**
 * https://www.acmicpc.net/problem/6359
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val isOpened = BooleanArray(n + 1)
        (1..n).forEach { k ->
            (k..n step k).forEach { isOpened[it] = !isOpened[it] }
        }
        println(isOpened.count { it })
    }
}
