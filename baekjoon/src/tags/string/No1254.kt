package tags.string

/**
 * https://www.acmicpc.net/problem/1254
 */
fun main() {
    val s = readln()
    var length = 0
    for (i in s.indices) {
        val substring = s.substring(i)
        if (substring == substring.reversed()) {
            length = i * 2 + substring.length
            break
        }
    }
    println(length)
}
