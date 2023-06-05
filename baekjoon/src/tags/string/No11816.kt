package tags.string

/**
 * https://www.acmicpc.net/problem/11816
 */
fun main() {
    val x = readln()
    val n = if (x.startsWith("0x")) {
        x.substring(2).toInt(16)
    } else if (x.startsWith("0")) {
        x.substring(1).toInt(8)
    } else {
        x
    }
    println(n)
}
