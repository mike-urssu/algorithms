package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2503
 */
fun main() {
    val question = readln().toInt()

    val candidates = BooleanArray(1000)
    val numbers = IntArray(question)
    val strikes = IntArray(question)
    val balls = IntArray(question)
    for (i in 0 until question) {
        val (number, strike, ball) = readln().split(" ").map { it.toInt() }
        numbers[i] = number
        strikes[i] = strike
        balls[i] = ball
    }

    setCandidates(candidates, numbers, strikes, balls)

    val count = candidates.count { it }
    println(count)
}

private fun setCandidates(candidates: BooleanArray, numbers: IntArray, strikes: IntArray, balls: IntArray) {
    for (i in candidates.indices) {
        val n = String.format("%03d", i)
        if (isValidNumber(n)) {
            if (canBeACandidate(n, numbers, strikes, balls)) {
                candidates[i] = true
            }
        }
    }
}

private fun canBeACandidate(number: String, numbers: IntArray, strikes: IntArray, balls: IntArray): Boolean {
    var isValid = true
    for (i in numbers.indices) {
        val strike = getStrike(number, numbers[i].toString())
        val ball = getBall(number, numbers[i].toString())
        if (strike != strikes[i] || ball != balls[i]) {
            isValid = false
            break
        }
    }
    return isValid
}

private fun isValidNumber(number: String) =
    !number.contains("0") && number.toCharArray().distinct().size == 3

private fun getStrike(number1: String, number2: String): Int {
    var strike = 0
    for (i in 0 until 3) {
        if (number1[i] == number2[i]) {
            strike++
        }
    }
    return strike
}

private fun getBall(number1: String, number2: String): Int {
    var ball = 0
    for (i in number1.indices) {
        val index = number2.indexOf(number1[i])
        if (index != -1 && index != i) {
            ball++
        }
    }
    return ball
}
