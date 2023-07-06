package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/10419
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val d = readln().toInt()
        val t = (0..d)
            .filter { it + it * it <= d }
            .max()
        println(t)
    }
}
