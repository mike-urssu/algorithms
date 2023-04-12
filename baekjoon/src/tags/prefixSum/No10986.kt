package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/10986
 */
fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    val remainders = LongArray(m)

    var sum = 0
    for (n in numbers) {
        sum = (sum + n) % m
        remainders[sum]++
    }

    var count: Long = remainders.first()
    count += remainders
        .filter { it != 0L }
        .sumOf { it * (it - 1) / 2 }
    println(count)
}
