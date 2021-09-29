import java.beans.Encoder
import java.lang.StringBuilder

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
    val daysOfTheWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

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
    println()
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
fun myEncode(str :String) : String
{
    return str
}

fun myDecode(str :String) : String
{
    return str
}
