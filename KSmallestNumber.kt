package ProblemSolving

import kotlin.random.Random

fun main() {

    var arr = arrayOf(2, 5, 1, 7, -8, 21, 0)
    var k = 5
    var ans = getKthSmallest(arr, 0, arr.lastIndex, k)
    print("ans is $ans")
}

fun getKthSmallest(arr: Array<Int>, left: Int, right: Int, k: Int): Int {

    return if (left < right) {

        val sortedPivot = randomizedPartition(arr, left, right)

        if (sortedPivot == k - 1) {
            return arr[sortedPivot]
        } else if (sortedPivot > k - 1) {
            getKthSmallest(arr, left, sortedPivot - 1, k)
        } else {
            getKthSmallest(arr, sortedPivot + 1, right, k)
        }
    } else {
        //when left and right are equal
        return arr[left]
    }

}


fun randomizedPartition(arr: Array<Int>, left: Int, right: Int): Int {

    var randomIndex = Random.nextInt(left, right + 1) //right+1 because the parameter is exclusive
    arr[right] = arr[randomIndex].also { arr[randomIndex] = arr[right] } //swapped arr[right] with arr[randomIndex]

    var i = left - 1

    for (j in left until right) {
        if (arr[j] <= arr[right]) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }

    i += 1
    arr[i] = arr[right].also { arr[right] = arr[i] }
    return i
}



