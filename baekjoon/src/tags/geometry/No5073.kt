package tags.geometry

/**
 * https://www.acmicpc.net/problem/5073
 */
fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0) {
            break
        }

        val type = if (a + b <= c || b + c <= a || c + a <= b) {
            "Invalid"
        } else if (a == b && b == c) {
            "Equilateral"
        } else if (a == b || b == c || c == a) {
            "Isosceles"
        } else {
            "Scalene"
        }
        println(type)
    }
}
