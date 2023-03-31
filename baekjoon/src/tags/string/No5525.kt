package tags.string

/**
 * https://www.acmicpc.net/problem/5525
 */
fun main() {
    val n = readln().toInt()
    readln().toInt()
    val s = readln()

    val ioi = mutableMapOf<Int, Int>()
    var index = 0
    while (index < s.length) {
        if (s[index++] == 'I') {
            var p = 0
            while (index + 2 <= s.length && s[index] == 'O' && s[index + 1] == 'I') {
                p++
                index += 2
            }
            ioi[p] = ioi.getOrDefault(p, 0) + 1
        }
    }

    val count = ioi.entries
        .filter { it.key >= n }
        .sumOf { (it.key - n + 1) * it.value }
    println(count)
}
