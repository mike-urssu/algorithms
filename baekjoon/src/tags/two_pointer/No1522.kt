package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/1522
 */
fun main() {
    val s = readln()
    val countA = s.count { it == 'a' }
    val min = s.indices.minOf { i ->
        (i until i + countA).count { j ->
            s[j % s.length] == 'b'
        }
    }
    println(min)
}
