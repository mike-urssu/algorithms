package tags.string

/**
 * https://www.acmicpc.net/problem/16171
 */
fun main() {
    val s = readln()
    val k = readln()
    val isExist = if (s.filterNot { it in '0'..'9' }.contains(k)) {
        1
    } else {
        0
    }
    println(isExist)
}
