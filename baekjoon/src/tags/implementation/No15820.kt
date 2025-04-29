package tags.implementation

/**
 * https://www.acmicpc.net/problem/15820
 */
fun main() {
    val (s1, s2) = readln().split(" ").map { it.toInt() }
    val sample = (0 until s1).all {
        val (n1, n2) = readln().split(" ").map { it.toInt() }
        n1 == n2
    }
    val system = (0 until s2).all {
        val (n1, n2) = readln().split(" ").map { it.toInt() }
        n1 == n2
    }

    val output = if (!sample) {
        "Wrong Answer"
    } else {
        if (system) {
            "Accepted"
        } else {
            "Why Wrong!!!"
        }
    }
    println(output)
}
