package tags.disjoint_set

/**
 * https://www.acmicpc.net/problem/1043
 */
private lateinit var parties: Array<IntArray>
private lateinit var parents: IntArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val truthGroup = readln().split(" ").map { it.toInt() }.drop(1).toIntArray()
    parties = Array(m) { readln().split(" ").map { it.toInt() }.drop(1).toIntArray() }
    parents = IntArray(n + 1) { it }
    setParents()
    println(countParties(truthGroup))
}

private fun setParents() {
    parties.forEach { people ->
        people.indices.forEach { j ->
            union(people[0], people[j])
        }
    }
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)

    if (parentA > parentB) {
        parents[parentA] = parentB
    } else {
        parents[parentB] = parentA
    }
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}

private fun countParties(truthGroup: IntArray): Int {
    val truthParents = truthGroup.map { find(it) }.toSet()
    return parties.count { people ->
        people.all { find(it) !in truthParents }
    }
}
