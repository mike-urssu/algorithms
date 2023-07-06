package tags.bruteforcing

import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/4690
 */
fun main() {
    for (a in 1..100) {
        for (b in 2..100) {
            for (c in b..100) {
                for (d in c..100) {
                    val powA = a.toDouble().pow(3).toInt()
                    val powB = b.toDouble().pow(3).toInt()
                    val powC = c.toDouble().pow(3).toInt()
                    val powD = d.toDouble().pow(3).toInt()

                    if (powA < powB + powC + powD) {
                        break
                    } else if (powA == powB + powC + powD) {
                        println("Cube = $a, Triple = ($b,$c,$d)")
                    }
                }
            }
        }
    }
}
