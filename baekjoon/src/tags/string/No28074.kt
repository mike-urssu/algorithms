package tags.string

/**
 * https://www.acmicpc.net/problem/28074
 */
fun main() {
    val mobis = charArrayOf('M', 'O', 'B', 'I', 'S')
    val s = readln()
    if (mobis.all { it in s }) {
        println("YES")
    } else {
        println("NO")
    }
}
