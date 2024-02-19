package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/9471
 */
fun main() {
    val p = readln().toInt()
    repeat(p) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        println("$n ${k(m)}")
    }
}

private fun k(m: Int): Int {
    val sequence = mutableListOf<Int>().apply {
        this.add(0)
        this.add(1)
    }

    var index = 2
    while (true) {
        sequence.add((sequence[index - 1] + sequence[index - 2]) % m)
        if (sequence[index - 1] == 0 && sequence[index] == 1) {
            break
        }
        index++
    }
    return index - 1
}
