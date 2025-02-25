package tags.string

/**
 * https://www.acmicpc.net/problem/1515
 */
fun main() {
    val s = readln()
    var n = 0
    var i = 0
    while (i < s.length) {
        n++
        for (c in n.toString()) {
            if (i == s.length) {
                break
            }
            if (c == s[i]) {
                i++
            }
        }
    }
    println(n)
}
