package tags.string

/**
 * https://www.acmicpc.net/problem/3449
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val b1 = readln()
        val b2 = readln()
        println("Hamming distance is ${getHammingDistance(b1, b2)}.")
    }
}

private fun getHammingDistance(b1: String, b2: String) =
    b1.indices.filterIndexed { i, _ -> b1[i] != b2[i] }.count()
