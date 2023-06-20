package tags.string

/**
 * https://www.acmicpc.net/problem/2153
 */
fun main() {
    val alphabets = mutableListOf<Char>().apply {
        this.add('.')
        this.addAll('a'..'z')
        this.addAll('A'..'Z')
    }
    val s = readln()
    val sum = s.sumOf { alphabets.indexOf(it) }
    if (isPrime(sum)) {
        println("It is a prime word.")
    } else {
        println("It is not a prime word.")
    }
}

private fun isPrime(n: Int): Boolean {
    val isPrime = BooleanArray(1041) { true }
    for (i in 2 until isPrime.size) {
        for (j in i * i until isPrime.size step i) {
            isPrime[j] = false
        }
    }
    return isPrime[n]
}
