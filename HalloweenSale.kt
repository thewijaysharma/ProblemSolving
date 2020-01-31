package ProblemSolving

import java.util.*
import kotlin.io.*
import kotlin.text.*

// Complete the howManyGames function below.
fun howManyGames(p: Int, d: Int, m: Int,  s: Int): Int {

    var i = 0

    var currentBalance = s

    while(true){

        var priceOfVideoGame =p - i*d

        if(priceOfVideoGame < m){
            priceOfVideoGame = m
        }

        if(priceOfVideoGame > currentBalance){
            break
        }else{
            i++
            currentBalance -= priceOfVideoGame
        }

    }

    return i


}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val pdms = scan.nextLine().split(" ")

    val p = pdms[0].trim().toInt()

    val d = pdms[1].trim().toInt()

    val m = pdms[2].trim().toInt()

    val s = pdms[3].trim().toInt()

    val answer = howManyGames(p, d, m, s)

    println(answer)
}
