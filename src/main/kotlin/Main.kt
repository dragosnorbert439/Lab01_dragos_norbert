import java.util.*
import kotlin.reflect.KFunction1

fun main(args: Array<String>)
{
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 1
    val x1 = 439
    val x2 = 256
    println("$x1 + $x2 = ${x1 + x2}")
    println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 2
    var daysOfTheWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    for (day in daysOfTheWeek) print("$day ")
    println()
    daysOfTheWeek.filter { it.first() == 'T' }.forEach { print("$it ") }
    println()
    daysOfTheWeek.filter { it.contains('e') }.forEach { print("$it ")}
    println()
    daysOfTheWeek.filter { it.length == 6 }.forEach { print("$it ")}
    println(); println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 3
    for (i in 0 .. 100)
    {
        if (isPrime(i)) print("$i ")
    }
    println(); println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 4
    var msg = "Alma a fa alatt"
    println("Original: $msg")
    msg = myEncode(msg)
    println("Encoded: $msg")
    msg = myDecode(msg)
    println("Decoded: $msg")

    println("Encoded again: ${messageCoding(msg, ::myEncode)}")
    println("Decoded again: ${messageCoding(msg, ::myDecode)}")
    println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 5
    val intList = mutableListOf( 1, 2, 3, 4, 5, 439, 48, 42, 256, 17 )
    println("Only even elements list: ${myFilter(intList).toString()}")
    println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 6
    println("Before: ${intList.toString()}")
    var intListDoubled = mutableListOf<Int>()
    intList.map { intListDoubled.add(it).and(intListDoubled.add(it)) }
    println("After: ${intListDoubled.toString()}")
    println()

    println("All uppercase: ${daysOfTheWeek.map { it.uppercase() }}")
    println()

    println("First characters: ${daysOfTheWeek.map { it.first().lowercase() }}")
    println()

    println("Lengths: ${daysOfTheWeek.map { it.length }}")
    println()

    println("Avg chars: ${daysOfTheWeek.map { it.length }.sum().toFloat() / daysOfTheWeek.map { it }.count()}")
    println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 7
    daysOfTheWeek = daysOfTheWeek.toMutableList()
    daysOfTheWeek = daysOfTheWeek.filter { !it.contains('n') }

    daysOfTheWeek.withIndex().map { println("Item at ${it.index} is ${it.value}") }
    println()

    println("Sorted: ${daysOfTheWeek.sorted()}")
    println()

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // 8
    var iArray = IntArray(10) { (0..100).random() }
    print("IntArray: "); iArray.forEach { print("${ it.toString() } ")}; println()

    println("Sorted IntArray: ${iArray.sorted().toString()}")

    var hasEven = false
    iArray.forEach { if(it % 2 == 0) { hasEven = true } }
    println("Contains any even number? => ${if (hasEven) "Yes" else "No" }")

    var hasOdd = false
    iArray.forEach { if(it % 2 != 0) { hasOdd = true } }
    println("Contains only even number(s)? => ${if (hasOdd) "No" else "Yes" }")

    var sum = 0; iArray.forEach { sum += it }
    println("Average generated number: ${ sum.toFloat() / iArray.size }")
}

// for 3rd
fun isPrime(num :Int) : Boolean
{
    var prime : Boolean = true

    if (num <= 1) prime = false
    else
    {
        for (i in 2 ..  num / 2)
        {
            if (num % i == 0)
            {
                prime = false
                break
            }
        }
    }

    return prime
}

// for 4th
fun myEncode(str :String) : String = Base64.getEncoder().encodeToString(str.toByteArray())

fun myDecode(str :String) : String = String(Base64.getDecoder().decode(str.toByteArray()))

fun messageCoding(msg: String, func: KFunction1<String, String>): String = func(msg)

// for 5th
fun myFilter(list : List<Int>) : List<Int> = list.filter { it.and(1) == 0 }