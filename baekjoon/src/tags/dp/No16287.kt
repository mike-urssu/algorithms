package tags.dp

/**
 * https://www.acmicpc.net/problem/16287
 */
fun main() {
    val (w, n) = readln().split(" ").map { it.toInt() }.toIntArray()
    val weights = readln().split(" ").map { it.toInt() }.sorted().toIntArray()

    val combination = Array(800001) { IntArray(2) }
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            val sum = weights[i] + weights[j]
            if (sum < w && combination[sum][1] == 0) {
                combination[sum][0] = i
                combination[sum][1] = j
            }
        }
    }
    var isValid = false
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            val remainder = w - (weights[i] + weights[j])
            if (remainder >= 2 && combination[remainder][1] != 0) {
                if (combination[remainder][0] != i && combination[remainder][0] != j && combination[remainder][1] != i && combination[remainder][1] != j) {
                    isValid = true
                }
            }
        }
    }

    if (isValid) {
        println("YES")
    } else {
        println("NO")
    }
}
