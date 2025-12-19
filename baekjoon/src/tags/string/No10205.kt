package tags.string

/**
 * https://www.acmicpc.net/problem/10205
 */
fun main() {
    val k = readln().toInt()
    repeat(k) {
        val h = readln().toInt()
        val s = readln()
        println("Data Set ${it + 1}:")
        println(countHead(h, s))
        println()
    }
}

private fun countHead(h: Int, s: String): Int {
    var count = h
    s.forEach { c ->
        if (c == 'b') {
            count--
        } else {
            count++
        }
    }
    return count
}
