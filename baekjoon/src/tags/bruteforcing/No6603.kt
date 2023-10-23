package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/6603
 */
private lateinit var s: List<Int>
private val permutation = IntArray(6)

fun main() {
    while (true) {
        val numbers = readln().split(" ").map { it.toInt() }
        if (numbers[0] == 0) {
            break
        }

        val k = numbers[0]
        s = numbers.drop(1)
        (0 until k).forEach { i ->
            permutation[0] = s[i]
            permutation(k, 1, i)
        }
        println()
    }
}

private fun permutation(k: Int, pIndex: Int, sIndex: Int) {
    if (pIndex == 6) {
        println(permutation.joinToString(" "))
        return
    }

    (sIndex + 1 until k).forEach { i ->
        permutation[pIndex] = s[i]
        permutation(k, pIndex + 1, i)
    }
}
