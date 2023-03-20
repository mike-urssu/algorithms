package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/10448
 */
private val triangles = mutableListOf<Int>()

fun main() {
    for (i in 1..43) {
        triangles.add(i * (i + 1) / 2)
    }

    val testCase = readln().toInt()
    repeat(testCase) {
        val k = readln().toInt()
        if (canMakeN(k)) {
            println(1)
        } else {
            println(0)
        }
    }
}

private fun canMakeN(n: Int): Boolean {
    for (i in triangles.indices) {
        for (j in triangles.indices) {
            for (k in triangles.indices) {
                if (triangles[i] + triangles[j] + triangles[k] == n) {
                    return true
                }
            }
        }
    }
    return false
}
