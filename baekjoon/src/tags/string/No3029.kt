package tags.string

/**
 * https://www.acmicpc.net/problem/3029
 */
fun main() {
    val t1 = readln()
    val t2 = readln()
    val s1 = getSeconds(t1)
    val s2 = getSeconds(t2)
    println(getWaitingTime(s1, s2))
}

private fun getSeconds(time: String): Int {
    val units = time.split(":").map { it.toInt() }
    return units[0] * 3600 + units[1] * 60 + units[2]
}

private fun getWaitingTime(s1: Int, s2: Int): String {
    var s = if (s1 >= s2) {
        s2 - s1 + 3600 * 24
    } else {
        s2 - s1
    }
    val h = s / 3600
    s %= 3600
    val m = s / 60
    s %= 60
    return arrayOf(String.format("%02d", h), String.format("%02d", m), String.format("%02d", s)).joinToString(":")
}
