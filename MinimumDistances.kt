package ProblemSolving

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the minimumDistances function below.
fun minimumDistances(a: Array<Int>): Int {

    var minDistance = Integer.MAX_VALUE

    for(i in 0 until a.size){
        for(j in i+1 until a.size){
            if(a[i]==a[j]){
                if(j-i < minDistance){
                    minDistance = j-i
                }
                break
            }
        }
    }

    return if(minDistance!=Integer.MAX_VALUE){
        minDistance
    }else{
        -1
    }

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = minimumDistances(a)

    println(result)
}
