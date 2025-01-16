package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2436
 */
private lateinit var factors: List<Int>
private lateinit var isVisited: BooleanArray
private var m = 0
private var n = 0
private var min = Int.MAX_VALUE

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    factors = factors(a.toLong() * b)
    isVisited = BooleanArray(factors.size)

    find(factors.size, 0, a)

    println("$n $m")
}

private fun factors(n: Long): List<Int> {
    val factors = mutableListOf<Int>()
    var _n = n
    var i = 2
    while (_n > 1) {
        if (_n % i == 0L) {
            factors.add(i)
            _n /= i
        } else {
            i++
        }
    }
    return factors
}

private fun find(size: Int, r: Int, gcd: Int) {
    if (r == size) {
        var a = 1
        var b = 1

        (0 until size).forEach { i ->
            if (isVisited[i]) {
                a *= factors[i]
            } else {
                b *= factors[i]
            }
        }

        if (gcd(a, b) == gcd) {
            if (a + b < min) {
                if (a < b) {
                    n = a
                    m = b
                } else {
                    n = b
                    m = a
                }
                min = a + b
            }
        }
        return
    }

    isVisited[r] = false
    find(size, r + 1, gcd)
    isVisited[r] = true
    find(size, r + 1, gcd)
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        gcd(b, a % b)
    }
}
