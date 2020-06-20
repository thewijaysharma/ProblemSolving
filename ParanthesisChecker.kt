package ProblemSolving

import java.util.*

fun main() {

    val inputString = "{{[()]}()}"

    print(isValidString(inputString))

}


fun isValidString( str : String) : Boolean{

    val openingCurly = '{'
    val openingSquare = '['
    val openingBrackets = '('


    val closingCurly = '}'
    val closingSquare = ']'
    val closingBrackets = ')'

    val stack = Stack<Char>()

    for(char in str){

        when(char){
            openingCurly,openingBrackets,openingSquare -> stack.push(char)

            closingCurly -> {

                if(stack.size == 0 || stack.pop() != openingCurly){
                    return false
                }
            }
            closingBrackets -> {
                if(stack.size == 0 || stack.pop() !=  openingBrackets){
                    return false
                }
            }
            closingSquare -> {
                if(stack.size == 0 || stack.pop() !=  openingSquare){
                    return false
                }
            }

        }

    }

    return true



}