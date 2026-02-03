package tags.string

/**
 * https://www.acmicpc.net/problem/27541
 */
fun main() {
    readln()
    val s = readln()
    if (s.endsWith('G')) {
        println(s.dropLast(1))
    } else {
        println("${s}G")
    }
}
