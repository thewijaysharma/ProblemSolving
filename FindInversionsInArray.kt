package ProblemSolving

var inversions = 0

fun main() {
    val inputArray = arrayOf(2,4,1,3,5)

    partitionArray(inputArray, 0, inputArray.lastIndex)
    print("Inversions : $inversions")
}

private fun partitionArray(arr: Array<Int>, left : Int, right : Int){
    if(left<right){
        val mid = (left + right)/2
        partitionArray(arr, left, mid)
        partitionArray(arr, mid + 1, right)
        mergeArrays(arr, left, mid, right)
    }
}

fun mergeArrays(arr: Array<Int>, left: Int, mid: Int, right: Int) {

    val firstArray = arrayListOf<Int>()
    val secondArray = arrayListOf<Int>()

    for(i in left..mid){
        firstArray.add(arr[i])
    }

    firstArray.add(Int.MAX_VALUE)

    for(i in mid+1..right){
        secondArray.add(arr[i])
    }

    secondArray.add(Int.MAX_VALUE)

    var i = 0
    var j = 0

    for(k in left..right){

        if(firstArray[i] > secondArray[j]){
            inversions += (firstArray.size-1 - i)
            arr[k] = secondArray[j]
            j++
        }else{
            arr[k] = firstArray[i]
            i++
        }

    }

}
