package tags.backtracking

/**
 * https://www.acmicpc.net/problem/17610
 */
private lateinit var numbers: IntArray
private lateinit var combination: IntArray
private lateinit var isMeasurable: BooleanArray

fun main() {
    val k = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    val s = numbers.sum()
    isMeasurable = BooleanArray(s + 1)
    combination = IntArray(k)

    combination(k, 0)

    println(isMeasurable.count { !it })
}

private fun combination(n: Int, r: Int) {
    if (r == n) {
        val sum = (0 until n).sumOf { numbers[it] * combination[it] }
        if (sum >= 0) {
            isMeasurable[sum] = true
        }
        return
    }

    combination[r] = -1
    combination(n, r + 1)
    combination[r] = 0
    combination(n, r + 1)
    combination[r] = 1
    combination(n, r + 1)
}
