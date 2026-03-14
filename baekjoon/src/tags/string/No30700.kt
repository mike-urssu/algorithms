package tags.string

/**
 * https://www.acmicpc.net/problem/30700
 */
fun main() {
    val s = readln()
    val korea = charArrayOf('K', 'O', 'R', 'E', 'A')
    var index = 0
    var length = 0
    for (c in s) {
        if (c == korea[index]) {
            length++
            index = (index + 1) % 5
        }
    }
    println(length)
}
