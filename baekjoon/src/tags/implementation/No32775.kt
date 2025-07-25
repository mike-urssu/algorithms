package tags.implementation

/**
 * https://www.acmicpc.net/problem/32775
 */
fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    if(a <= b) {
        println("high speed rail")
    } else {
        println("flight")
    }
}
