import kotlin.system.measureNanoTime

fun main() {

    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal" }
        .map { baby -> "$baby, with the cutest little tail ever!"}

    println(babies)

    val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
    val tenDollarWordLengths = tenDollarWords.map { it.length }

    println(tenDollarWordLengths)

    println(listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatten())

    val itemsOfManyColors = listOf(listOf("red apple", "green apple", "blue apple"),
        listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana"))

    val redItems = itemsOfManyColors.flatMap { it -> it.filter { it.contains("red") } }

    println(redItems)

    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number -> (2 until number).map { number % it }.none { it == 0} }

    println(primes)

    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    val formattedSwagOrders = employees.zip(shirtSize).toMap().map { "${it.key}, shirt size: ${it.value}"}

    println(employeeShirtSizes["Denny"])
    println(formattedSwagOrders)

    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulated value: $accumulator, Number value: $number")
        accumulator + (number * 3)}

    println("Final value: $foldedValue")

    val toList = (2..7919).toList().filter { it.isPrime() }.take(1000)
    val oneThousandPrimes = generateSequence(2) { value -> value + 1 }.filter { it.isPrime() }.take(1000)

    println(toList.last())
    println(oneThousandPrimes.last())

    val listInNanos = measureNanoTime {
        (2..7919).toList().filter { it.isPrime() }.take(1000)
    }

    val sequenceInNanos = measureNanoTime {
        generateSequence(3) { value -> value + 1 }.filter { it.isPrime() }.take(1000)
    }

    println("List completed in $listInNanos ns")
    println("Sequence completed in $sequenceInNanos ns")

    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)

    println(flipValues(gradesByStudent))

    val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)

    println("Step 1: ${valuesToAdd.joinToString(", ")}")

    println(valuesToAdd.filter { it >= 5 })

    println("Step 2: ${valuesToAdd.filter { it >= 5 }.joinToString(", ")}")

    println(valuesToAdd.filter { it >= 5 }.windowed(2, 2))

    println("Step 3: ${valuesToAdd.filter { it >= 5 }.windowed(2, 2) 
    { "[" + it.joinToString("*") + "]"}.joinToString(", ")}")

    println(valuesToAdd.filter { it >= 5 }.windowed(2, 2) { it.first() * it.last() })

    print("Step 4: ${valuesToAdd.filter { it >= 5 }.windowed(2, 2) 
    { it.first() * it.last() }.joinToString(" + ")} = ")
    println(valuesToAdd.filter { it >= 5 }.windowed(2, 2) { it.first() * it.last() }.sum())

}

fun Int.isPrime(): Boolean {

    (2 until this).map {
        if (this % it == 0) {
            return false
        }
    }

    return true
}

fun flipValues(map: Map<String, Double>): Map<Double, String> {

    return map.map { it.value }.zip(map.map { it.key }).toMap()
}
