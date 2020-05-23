package ProblemSolving

fun main() {

    val array  = arrayOf('a','b','c','d')

    permute(0, array.size-1, array)

}

fun permute(left : Int, right : Int, array: Array<Char>){

        for(i in left..right){
            //swap
            array[left] = array[i].also { array[i] = array[left] }

            //print if its the max height of the formed tree
            if(left+1 == right){
                printArray(array)
            }else{
                //otherwise permute more
                permute(left+1, right, array)
            }

            array[left] = array[i].also { array[i] = array[left]}

    }




}

fun printArray(array : Array<Char>){
    for (i in 0 until array.size){
        print(array[i])
    }
    print("\n")
}
