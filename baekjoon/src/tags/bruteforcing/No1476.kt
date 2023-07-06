package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1476
 */
fun main() {
    val (e1, s1, m1) = readln().split(" ").map { it.toInt() }
    var e2 = 1
    var s2 = 1
    var m2 = 1

    var count = 1
    while (true) {
        if (e1 == e2 && s1 == s2 && m1 == m2) {
            break
        }

        e2 = ((e2 + 1) % 16).coerceAtLeast(1)
        s2 = ((s2 + 1) % 29).coerceAtLeast(1)
        m2 = ((m2 + 1) % 20).coerceAtLeast(1)
        count++
    }

    println(count)
}
