package tags.string

/**
 * https://www.acmicpc.net/problem/1439
 */
fun main() {
    val s = readln()
    var count = 0
    var previousChar = s.first()
    for (ch in s) {
        if (previousChar != ch) {
            previousChar = ch
            count++
        }
    }
    println((count + 1) / 2)
}
