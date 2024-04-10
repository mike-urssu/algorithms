package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14225
 */
private lateinit var numbers: IntArray
private val set = mutableSetOf<Int>()

fun main() {
    val n = readln().toInt()
    numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    sumOrNot(n, 1, 0)
    sumOrNot(n, 1, numbers[0])

    for (i in 1..numbers.sum() + 1) {
        if (!set.contains(i)) {
            println(i)
            break
        }
    }
}

private fun sumOrNot(n: Int, index: Int, sum: Int) {
    if (n == index) {
        set.add(sum)
        return
    }

    sumOrNot(n, index + 1, sum)
    sumOrNot(n, index + 1, sum + numbers[index])
}
