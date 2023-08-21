package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/20438
 */
fun main() {
    val (n, _, _, m) = readln().split(" ").map { it.toInt() }
    val students = IntArray(n + 3)
    val isSleeping = BooleanArray(n + 3)

    val sleepers = readln().split(" ").map { it.toInt() }
    sleepers.forEach { isSleeping[it] = true }

    val attendances = readln().split(" ").map { it.toInt() }
    for (attendance in attendances) {
        if (isSleeping[attendance]) {
            continue
        }
        for (i in 1..(n + 2) / attendance) {
            if (!isSleeping[attendance * i]) {
                students[attendance * i] = 1
            }
        }
    }

    val prefixSum = students.drop(1).runningFold(0, Int::plus)
    repeat(m) {
        val (s, e) = readln().split(" ").map { it.toInt() }
        println((e - s + 1) - (prefixSum[e] - prefixSum[s - 1]))
    }
}
