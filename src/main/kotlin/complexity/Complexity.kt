package complexity

// ------------------------------ Time complexity ----------------------------------

//Big O notation for the different level of scalability in two dimension
//-- Execution time
//-- Memory Usage

//Time complexity - is the time it take for algorithm to run compare with data size.

//Constant Time - is the same running time regardless of an input size.
fun checkFirst(name: List<String>){
    if(name.firstOrNull()!=null){
        println(name.first())
    }else
        println("No name")
}

//Liner time complexity - As the input increase the time to execute also increase
fun printName(names:List<String>){
    for (element in names){
        println(element)
    }
}

//Quadratic Time Complexity - refer to algorithm that takes time proportional to the square input size.
//Big O notation for quadratic time is = O(n^2)
fun multiplicationBoard(n:Int){
    for (number in 1 ..n){
        print("|")
        for (otherNumber in 1..n){
            println("$number * $otherNumber = ${number * otherNumber}|")
        }
    }
}

//Logarithmic Time Complexity -
fun linearContains(value:Int, numbers:List<Int>):Boolean {
    for(element in numbers) {
        return value == element
    }
    return false
}

//This is not efficient lets sort the values of number and divide in half
//As input increase the time takes to execute the algorithm increase at slowly rate.
//Big O notation for logarithm time complexity is Q(log n)
fun pseudoBinaryContains(value: Int, numbers: List<Int>):Boolean {
    if (numbers.isEmpty()) return false
    numbers.sorted()
    val middleIndex = numbers.size/2
    if (value <= numbers[middleIndex]){
        for (element in 0 .. middleIndex){
            return (numbers[element] == value)
        }
    }else{
        for (elements in middleIndex until numbers.size){
            return numbers[elements] == value
        }
    }
    return false
}

//Quasilinear Time Complexity - perform worse than liner time but dramatically better than quadratic time.
//Other complexity time (polynomial , exponential and factorial time).
//NOTE: for small data sets, time complexity may not be an accurate measure of speed.

//Comparing Time complexity.
//suppose you find sums of numbers from 1 to n
fun sumFromOne(n:Int):Int{
    var result = 0
    for (i in 1..n){
        result += i
    }
    return result
}

//This sum can be rewritten also with reduce function
//The time complexity of reduce function it also Q(n)
fun sumFromOnes(n:Int):Int{
    return (1..n).reduce { element, sum -> sum + element }
}

//We can use the famous mathematician Fredric Gauss
//That use the time complexity constant Q(1)
fun sumFrom1(n:Int):Int{
    return n * (n + 1)/2
}

//--------------------------------------- Space complexity ---------------------------------

//space complexity - is measure of the resources for algorithm required to manipulate input data.
//Let's create the copy of sorted list and print it.
//The space complexity is Q(n)

fun printedSorted(number: List<Int>){
    val sorted = number.sorted()
    for (element in sorted){
        println(element)
    }
}

/*
NOTE: key Point

-Big O notation it used to represent the general form of space and time complexity.
-Time and space are high-level measures of scalability,
they don't measure the actual speed of algorithm itself
-For small dataset time complexity is usually irrelevant, a quasilinear algorithm can be slower than liner algo
* */