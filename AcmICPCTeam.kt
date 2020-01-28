package ProblemSolving

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the acmTeam function below.
fun acmTeam(m : Int, topic: Array<String>): Array<Int> {

    var noOfTeamsThatCanBeFormed = 0
    var maxSubjectsTeamKnow = 0

    for(i in 0..topic.lastIndex){
        for(j in i+1..topic.lastIndex){

            val firstString = topic[i]
            val secondString = topic[j]

            var knowingSubjects = 0

            for(k in 0 until m){

                val x = firstString[k].toString().toInt()
                val y = secondString[k].toString().toInt()

                if(x+y!=0){
                    knowingSubjects++
                }

            }

            if(knowingSubjects > maxSubjectsTeamKnow){
                maxSubjectsTeamKnow = knowingSubjects
            }

        }
    }

    for(i in 0..topic.lastIndex){
        for(j in i+1..topic.lastIndex){

            val firstString = topic[i]
            val secondString = topic[j]

            var knowingSubjects = 0

            for(k in 0 until m){

                val x = firstString[k].toString().toInt()
                val y = secondString[k].toString().toInt()

                if(x+y!=0){
                    knowingSubjects++
                }

            }

            if(knowingSubjects == maxSubjectsTeamKnow){
                noOfTeamsThatCanBeFormed++
            }

        }
    }

    return arrayOf(maxSubjectsTeamKnow, noOfTeamsThatCanBeFormed)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val topic = Array<String>(n, { "" })
    for (i in 0 until n) {
        val topicItem = scan.nextLine()
        topic[i] = topicItem
    }

    val result = acmTeam(m,topic)

    println(result.joinToString("\n"))
}
