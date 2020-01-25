package ProblemSolving

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the equalizeArray function below.
fun equalizeArray(arr: Array<Int>): Int {

    val mMap  = HashMap<Int, Int>()

    //insert all the elements into the hashmap with their corresponding freq

    for(element in arr){
        if(element in mMap){
            mMap[element] = mMap[element]!! + 1
        }else{
            mMap[element] = 1
        }
    }

    var maxCount = 0

    for(kvPair in mMap){
        if(kvPair.value > maxCount){
            maxCount = kvPair.value
        }
    }

    return arr.size - maxCount
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = equalizeArray(arr)

    println(result)
}
