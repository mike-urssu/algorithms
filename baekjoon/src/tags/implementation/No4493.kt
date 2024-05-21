package tags.implementation

/**
 * https://www.acmicpc.net/problem/4493
 */
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        var score1 = 0
        var score2 = 0
        repeat(n) {
            val (a, b) = readln().split(" ")
            when (a) {
                "R" -> {
                    if (b == "S") {
                        score1++
                    } else if (b == "P") {
                        score2++
                    }
                }

                "S" -> {
                    if (b == "P") {
                        score1++
                    } else if (b == "R") {
                        score2++
                    }
                }

                "P" -> {
                    if (b == "S") {
                        score2++
                    } else if (b == "R") {
                        score1++
                    }
                }
            }
        }
        if (score1 > score2) {
            println("Player 1")
        } else if (score1 == score2) {
            println("TIE")
        } else {
            println("Player 2")
        }
    }
}
