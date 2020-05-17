package ProblemSolving

fun main() {

    val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25),
            intArrayOf(26, 27, 28, 29, 30)
    )

    var top = 0 //top row
    var left = 0 //first column
    var right = 4 //last column
    var bottom = 5 //bottom row

    var dir = 0

    while (top <= bottom && left <= right) {

        when (dir) {
            0 -> {
                for (i in left..right) {
                    print("${matrix[top][i]} ")
                }
                top++
                dir = 1
            }
            1 -> {
                for (i in top..bottom) {
                    print("${matrix[i][right]} ")
                }
                right--
                dir = 2
            }
            2 -> {
                for (i in right downTo left) {
                    print("${matrix[bottom][i]} ")
                }
                bottom--
                dir = 3
            }
            3 -> {
                for (i in bottom downTo top) {
                    print("${matrix[i][left]} ")
                }
                left++
                dir = 0
            }

        }


    }


}