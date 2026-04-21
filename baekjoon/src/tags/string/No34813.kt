package tags.string

/**
 * https://www.acmicpc.net/problem/34813
 */
fun main() {
    val s = readln()
    val v = when(s[0]) {
        'F' -> "Foundation"
        'C' -> "Claves"
        'V' -> "Veritas"
        else -> "Exploration"
    }
    println(v)
}
