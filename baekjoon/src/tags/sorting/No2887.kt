package tags.sorting

/**
 * https://www.acmicpc.net/problem/2887
 */
private val xs = mutableListOf<Pair<Int, Int>>()
private val ys = mutableListOf<Pair<Int, Int>>()
private val zs = mutableListOf<Pair<Int, Int>>()
private lateinit var parents: IntArray
private lateinit var distances: List<Triple<Int, Int, Int>>

fun main() {
    val n = readln().toInt()
    repeat(n) { i ->
        val (x, y, z) = readln().split(" ").map { it.toInt() }
        xs.add(Pair(x, i))
        ys.add(Pair(y, i))
        zs.add(Pair(z, i))
    }
    xs.sortWith(comparator())
    ys.sortWith(comparator())
    zs.sortWith(comparator())

    parents = IntArray(n) { it }
    distances = getDistances(n)

    println(getLeastCost())
}

private fun comparator() =
    Comparator<Pair<Int, Int>> { it, other -> it.first.compareTo(other.first) }

private fun getDistances(n: Int): List<Triple<Int, Int, Int>> {
    val distances = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 0 until n - 1) {
        distances.add(Triple(xs[i + 1].first - xs[i].first, xs[i].second, xs[i + 1].second))
        distances.add(Triple(ys[i + 1].first - ys[i].first, ys[i].second, ys[i + 1].second))
        distances.add(Triple(zs[i + 1].first - zs[i].first, zs[i].second, zs[i + 1].second))
    }
    distances.sortWith { it, other -> it.first.compareTo(other.first) }
    return distances
}

private fun getLeastCost(): Long {
    var cost = 0L
    for ((c, src, dst) in distances) {
        if (find(src) != find(dst)) {
            union(src, dst)
            cost += c
        }
    }
    return cost
}

private fun union(n1: Int, n2: Int) {
    val p1 = find(n1)
    val p2 = find(n2)
    if (p1 != p2) {
        parents[p2] = p1
    }
}

private fun find(n: Int): Int {
    if (n != parents[n]) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
