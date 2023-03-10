package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2930
 */
fun main() {
    val r = readln().toInt()
    val myInput = readln().toCharArray()
    val n = readln().toInt()
    val inputs = Array(n) { readln().toCharArray() }

    println(calculateScore(r, myInput, inputs))
    println(calculateMaxScore(r, n, inputs))
}

private fun calculateScore(r: Int, myInput: CharArray, inputs: Array<CharArray>) =
    inputs.sumOf { input -> (0 until r).sumOf { getScore(myInput[it], input[it]) } }

private fun getScore(input1: Char, input2: Char): Int {
    when (input1) {
        'R' -> {
            return when (input2) {
                'S' -> 2
                'R' -> 1
                else -> 0
            }
        }

        'S' -> {
            return when (input2) {
                'P' -> 2
                'S' -> 1
                else -> 0
            }
        }

        else -> {
            return when (input2) {
                'R' -> 2
                'P' -> 1
                else -> 0
            }
        }
    }
}

private fun calculateMaxScore(r: Int, n: Int, inputs: Array<CharArray>): Int {
    return (0 until r).sumOf { i ->
        val input = CharArray(n) { inputs[it][i] }
        intArrayOf(getScores(input, 'R'), getScores(input, 'S'), getScores(input, 'P')).max()
    }
}

private fun getScores(input: CharArray, rsc: Char) =
    input.sumOf { getScore(rsc, it) }
