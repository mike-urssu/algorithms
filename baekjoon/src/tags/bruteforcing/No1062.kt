package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/1062
 */
private val alphabets = BooleanArray(26)
    .apply { listOf('a', 'c', 'i', 'n', 't').forEach { this[it - 'a'] = true } }

private var n = 0
private var k = 0
private lateinit var words: Array<Set<Char>>
private var max = 0

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    k = numbers[1]
    words = Array(n) { readln().toSet() }
    if (k < 5) {
        println(0)
    } else {
        getMax(0, 5)
        println(max)
    }
}

private fun getMax(index: Int, count: Int) {
    if (count == k) {
        max = max.coerceAtLeast(words.count { canRead(it) })
        return
    }

    for (i in index until alphabets.size) {
        if (!alphabets[i]) {
            alphabets[i] = true
            getMax(i, count + 1)
            alphabets[i] = false
        }
    }
}

private fun canRead(word: Set<Char>) = word.all { alphabets[it - 'a'] }
