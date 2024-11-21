package tags.sweeping

/**
 * https://www.acmicpc.net/problem/1911
 */
fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val puddles = Array(n) {
        val (from, to) = readln().split(" ").map { it.toLong() }
        from to to - 1
    }.sortedBy { it.first }

    val sweptPuddles = sweep(n, l, puddles)
    val count = sweptPuddles.sumOf { (from, to) -> (to - from + l) / l }
    println(count)
}

private fun sweep(n: Int, l: Int, puddles: List<Pair<Long, Long>>): List<Pair<Long, Long>> {
    val sweptPuddles = mutableListOf<Pair<Long, Long>>()
    var index = 0
    var (from, to) = puddles[index++]
    while (index < n) {
        val mod = (to - from + 1) % l
        if (mod != 0L) {
            to += -mod + l
        }
        val (f, t) = puddles[index]
        if (to >= f) {
            to = t
        } else {
            sweptPuddles.add(from to to)
            from = f
            to = t
        }
        index++
    }
    sweptPuddles.add(from to to)
    return sweptPuddles
}
