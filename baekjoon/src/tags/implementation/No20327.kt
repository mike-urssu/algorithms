package tags.implementation

/**
 * https://www.acmicpc.net/problem/20327
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, r) = readln().split(" ").map { it.toInt() }
    val size = 1 shl n
    graph = Array(size) { readln().split(" ").map { it.toInt() }.toIntArray() }
    repeat(r) {
        val (k, l) = readln().split(" ").map { it.toInt() }
        val chunkSize = 1 shl l
        when (k) {
            1 -> case1(size, chunkSize)
            2 -> case2(size, chunkSize)
            3 -> case3(size, chunkSize)
            4 -> case4(size, chunkSize)
            5 -> case5(size, chunkSize)
            6 -> case6(size, chunkSize)
            7 -> case7(size, chunkSize)
            8 -> case8(size, chunkSize)
        }
    }
    graph.forEach { println(it.joinToString(" ")) }
}

private fun case1(n: Int, chunkSize: Int) {
    for (i in 0 until n / chunkSize) {
        for (j in 0 until n / chunkSize) {
            flipUpsideDown(i * chunkSize, j * chunkSize, chunkSize)
        }
    }
}

private fun flipUpsideDown(x: Int, y: Int, chunkSize: Int) {
    for (i in 0 until chunkSize / 2) {
        for (j in 0 until chunkSize) {
            val temp = graph[x + i][y + j]
            graph[x + i][y + j] = graph[x + chunkSize - 1 - i][y + j]
            graph[x + chunkSize - 1 - i][y + j] = temp
        }
    }
}

private fun case2(n: Int, chunkSize: Int) {
    for (i in 0 until n / chunkSize) {
        for (j in 0 until n / chunkSize) {
            flipLeftRight(i * chunkSize, j * chunkSize, chunkSize)
        }
    }
}

private fun flipLeftRight(x: Int, y: Int, chunkSize: Int) {
    for (i in 0 until chunkSize) {
        for (j in 0 until chunkSize / 2) {
            val temp = graph[x + i][y + j]
            graph[x + i][y + j] = graph[x + i][y + chunkSize - 1 - j]
            graph[x + i][y + chunkSize - 1 - j] = temp
        }
    }
}

private fun case3(n: Int, chunkSize: Int) {
    for (i in 0 until n / chunkSize) {
        for (j in 0 until n / chunkSize) {
            rotateClockWise(i * chunkSize, j * chunkSize, chunkSize)
        }
    }
}

private fun rotateClockWise(x: Int, y: Int, chunkSize: Int) {
    repeat(chunkSize / 2) { k ->
        val temp = mutableListOf<Int>()
        for (j in k + 1..(chunkSize - 1) - k) {
            temp.add(graph[x + k][y + j])
        }

        for (j in (chunkSize - 1) - k downTo k + 1) {
            graph[x + k][y + j] = graph[x + (chunkSize - 1) - j][y + k]
        }

        for (i in k until (chunkSize - 1) - k) {
            graph[x + i][y + k] = graph[x + (chunkSize - 1) - k][y + i]
        }

        for (j in k until (chunkSize - 1) - k) {
            graph[x + (chunkSize - 1) - k][y + j] = graph[x + (chunkSize - 1) - j][y + (chunkSize - 1) - k]
        }

        for ((i, n) in temp.withIndex()) {
            graph[x + i + 1 + k][y + (chunkSize - 1) - k] = n
        }
    }
}

private fun case4(n: Int, chunkSize: Int) {
    for (i in 0 until n / chunkSize) {
        for (j in 0 until n / chunkSize) {
            rotateCounterClockWise(i * chunkSize, j * chunkSize, chunkSize)
        }
    }
}

private fun rotateCounterClockWise(x: Int, y: Int, chunkSize: Int) {
    repeat(chunkSize / 2) { k ->
        val temp = mutableListOf<Int>()
        for (j in k until (chunkSize - 1) - k) {
            temp.add(graph[x + k][y + j])
        }

        for (j in k until (chunkSize - 1) - k) {
            graph[x + k][y + j] = graph[x + j][y + (chunkSize - 1) - k]
        }

        for (i in k until (chunkSize - 1) - k) {
            graph[x + i][y + (chunkSize - 1) - k] = graph[x + (chunkSize - 1) - k][y + (chunkSize - 1) - i]
        }


        for (j in (chunkSize - 1) - k downTo k + 1) {
            graph[x + (chunkSize - 1) - k][y + j] = graph[x + j][y + k]
        }

        for ((i, n) in temp.withIndex()) {
            graph[x - k + (chunkSize - 1) - i][y + k] = n
        }
    }
}

private fun case5(n: Int, chunkSize: Int) {
    val center = n / (chunkSize * 2)
    for (j in 0 until n / chunkSize) {
        repeat(center) { k ->
            swapBlock((center - 1) - k, j, center + k, j, chunkSize)
        }
    }
}

private fun case6(n: Int, chunkSize: Int) {
    val center = n / (chunkSize * 2)
    for (i in 0 until n / chunkSize) {
        repeat(center) { k ->
            swapBlock(i, (center - 1) - k, i, center + k, chunkSize)
        }
    }
}

private fun swapBlock(x1: Int, y1: Int, x2: Int, y2: Int, chunkSize: Int) {
    for (i in 0 until chunkSize) {
        for (j in 0 until chunkSize) {
            val temp = graph[x1 * chunkSize + i][y1 * chunkSize + j]
            graph[x1 * chunkSize + i][y1 * chunkSize + j] = graph[x2 * chunkSize + i][y2 * chunkSize + j]
            graph[x2 * chunkSize + i][y2 * chunkSize + j] = temp
        }
    }
}

private fun case7(n: Int, chunkSize: Int) =
    rotateBlockClockWise(n, chunkSize)

private fun rotateBlockClockWise(n: Int, chunkSize: Int) {
    repeat(n / chunkSize / 2) { k ->
        val blocks = getBlocks1(n, chunkSize, k)

        for (l in n / chunkSize - 1 - k downTo k + 1) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[k * chunkSize + i][l * chunkSize + j] =
                        graph[(n / chunkSize - 1 - l) * chunkSize + i][k * chunkSize + j]
                }
            }
        }

        for (l in k until (n / chunkSize - 1) - k) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[l * chunkSize + i][k * chunkSize + j] =
                        graph[(n / chunkSize - 1 - k) * chunkSize + i][l * chunkSize + j]
                }
            }
        }

        for (l in k until (n / chunkSize - 1) - k) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[(n / chunkSize - 1 - k) * chunkSize + i][l * chunkSize + j] =
                        graph[(n / chunkSize - 1 - l) * chunkSize + i][(n / chunkSize - 1 - k) * chunkSize + j]
                }
            }
        }

        for ((l, block) in blocks.withIndex()) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[(n / chunkSize - 1 - k - l) * chunkSize + i][(n / chunkSize - 1 - k) * chunkSize + j] =
                        block[i][j]
                }
            }
        }
    }
}

private fun getBlocks1(n: Int, chunkSize: Int, k: Int): List<Array<IntArray>> {
    val blocks = mutableListOf<Array<IntArray>>()
    for (l in n / chunkSize - 1 - k downTo k + 1) {
        val block = Array(chunkSize) { IntArray(chunkSize) }
        for (i in 0 until chunkSize) {
            for (j in 0 until chunkSize) {
                block[i][j] = graph[k * chunkSize + i][l * chunkSize + j]
            }
        }
        blocks.add(block)
    }
    return blocks
}

private fun case8(n: Int, chunkSize: Int) =
    rotateBlockCounterClockWise(n, chunkSize)

private fun rotateBlockCounterClockWise(n: Int, chunkSize: Int) {
    repeat(n / chunkSize / 2) { k ->
        val blocks = getBlocks2(n, chunkSize, k)

        for (l in k until (n / chunkSize - 1) - k) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[k * chunkSize + i][l * chunkSize + j] =
                        graph[l * chunkSize + i][(n / chunkSize - 1 - k) * chunkSize + j]
                }
            }
        }

        for (l in k until (n / chunkSize - 1) - k) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[l * chunkSize + i][(n / chunkSize - 1 - k) * chunkSize + j] =
                        graph[(n / chunkSize - 1 - k) * chunkSize + i][(n / chunkSize - 1 - l) * chunkSize + j]
                }
            }
        }

        for (l in n / chunkSize - 1 - k downTo k + 1) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[(n / chunkSize - 1 - k) * chunkSize + i][l * chunkSize + j] =
                        graph[l * chunkSize + i][k * chunkSize + j]
                }
            }
        }

        for ((l, block) in blocks.withIndex()) {
            for (i in 0 until chunkSize) {
                for (j in 0 until chunkSize) {
                    graph[(n / chunkSize - 1 - k - l) * chunkSize + i][k * chunkSize + j] = block[i][j]
                }
            }
        }
    }
}

private fun getBlocks2(n: Int, chunkSize: Int, k: Int): List<Array<IntArray>> {
    val blocks = mutableListOf<Array<IntArray>>()
    for (l in k until n / chunkSize - 1 - k) {
        val block = Array(chunkSize) { IntArray(chunkSize) }
        for (i in 0 until chunkSize) {
            for (j in 0 until chunkSize) {
                block[i][j] = graph[k * chunkSize + i][l * chunkSize + j]
            }
        }
        blocks.add(block)
    }
    return blocks
}
