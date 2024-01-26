package tags.implementation

/**
 * https://www.acmicpc.net/problem/1917
 */
fun main() {
    repeat(3) {
        val expandedView = Array(6) { readln().split(" ").map { it.toInt() }.toIntArray() }
        if (isPortraitOrientedCube(expandedView)) {
            println("yes")
        } else if (isLandscapeOrientedCube(expandedView)) {
            println("yes")
        } else if (is222(expandedView)) {
            println("yes")
        } else {
            println("no")
        }
    }
}

private fun isPortraitOrientedCube(expandedView: Array<IntArray>): Boolean {
    for (j in 0 until 6) {
        var count = 0
        for (i in 0 until 6) {
            if (expandedView[i][j] == 1) {
                count++
                if (count == 3) {
                    if (portrait33(expandedView, i - 2..i, j)) {
                        return true
                    } else if (portrait231(expandedView, i - 2..i, j)) {
                        return true
                    }
                } else if (count == 4) {
                    if (portrait42(expandedView, i - 3..i, j)) {
                        return true
                    } else if (portrait141(expandedView, i - 3..i, j)) {
                        return true
                    }
                }
            } else {
                count = 0
            }
        }
    }
    return false
}

private fun portrait33(expandedView: Array<IntArray>, rowRange: IntRange, col: Int): Boolean {
    if (col + 1 < 6) {
        if (0 <= rowRange.first - 2) {
            if (rowRange.all { i -> expandedView[i - 2][col + 1] == 1 }) {
                return true
            }
        } else if (rowRange.last() + 2 < 6) {
            if (rowRange.all { i -> expandedView[i + 2][col + 1] == 1 }) {
                return true
            }
        }
    }
    return false
}

private fun portrait231(expandedView: Array<IntArray>, rowRange: IntRange, col: Int): Boolean {
    if (col == 0 || col == 5) {
        return false
    }

    if (0 <= rowRange.first - 1 && expandedView[rowRange.first][col - 1] == 1 && expandedView[rowRange.first - 1][col - 1] == 1) {
        if (rowRange.count { i -> expandedView[i][col + 1] == 1 } == 1) {
            return true
        }
    } else if (rowRange.last + 1 < 6 && expandedView[rowRange.last][col - 1] == 1 && expandedView[rowRange.last + 1][col - 1] == 1) {
        if (rowRange.count { i -> expandedView[i][col + 1] == 1 } == 1) {
            return true
        }
    } else if (0 <= rowRange.first - 1 && expandedView[rowRange.first][col + 1] == 1 && expandedView[rowRange.first - 1][col + 1] == 1) {
        if (rowRange.count { i -> expandedView[i][col - 1] == 1 } == 1) {
            return true
        }
    } else if (rowRange.last + 1 < 6 && expandedView[rowRange.last][col + 1] == 1 && expandedView[rowRange.last + 1][col + 1] == 1) {
        if (rowRange.count { i -> expandedView[i][col - 1] == 1 } == 1) {
            return true
        }
    }
    return false
}

private fun portrait42(expandedView: Array<IntArray>, rowRange: IntRange, col: Int): Boolean {
    if (col + 2 < 6) {
        if (rowRange.any { i -> expandedView[i][col + 1] == 1 && expandedView[i][col + 2] == 1 }) {
            return true
        }
    }
    return rowRange.any { i ->
        0 <= col - 2
                && expandedView[i][col - 1] == 1
                && expandedView[i][col - 2] == 1
    }
}

private fun portrait141(expandedView: Array<IntArray>, rowRange: IntRange, col: Int): Boolean {
    return (col - 1 >= 0 && col + 1 < 6)
            && (rowRange.count { i -> expandedView[i][col - 1] == 1 } == 1)
            && (rowRange.count { i -> expandedView[i][col + 1] == 1 } == 1)
}

private fun isLandscapeOrientedCube(expandedView: Array<IntArray>): Boolean {
    for (i in 0 until 6) {
        var count = 0
        for (j in 0 until 6) {
            if (expandedView[i][j] == 1) {
                count++
                if (count == 3) {
                    if (landscape33(expandedView, i, j - 2..j)) {
                        return true
                    } else if (landscape231(expandedView, i, j - 2..j)) {
                        return true
                    }

                } else if (count == 4) {
                    if (landscape42(expandedView, i, j - 3..j)) {
                        return true
                    } else if (landscape141(expandedView, i, j - 3..j)) {
                        return true
                    }
                }
            } else {
                count = 0
            }
        }
    }

    return false
}

