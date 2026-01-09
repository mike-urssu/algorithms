package tags.string

/**
 * https://www.acmicpc.net/problem/9324
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val m = readln()
        val counts = IntArray(26)
        var isReal = true
        var index = 0
        while (index < m.length) {
            val c = m[index]
            counts[c - 'A']++
            if (counts[c - 'A'] == 3) {
                if (index == m.lastIndex || m[index] != m[index + 1]) {
                    isReal = false
                    break
                }
                counts[c - 'A'] = 0
                index++
            }
            index++
        }

        if (isReal) {
            println("OK")
        } else {
            println("FAKE")
        }
    }
}
