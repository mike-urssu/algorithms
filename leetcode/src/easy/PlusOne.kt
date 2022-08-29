package easy

import java.math.BigInteger

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val number = digitsToInt(digits).plus(BigInteger.ONE)
        return intToDigits(number)
    }

    private fun digitsToInt(digits: IntArray): BigInteger {
        var sum = BigInteger.valueOf(0)
        for (index in digits.indices)
            sum = sum.multiply(BigInteger.TEN).plus(BigInteger.valueOf(digits[index].toLong()))
        return sum
    }

    private fun intToDigits(number: BigInteger): IntArray {
        return number.toString()
            .map { it.digitToInt() }        // .map { it.toInt() - '0'.toInt() }
            .toIntArray()
    }
}