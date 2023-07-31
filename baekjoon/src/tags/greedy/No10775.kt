package tags.greedy

/**
 * https://www.acmicpc.net/problem/10775
 */
private lateinit var gates: IntArray

fun main() {
    val g = readln().toInt()
    val p = readln().toInt()
    gates = IntArray(g + 1) { it }
    val planes = IntArray(p) { readln().toInt() }

    var count = 0
    for (plane in planes) {
        val gate = find(plane)
        if (gate == 0) {
            break
        }
        union(gate, gate - 1)
        count++
    }
    println(count)
}

private fun find(x: Int): Int {
    if (x == gates[x]) {
        return x
    }
    gates[x] = find(gates[x])
    return gates[x]
}

private fun union(x: Int, y: Int) {
    val x2 = find(x)
    val y2 = find(y)
    if (x2 != y2) {
        gates[x2] = y2
    }
}
