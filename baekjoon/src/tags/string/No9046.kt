package tags.string

/**
 * https://www.acmicpc.net/problem/9046
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val counts = IntArray(26)
        val s = readln()
        s.filter { it != ' ' }.forEach { counts[it - 'a']++ }
        val max = counts.max()
        if (counts.count { it == max } >= 2) {
            println("?")
        } else {
            println('a' + counts.indexOf(max))
        }
    }
}
