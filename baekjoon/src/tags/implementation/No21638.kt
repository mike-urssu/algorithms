package tags.implementation

/**
 * https://www.acmicpc.net/problem/21638
 */
fun main() {
    val (t1, v1) = readln().split(" ").map { it.toInt() }
    val (t2, v2) = readln().split(" ").map { it.toInt() }

    val message = if (0 > t2 && v2 >= 10) {
        "A storm warning for tomorrow! Be careful and stay home if possible!"
    } else if (t1 > t2) {
        "MCHS warns! Low temperature is expected tomorrow."
    } else if (v1 < v2) {
        "MCHS warns! Strong wind is expected tomorrow."
    } else {
        "No message"
    }
    println(message)
}
