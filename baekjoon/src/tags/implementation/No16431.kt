package tags.implementation

/**
 * https://www.acmicpc.net/problem/16431
 */
import kotlin.math.abs

fun main() {
    val (br, bc) = readln().split(" ").map { it.toInt() }
    val (dr, dc) = readln().split(" ").map { it.toInt() }
    val (jr, jc) = readln().split(" ").map { it.toInt() }

    val gap1 = (abs(br - jr) + abs(bc - jc) + 1) / 2
    val gap2 = abs(dr - jr) + abs(dc - jc)
    val winner = if (gap1 > gap2) {
        "daisy"
    } else if (gap1 == gap2) {
        "tie"
    } else {
        "bessie"
    }

    println(winner)
}
