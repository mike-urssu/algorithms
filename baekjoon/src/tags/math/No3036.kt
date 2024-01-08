package tags.math

/**
 * https://www.acmicpc.net/problem/3036
 */
fun main() {
    val n = readln().toInt()
    val radii = readln().split(" ").map { it.toInt() }.toIntArray()
    (1 until n).forEach { i ->
        val gcd = gcd(radii[0], radii[i])
        println("${radii[0] / gcd}/${radii[i] / gcd}")
    }
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}
