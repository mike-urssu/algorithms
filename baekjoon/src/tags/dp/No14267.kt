package tags.dp

/**
 * https://www.acmicpc.net/problem/14267
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sum = IntArray(n + 1)
    val employees = getEmployees(n)
    repeat(m) {
        val (i, w) = readln().split(" ").map { it.toInt() }
        sum[i] += w
    }

    val prefixSum = IntArray(n + 1)
    (2..n).forEach { i ->
        prefixSum[i] = sum[i]
        employees[i].forEach { e ->
            sum[e] += sum[i]
        }
    }

    println(prefixSum.drop(1).joinToString(" "))
}

private fun getEmployees(n: Int): Array<MutableList<Int>> {
    val employees = Array(n + 1) { mutableListOf<Int>() }
    val bosses = readln().split(" ").map { it.toInt() }
    (1 until n).forEach { i -> employees[bosses[i]].add(i + 1) }
    return employees
}
