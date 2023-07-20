package tags.sorting

/**
 * https://www.acmicpc.net/problem/2628
 */
fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val verticals = mutableListOf<Int>().apply {
        this.add(0)
        this.add(m)
    }
    val horizons = mutableListOf<Int>().apply {
        this.add(0)
        this.add(n)
    }
    val cuttingCount = readln().toInt()
    repeat(cuttingCount) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0) {
            horizons.add(b)
        } else {
            verticals.add(b)
        }
    }
    horizons.sort()
    verticals.sort()
    println(getMaxWidth(m, verticals) * getMaxHeight(n, horizons))
}

private fun getMaxWidth(width: Int, verticals: List<Int>) =
    (0 until verticals.size - 1).maxOfOrNull { i -> verticals[i + 1] - verticals[i] } ?: width

private fun getMaxHeight(height: Int, horizons: List<Int>) =
    (0 until horizons.size - 1).maxOfOrNull { i -> horizons[i + 1] - horizons[i] } ?: height
