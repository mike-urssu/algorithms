package tags.greedy

/**
 * https://www.acmicpc.net/problem/25379
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()

    var swap0 = 0L
    var swap1 = 0L
    var count0 = 0L
    var count1 = 0L
    for (i in 0 until n) {
        if (numbers[i] % 2 == 0) {
            count0++
            swap1 += count1
        } else {
            count1++
            swap0 += count0
        }
    }

    println(minOf(swap0, swap1))
}
