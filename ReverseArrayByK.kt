package ProblemSolving

fun main() {

    val k = 3
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    arr.forEach { print("$it \t") }
    print("\n")

    reverseArray(arr, 0, arr.size-1)
    reverseArray(arr, 0, k - 1)
    reverseArray(arr, k, arr.size - 1)

    arr.forEach { print("$it \t") }

}

fun reverseArray(arr: Array<Int>, l: Int, r: Int) {

    var left = l
    var right = r

    while (left < right) {

        //swapping numbers
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp

        left++
        right--

    }

}
