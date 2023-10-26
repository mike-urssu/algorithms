package tags.string

/**
 * https://www.acmicpc.net/problem/2290
 */
fun main() {
    val input = readln().split(" ")
    val s = input[0].toInt()
    val n = input[1].map { it.digitToInt() }.toIntArray()
    print(getLCD(s, n))
}

private fun getLCD(s: Int, n: IntArray): String {
    val lcd = StringBuilder()
    for (i in 0 until 2 * s + 3) {
        n.forEach {
            when (it) {
                0 -> lcd.append(getZero(s, i))
                1 -> lcd.append(getOne(s, i))
                2 -> lcd.append(getTwo(s, i))
                3 -> lcd.append(getThree(s, i))
                4 -> lcd.append(getFour(s, i))
                5 -> lcd.append(getFive(s, i))
                6 -> lcd.append(getSix(s, i))
                7 -> lcd.append(getSeven(s, i))
                8 -> lcd.append(getEight(s, i))
                9 -> lcd.append(getNine(s, i))
            }
            lcd.append(" ")
        }
        lcd.append("\n")
    }
    return lcd.toString()
}

private fun getZero(s: Int, row: Int): String {
    val zero = StringBuilder()
    when (row) {
        0, 2 * s + 2 -> {
            zero.append(" ")
            zero.append("-".repeat(s))
            zero.append(" ")
        }

        s + 1 -> {
            zero.append(" ".repeat(s + 2))
        }

        else -> {
            zero.append("|")
            zero.append(" ".repeat(s))
            zero.append("|")
        }
    }
    return zero.toString()
}

private fun getOne(s: Int, row: Int): String {
    val one = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            one.append(" ".repeat(s + 2))
        }

        else -> {
            one.append(" ".repeat(s + 1))
            one.append("|")
        }
    }
    return one.toString()
}

private fun getTwo(s: Int, row: Int): String {
    val two = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            two.append(" ")
            two.append("-".repeat(s))
            two.append(" ")
        }

        in 1..s -> {
            two.append(" ".repeat(s + 1))
            two.append("|")
        }

        else -> {
            two.append("|")
            two.append(" ".repeat(s + 1))
        }
    }
    return two.toString()
}

private fun getThree(s: Int, row: Int): String {
    val three = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            three.append(" ")
            three.append("-".repeat(s))
            three.append(" ")
        }

        else -> {
            three.append(" ".repeat(s + 1))
            three.append("|")
        }
    }
    return three.toString()
}

private fun getFour(s: Int, row: Int): String {
    val four = StringBuilder()
    when (row) {
        0, 2 * s + 2 -> {
            four.append(" ".repeat(s + 2))
        }

        s + 1 -> {
            four.append(" ")
            four.append("-".repeat(s))
            four.append(" ")
        }

        in 1..s -> {
            four.append("|")
            four.append(" ".repeat(s))
            four.append("|")
        }

        else -> {
            four.append(" ".repeat(s + 1))
            four.append("|")
        }
    }
    return four.toString()
}

private fun getFive(s: Int, row: Int): String {
    val five = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            five.append(" ")
            five.append("-".repeat(s))
            five.append(" ")
        }

        in 1..s -> {
            five.append("|")
            five.append(" ".repeat(s + 1))
        }

        else -> {
            five.append(" ".repeat(s + 1))
            five.append("|")
        }
    }
    return five.toString()
}

private fun getSix(s: Int, row: Int): String {
    val six = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            six.append(" ")
            six.append("-".repeat(s))
            six.append(" ")
        }

        in 1..s -> {
            six.append("|")
            six.append(" ".repeat(s + 1))
        }

        else -> {
            six.append("|")
            six.append(" ".repeat(s))
            six.append("|")
        }
    }
    return six.toString()
}

private fun getSeven(s: Int, row: Int): String {
    val seven = StringBuilder()
    when (row) {
        0 -> {
            seven.append(" ")
            seven.append("-".repeat(s))
            seven.append(" ")
        }

        s + 1, 2 * s + 2 -> {
            seven.append(" ".repeat(s + 2))
        }

        else -> {
            seven.append(" ".repeat(s + 1))
            seven.append("|")
        }
    }
    return seven.toString()
}

private fun getEight(s: Int, row: Int): String {
    val eight = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            eight.append(" ")
            eight.append("-".repeat(s))
            eight.append(" ")
        }

        else -> {
            eight.append("|")
            eight.append(" ".repeat(s))
            eight.append("|")
        }
    }
    return eight.toString()
}

private fun getNine(s: Int, row: Int): String {
    val nine = StringBuilder()
    when (row) {
        0, s + 1, 2 * s + 2 -> {
            nine.append(" ")
            nine.append("-".repeat(s))
            nine.append(" ")
        }

        in 1..s -> {
            nine.append("|")
            nine.append(" ".repeat(s))
            nine.append("|")
        }

        else -> {
            nine.append(" ".repeat(s + 1))
            nine.append("|")
        }
    }
    return nine.toString()
}
