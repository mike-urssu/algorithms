package tags.trees

/**
 * https://www.acmicpc.net/problem/9934
 */
private var k = 0
private lateinit var depths: Array<MutableList<Int>>
private lateinit var nodes: IntArray
private var index = 0

fun main() {
    k = readln().toInt()
    nodes = readln().split(" ").map { it.toInt() }.toIntArray()
    depths = Array(k + 1) { mutableListOf() }

    visit(1, 1)

    (1..k).forEach { println(depths[it].joinToString(" ")) }
}

private fun visit(depth: Int, node: Int) {
    if (depth > k) {
        return
    }
    visit(depth + 1, node * 2)
    depths[depth].add(nodes[index++])
    visit(depth + 1, node * 2 + 1)
}
