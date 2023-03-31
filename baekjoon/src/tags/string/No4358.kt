package tags.string

/**
 * https://www.acmicpc.net/problem/4358
 */
fun main() {
    val species = sortedMapOf<String, Int>()
    while (true) {
        val specie = readlnOrNull() ?: break
        species[specie] = species.getOrDefault(specie, 0) + 1
    }

    val total = species.values.sum()
    species.forEach { (key, value) ->
        println("$key ${String.format("%.4f", value * 100.0 / total)}")
    }
}
