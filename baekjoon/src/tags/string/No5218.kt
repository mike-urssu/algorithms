package tags.string

/**
 * https://www.acmicpc.net/problem/5218
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (s1, s2) = readln().split(" ")
        val distances = s1.mapIndexed { index, _ ->
            if (s1[index] <= s2[index]) {
                s2[index] - s1[index]
            } else {
                s2[index] + 26 - s1[index]
            }
        }.joinToString(" ")
        println("Distances: $distances")
    }
}
