package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/1759
 */
private val vowels = mutableListOf<Char>()
private val consonants = mutableListOf<Char>()
private lateinit var vList: MutableList<List<Char>>
private lateinit var cList: MutableList<List<Char>>
private val combinations = sortedSetOf<String>()

fun main() {
    val (l, _) = readln().split(" ").map { it.toInt() }
    val characters = readln().split(" ").map { it[0] }
    separateCharacters(characters)

    for (i in 1..l - 2) {
        vList = mutableListOf()
        cList = mutableListOf()

        combination(vList, vowels, CharArray(i), vowels.size, i, 0, 0)
        combination(cList, consonants, CharArray(l - i), consonants.size, l - i, 0, 0)

        mergeLists(vList, cList)
    }

    combinations.forEach { println(it) }
}

private fun separateCharacters(characters: List<Char>) {
    val filter = setOf('a', 'e', 'i', 'o', 'u')
    characters.forEach {
        if (filter.contains(it)) {
            vowels.add(it)
        } else {
            consonants.add(it)
        }
    }
}

private fun combination(
    list: MutableList<List<Char>>,
    characters: List<Char>,
    combination: CharArray,
    n: Int,
    r: Int,
    index: Int,
    i: Int
) {
    if (index == r) {
        list.add(combination.toList())
        return
    }

    if (i >= n) {
        return
    }

    combination[index] = characters[i]
    combination(list, characters, combination, n, r, index + 1, i + 1)
    combination(list, characters, combination, n, r, index, i + 1)
}

private fun mergeLists(list1: List<List<Char>>, list2: List<List<Char>>) {
    for (l1 in list1) {
        for (l2 in list2) {
            val combination = setOf(l1, l2).flatten().sorted().joinToString("")
            combinations.add(combination)
        }
    }
}
