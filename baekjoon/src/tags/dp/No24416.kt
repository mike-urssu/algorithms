package tags.dp

/**
 * https://www.acmicpc.net/problem/24416
 */
fun main() {
    val n = readln().toInt()
    fibo(n)
    fibonacci(n)
    println("$fiboCount $fibonacciCount")
}

private var fiboCount = 1
private fun fibo(n: Int): Int {
    return if (n == 1 || n == 2) {
        n
    } else {
        fiboCount++
        fibo(n - 2) + fibo(n - 1)
    }
}

private var fibonacciCount = 0
private fun fibonacci(n: Int): IntArray {
    val fibonacci = IntArray(n + 1)
    fibonacci[1] = 1
    fibonacci[2] = 1
    for (i in 3..n) {
        fibonacciCount++
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1]
    }
    return fibonacci
}
