package tags.implementation

/**
 * https://www.acmicpc.net/problem/3048
 */
fun main() {
    val (n1, n2) = readln().split(" ").map { it.toInt() }
    val s1 = readln().map { it to true }.reversed()
    val s2 = readln().map { it to false }

    val s = mutableListOf<Pair<Char, Boolean>>()
    s.addAll(s1)
    s.addAll(s2)

    val t = readln().toInt()
    repeat(t) {
        var swap = false
        for (i in 0 until n1 + n2 - 1) {
            if (swap) {
                swap = false
                continue
            }

            val (_, d1) = s[i]
            val (_, d2) = s[i + 1]
            if (d1 && !d2) {
                val temp = s[i]
                s[i] = s[i + 1]
                s[i + 1] = temp
                swap = true
            }
        }
    }
    println(s.map { it.first }.joinToString(""))
}
