package tags.string

/**
 * https://www.acmicpc.net/problem/10809
 */
fun main() {
    val s = readln()
    println(('a'..'z').map { s.indexOf(it) }.joinToString(" "))
}
