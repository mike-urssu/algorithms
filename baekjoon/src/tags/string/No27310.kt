package tags.string

/**
 * https://www.acmicpc.net/problem/27310
 */
fun main() {
    val s = readln()
    println(s.length + s.count { it == ':' } + s.count { it == '_' } * 5)
}
