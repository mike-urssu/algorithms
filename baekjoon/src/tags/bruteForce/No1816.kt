package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1816
 */
private val isPrime = BooleanArray(1000001) { true }

fun main() {
    setPrimes()

    val testCase = readln().toInt()
    repeat(testCase) {
        var adequateKey = true

        val s = readln().toLong()
        for (i in 2..1000000) {
            if (isPrime[i] && s % i == 0L) {
                adequateKey = false
                break
            }
        }

        if (adequateKey) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun setPrimes() {
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..1000) {
        for (j in i * i..1000 step i) {
            isPrime[j] = false
        }
    }
}