private fun landscape33(expandedView: Array<IntArray>, row: Int, colRange: IntRange): Boolean {
    if (row + 1 < 6) {
        if (0 <= colRange.first - 2) {
            if (colRange.all { j -> expandedView[row + 1][j - 2] == 1 }) {
                return true
            }
        } else if (colRange.last + 2 < 6) {
            if (colRange.all { j -> expandedView[row + 1][j + 2] == 1 }) {
                return true
            }
        }
    }
    return false
}

private fun landscape231(expandedView: Array<IntArray>, row: Int, colRange: IntRange): Boolean {
    if (row == 0 || row == 5) {
        return false
    }

    if (0 <= colRange.first - 1 && expandedView[row - 1][colRange.first] == 1 && expandedView[row - 1][colRange.first - 1] == 1) {
        if (colRange.count { j -> expandedView[row + 1][j] == 1 } == 1) {
            return true
        }
    } else if (colRange.last + 1 < 6 && expandedView[row - 1][colRange.last] == 1 && expandedView[row - 1][colRange.last + 1] == 1) {
        if (colRange.count { j -> expandedView[row + 1][j] == 1 } == 1) {
            return true
        }
    } else if (0 <= colRange.first - 1 && expandedView[row + 1][colRange.first] == 1 && expandedView[row + 1][colRange.first - 1] == 1) {
        if (colRange.count { j -> expandedView[row - 1][j] == 1 } == 1) {
            return true
        }
    } else if (colRange.last + 1 < 6 && expandedView[row + 1][colRange.last] == 1 && expandedView[row + 1][colRange.last + 1] == 1) {
        if (colRange.count { j -> expandedView[row - 1][j] == 1 } == 1) {
            return true
        }
    }
    return false
}

private fun landscape42(expandedView: Array<IntArray>, row: Int, colRange: IntRange): Boolean {
    if (colRange.first == 1 || colRange.first == 2) {
        if (0 <= row - 1 && expandedView[row - 1][colRange.first] == 1 && expandedView[row - 1][colRange.first - 1] == 1) {
            return true
        } else if (row + 1 < 6 && expandedView[row + 1][colRange.first] == 1 && expandedView[row + 1][colRange.first - 1] == 1) {
            return true
        }
    }

    if (colRange.last == 3 || colRange.last == 4) {
        if (0 <= row - 1 && expandedView[row - 1][colRange.last] == 1 && expandedView[row - 1][colRange.last + 1] == 1) {
            return true
        } else if (row + 1 < 6 && expandedView[row + 1][colRange.last] == 1 && expandedView[row + 1][colRange.last + 1] == 1) {
            return true
        }
    }
    return false
}

private fun landscape141(expandedView: Array<IntArray>, row: Int, colRange: IntRange): Boolean {
    return if (0 <= row - 1 && row + 1 < 6) {
        (colRange.count { j -> expandedView[row - 1][j] == 1 } == 1)
                && (colRange.count { j -> expandedView[row + 1][j] == 1 } == 1)
    } else {
        false
    }
}

private fun is222(expandedView: Array<IntArray>): Boolean {
    for (i in 0..3) {
        for (j in 0..2) {
            if (expandedView[i][j] == 1 && expandedView[i][j + 1] == 1) {
                if (expandedView[i + 1][j + 1] == 1 && expandedView[i + 1][j + 2] == 1) {
                    if (expandedView[i + 2][j + 2] == 1 && expandedView[i + 2][j + 3] == 1) {
                        return true
                    }
                }
            }
        }
    }

    for (i in 0..3) {
        for (j in 5 downTo 3) {
            if (expandedView[i][j] == 1 && expandedView[i][j - 1] == 1) {
                if (expandedView[i + 1][j - 1] == 1 && expandedView[i + 1][j - 2] == 1) {
                    if (expandedView[i + 2][j - 2] == 1 && expandedView[i + 2][j - 3] == 1) {
                        return true
                    }
                }
            }
        }
    }

    for (j in 0..3) {
        for (i in 5 downTo 3) {
            if (expandedView[i][j] == 1 && expandedView[i - 1][j] == 1) {
                if (expandedView[i - 1][j + 1] == 1 && expandedView[i - 2][j + 1] == 1) {
                    if (expandedView[i - 2][j + 2] == 1 && expandedView[i - 3][j + 2] == 1) {
                        return true
                    }
                }
            }
        }
    }

    for (j in 0..3) {
        for (i in 0..2) {
            if (expandedView[i][j] == 1 && expandedView[i + 1][j] == 1) {
                if (expandedView[i + 1][j + 1] == 1 && expandedView[i + 2][j + 1] == 1) {
                    if (expandedView[i + 2][j + 2] == 1 && expandedView[i + 3][j + 2] == 1) {
                        return true
                    }
                }
            }
        }
    }

    return false
}
