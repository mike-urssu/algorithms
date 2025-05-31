package tags.string

/**
 * https://www.acmicpc.net/problem/2596
 */
fun main() {
    readln()
    val s = readln()
    val indices = s.chunked(6).map { find(it) }
    if (indices.any { it == -1 }) {
        println(indices.indexOfFirst { it == -1 } + 1)
    } else {
        println(indices.joinToString("") { "${'A' + it}" })
    }
}

private val alphabets = arrayOf(
    "000000",
    "001111",
    "010011",
    "011100",
    "100110",
    "101001",
    "110101",
    "111010"
)

private fun find(s: String): Int {
    val index = alphabets.indexOf(s)
    if (index != -1) {
        return index
    }

    for ((i, s2) in alphabets.withIndex()) {
        var diff = 0
        for (j in 0 until 6) {
            if (s[j] != s2[j]) {
                diff++
            }
        }
        if (diff == 1) {
            return i
        }
    }
    return -1
}
