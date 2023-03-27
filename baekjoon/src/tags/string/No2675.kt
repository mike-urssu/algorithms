package tags.string

/**
 * https://www.acmicpc.net/problem/2675
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val (r, s) = readln().split(" ")
        val p = s.map { it.toString().repeat(r.toInt()) }
            .joinToString("")
        println(p)
    }
}
