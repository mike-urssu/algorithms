package tags.data_structures

/**
 * https://www.acmicpc.net/problem/5568
 */
private lateinit var cards: IntArray
private lateinit var isVisited: BooleanArray
private lateinit var numbers: IntArray

private val set = mutableSetOf<String>()

fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    cards = IntArray(n) { readln().toInt() }
    isVisited = BooleanArray(n)
    numbers = IntArray(k)

    combination(n, k, 0)

    println(set.size)
}

private fun combination(n: Int, k: Int, index: Int) {
    if (index == k) {
        val number = numbers.joinToString("")
        set.add(number)
        return
    }
    for (i in 0 until n) {
        if (!isVisited[i]) {
            isVisited[i] = true
            numbers[index] = cards[i]
            combination(n, k, index + 1)
            isVisited[i] = false
        }
    }
}
