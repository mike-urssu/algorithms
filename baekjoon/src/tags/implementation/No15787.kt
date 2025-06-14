package tags.implementation

/**
 * https://www.acmicpc.net/problem/15787
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val trains = IntArray(n + 1)
    val max = (1 shl 21) - 1
    val invertedOne = max - 1

    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        when (input[0]) {
            1 -> {
                val (_, i, x) = input
                trains[i] = trains[i] or (1 shl x)
            }

            2 -> {
                val (_, i, x) = input
                trains[i] = trains[i] and (1 shl x).inv()
            }

            3 -> {
                val i = input[1]
                trains[i] = (trains[i] shl 1) and max
            }

            else -> {
                val i = input[1]
                trains[i] = (trains[i] shr 1) and invertedOne
            }
        }
    }
    println(trains.drop(1).distinct().size)
}
