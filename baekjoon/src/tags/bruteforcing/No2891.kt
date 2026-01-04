package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2891
 */
fun main() {
    val (n, _, _) = readln().split(" ").map { it.toInt() }
    val teams = BooleanArray(n + 1) { true }
    val broken = readln().split(" ").map { it.toInt() }.toIntArray()
    val spare = readln().split(" ").map { it.toInt() }.toIntArray()

    broken.forEach { i -> teams[i] = false }
    spare.forEachIndexed { i, v ->
        if (!teams[v]) {
            teams[v] = true
            spare[i] = -1
        }
    }
    spare.forEach { v ->
        if (v != -1) {
            val index = (v - 1..minOf(v + 1, n)).firstOrNull { !teams[it] } ?: -1
            if (index != -1) {
                teams[index] = true
            }
        }
    }

    println(teams.count { !it })
}
