package easy

fun main() {
    val plusOne = PlusOne()
    assert(plusOne.plusOne(intArrayOf(1, 2, 3)).contentEquals(intArrayOf(1, 2, 4)))
    assert(plusOne.plusOne(intArrayOf(4, 3, 2, 1)).contentEquals(intArrayOf(4, 3, 2, 2)))
    assert(plusOne.plusOne(intArrayOf(9)).contentEquals(intArrayOf(1, 0)))

    assert(
        plusOne.plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
            .contentEquals(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1))
    )
}