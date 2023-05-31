package tags.string

/**
 * https://www.acmicpc.net/problem/11328
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (s1, s2) = readln().split(" ")
        if (isStrfryPossible(s1, s2)) {
            println("Possible")
        } else {
            println("Impossible")
        }
    }
}

private fun isStrfryPossible(s1: String, s2: String): Boolean {
    val counts = IntArray(26)
    s1.forEach { c -> counts[c.code - 'a'.code]++ }
    s2.forEach { c -> counts[c.code - 'a'.code]-- }
    return counts.all { it == 0 }
}
