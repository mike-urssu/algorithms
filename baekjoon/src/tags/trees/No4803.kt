package tags.trees

/**
 * https://www.acmicpc.net/problem/4803
 */
private lateinit var parents: IntArray
private lateinit var cycles: MutableSet<Int>

fun main() {
    var t = 1
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }

        parents = IntArray(n + 1) { it }
        cycles = mutableSetOf()

        repeat(m) {
            val (src, dst) = readln().split(" ").map { it.toInt() }
            union(src, dst)
        }

        when (val counts = countTrees(n)) {
            0 -> {
                println("Case $t: No trees.")
            }

            1 -> {
                println("Case $t: There is one tree.")
            }

            else -> {
                println("Case $t: A forest of $counts trees.")
            }
        }
        t++
    }
}

private fun countTrees(n: Int): Int {
    val nonTrees = cycles.map { find(it) }.toSet()
    return (1..n).asSequence()
        .map { find(it) }.distinct()
        .filterNot { nonTrees.contains(it) }
        .count()
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)

    if (parentA == parentB) {
        cycles.add(a)
        cycles.add(b)
    }

    parents[parentA] = parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
