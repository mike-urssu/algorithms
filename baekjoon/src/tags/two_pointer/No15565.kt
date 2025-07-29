package tags.two_pointer

/**
 * https://www.acmicpc.net/problem/15565
 */
fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() }
    val dolls = readln().split(" ").map { it.toInt() }.toIntArray()
    val lions = dolls.indices.filter { dolls[it] == 1 }
    val min = if (lions.size < k) {
        -1
    } else {
        (0..lions.size - k).minOf { i -> lions[i + k - 1] - lions[i] + 1 }
    }
    println(min)
}
