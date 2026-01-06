package tags.ad_hoc

/**
 * https://www.acmicpc.net/problem/23253
 */
fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val dummies = Array(m) {
        readln()
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val isValid = dummies.all { dummy -> dummy.contentEquals(dummy.sortedArrayDescending()) }
    if (isValid) {
        println("Yes")
    } else {
        println("No")
    }
}
