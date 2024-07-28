package tags.string

/**
 * https://www.acmicpc.net/problem/8595
 */
fun main() {
    val n = readln().toInt()
    val s = readln()
    var sum = 0L
    var index = 0
    var v = 0
    while (index < n) {
        if (s[index] in '0'..'9') {
            v = v * 10 + s[index].digitToInt()
        } else {
            sum += v
            v = 0
        }
        index++
    }
    sum += v
    println(sum)
}
