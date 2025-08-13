package tags.string

/**
 * https://www.acmicpc.net/problem/31495
 */
fun main() {
    val s = readln()
    if (s[0] == '\"' && s[s.lastIndex] == '\"' && s.length > 2) {
        println(s.substring(1, s.lastIndex))
    } else {
        println("CE")
    }
}
