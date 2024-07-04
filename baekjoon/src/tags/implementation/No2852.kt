package tags.implementation

/**
 * https://www.acmicpc.net/problem/2852
 */
fun main() {
    val n = readln().toInt()
    val seconds = IntArray(3)
    var record = 0
    val scores = IntArray(3)

    repeat(n) {
        readln().split(" ", ":").map { it.toInt() }.run {
            val team = this[0]
            val second = this[1] * 60 + this[2]
            if (scores[1] > scores[2]) {
                seconds[1] += second - record
            } else if (scores[1] < scores[2]) {
                seconds[2] += second - record
            }
            record = second
            scores[team]++
        }
    }
    if (scores[1] > scores[2]) {
        seconds[1] += 48 * 60 - record
    } else if (scores[1] < scores[2]) {
        seconds[2] += 48 * 60 - record
    }

    println(parse(seconds[1]))
    println(parse(seconds[2]))
}

private fun parse(second: Int) =
    "${String.format("%02d", second / 60)}:${String.format("%02d", second % 60)}"
