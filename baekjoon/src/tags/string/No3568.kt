package tags.string

/**
 * https://www.acmicpc.net/problem/3568
 */
import java.util.Stack

fun main() {
    val s = readln()
    val split = s.split(' ')
    val primitiveType = split[0]

    split
        .drop(1)
        .map { it.replace("[,;]".toRegex(), "") }
        .forEach {
            val name = StringBuilder()
            var index = 0
            while (index < it.length && it[index].isLetter()) {
                name.append(it[index++])
            }

            val stack = Stack<String>()
            while (index < it.length) {
                when (it[index]) {
                    '[' -> {
                        stack.push("[]")
                        index += 2
                    }

                    '&' -> {
                        stack.push("&")
                        index++
                    }

                    '*' -> {
                        stack.push("*")
                        index++
                    }
                }
            }

            val sentence = StringBuilder(primitiveType)
            while (stack.isNotEmpty()) {
                sentence.append(stack.pop())
            }
            sentence.append(" $name;")
            println(sentence)
        }
}
