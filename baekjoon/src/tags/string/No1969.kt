package tags.string

/**
 * https://www.acmicpc.net/problem/1969
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dna = Array(n) { readln().toCharArray() }

    val d = CharArray(m) { i ->
        val group = dna.map { it[i] }.groupBy { it }.toSortedMap()
        val max = group.values.maxOf { it.size }
        group.entries.first { max == it.value.size }.key
    }

    val distance = d
        .mapIndexed { i, c -> dna.count { it[i] != c } }
        .sum()

    println(d.joinToString(""))
    println(distance)
}
