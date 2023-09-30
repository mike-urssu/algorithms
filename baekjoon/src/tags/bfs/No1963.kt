package tags.bfs

/**
 * https://www.acmicpc.net/problem/1963
 */
import java.util.LinkedList
import java.util.Queue

private val isPrime = getPrimes()
private lateinit var isVisited: BooleanArray

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val count = getCount(a, b)
        if (count == -1) {
            println("Impossible")
        } else {
            println(count)
        }
    }
}

private fun getPrimes(): BooleanArray {
    val primes = BooleanArray(10000) { true }
    primes[0] = false
    primes[1] = false
    for (i in 2..100) {
        for (j in i * i until 10000 step i) {
            primes[j] = false
        }
    }
    return primes
}

private fun getCount(a: Int, b: Int): Int {
    isVisited = BooleanArray(10000)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[a] = true
    queue.add(Pair(a, 0))

    while (queue.isNotEmpty()) {
        val (n, c) = queue.poll()
        if (n == b) {
            return c
        }

        getNextPrimes(n)
            .filter { !isVisited[it] }
            .forEach { i ->
                isVisited[i] = true
                queue.add(Pair(i, c + 1))
            }
    }
    return -1
}

private fun getNextPrimes(n: Int) =
    (1000 until 10000).filter { i -> isPrime[i] && compareDigit(n, i) && !isVisited[i] }

private fun compareDigit(n: Int, m: Int): Boolean {
    var count = 0
    var a = n
    var b = m
    while (a > 0) {
        if (a % 10 != b % 10) {
            count++
        }
        a /= 10
        b /= 10
    }
    return count == 1
}
