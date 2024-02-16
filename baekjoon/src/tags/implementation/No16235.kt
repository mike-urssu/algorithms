package tags.implementation

/**
 * https://www.acmicpc.net/problem/16235
 */
private lateinit var nutrition: Array<IntArray>
private lateinit var graph: Array<IntArray>
private lateinit var trees: Array<Array<MutableList<Int>>>

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    nutrition = getNutrition(n)
    graph = Array(n + 1) { IntArray(n + 1) { 5 } }
    trees = getTrees(n, m)

    repeat(k) {
        val deadTrees = spring(n)
        summer(n, deadTrees)
        autumn(n)
        winter(n)
    }

    val count = (1..n).sumOf { i ->
        (1..n).sumOf { j ->
            trees[i][j].size
        }
    }
    println(count)
}

private fun getNutrition(n: Int): Array<IntArray> {
    val nutrition = Array(n + 1) { IntArray(n + 1) }
    (1..n).forEach { i ->
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(nutrition[i], 1)
    }
    return nutrition
}

private fun getTrees(n: Int, m: Int): Array<Array<MutableList<Int>>> {
    val trees = Array(n + 1) { Array(n + 1) { mutableListOf<Int>() } }
    repeat(m) {
        val (x, y, z) = readln().split(" ").map { it.toInt() }
        trees[x][y].add(z)
    }
    return trees
}

private fun spring(n: Int): Array<Array<MutableList<Int>>> {
    val newTrees = Array(n + 1) { Array(n + 1) { mutableListOf<Int>() } }
    val deadTrees = Array(n + 1) { Array(n + 1) { mutableListOf<Int>() } }

    sortTrees(trees, n)
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            trees[i][j].forEach { k ->
                if (k <= graph[i][j]) {
                    graph[i][j] -= k
                    newTrees[i][j].add(k + 1)
                } else {
                    deadTrees[i][j].add(k)
                }
            }
        }
    }

    trees = newTrees
    return deadTrees
}

private fun sortTrees(trees: Array<Array<MutableList<Int>>>, n: Int) {
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            trees[i][j].sort()
        }
    }
}

private fun summer(n: Int, deadTrees: Array<Array<MutableList<Int>>>) {
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            deadTrees[i][j].forEach { k ->
                graph[i][j] += k / 2
            }
        }
    }
}

private val dx = intArrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
private val dy = intArrayOf(-1, 0, 1, 1, 1, 0, -1, -1)

private fun autumn(n: Int) {
    (1..n).forEach { x ->
        (1..n).forEach { y ->
            trees[x][y].indices.forEach { k ->
                if (trees[x][y][k] != 0 && trees[x][y][k] % 5 == 0) {
                    for (i in 0 until 8) {
                        val nextX = x + dx[i]
                        val nextY = y + dy[i]
                        if (isInBoundary(n, nextX, nextY)) {
                            trees[nextX][nextY].add(1)
                        }
                    }
                }
            }
        }
    }
}

private fun isInBoundary(n: Int, x: Int, y: Int) =
    x in 1..n && y in 1..n

private fun winter(n: Int) {
    (1..n).forEach { i ->
        (1..n).forEach { j ->
            graph[i][j] += nutrition[i][j]
        }
    }
}
