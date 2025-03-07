package tags.string

/**
 * https://www.acmicpc.net/problem/20310
 */
fun main() {
    val s = readln()

    val ones = s.count { it == '1' } shr 1
    val zeros = s.count { it == '0' } shr 1
    val isVisited = BooleanArray(s.length) { true }

    var count = 0
    for (i in s.indices) {
        if (s[i] == '1') {
            isVisited[i] = false
            count++
        }
        if (count == ones) {
            break
        }
    }

    count = 0
    for (i in s.indices.reversed()) {
        if (s[i] == '0') {
            isVisited[i] = false
            count++
        }
        if (count == zeros) {
            break
        }
    }

    println(s.indices.filter { isVisited[it] }.map { s[it] }.joinToString(""))
}
