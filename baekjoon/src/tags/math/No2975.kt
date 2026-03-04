package tags.math

/**
 * https://www.acmicpc.net/problem/2975
 */
fun main() {
    while (true) {
        val s = readln()
        if (s == "0 W 0") {
            break
        }
        val split = s.split(" ")
        val a = split[0].toInt()
        val wd = split[1]
        val b = split[2].toInt()
        if (wd == "W") {
            val v = a - b
            if (v < -200) {
                println("Not allowed")
            } else {
                println(v)
            }
        } else {
            println(a + b)
        }
    }
}
