package ProblemSolving

import kotlin.math.min

fun main() {
    val arr =  arrayOf(8,2,0,4,9,1,7)
    val x : Int = getMaxWaterTrapped(arr)
    print("max trapped water $x")

}

fun getMaxWaterTrapped(arr: Array<Int>): Int {

    if(arr.size < 3){
        return 0
    }

    val leftMax = IntArray(arr.size)
    val rightMax = IntArray(arr.size)

    var currentLeft = arr[0]
    var currentRight  =arr[arr.size-1]

    for (i in 0 until arr.size){
        if(arr[i] > currentLeft){
            currentLeft = arr[i]
        }
        leftMax[i] = currentLeft
    }

    for (i in arr.size-1 downTo  0){
        if(arr[i] > currentRight){
            currentRight = arr[i]
        }
        rightMax[i] = currentRight
    }


    var sum = 0
    for(i in 0 until arr.size){
        sum += (min(leftMax[i], rightMax[i]) - arr[i])
    }

    return sum



}

