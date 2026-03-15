package tags.string

/**
 * https://www.acmicpc.net/problem/21867
 */
fun main() {
    readln()
    val s = readln()
    val filter = charArrayOf('J', 'A', 'V')
    val biteCodes = s.filter { it !in filter }
    if (biteCodes.isEmpty()) {
        println("nojava")
    } else {
        println(biteCodes)
    }
}
