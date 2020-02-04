fun main(args: Array<String>) {

    val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2020
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulation("Star", ::printConstructionCost, greetingFunction)

    runSimulation("Crystal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2020
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    runSimulationV2()
}

inline fun runSimulation(playerName: String,
                         costPrinter: (Int) -> Unit,
                         greetingFunction: (String, Int) -> String) {

    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

fun runSimulationV2() {

    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Ice"))
    println(greetingFunction("Ice"))
    println(greetingFunction("Ice"))
}

fun printConstructionCost(numBuildings: Int) {

    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

fun configureGreetingFunction(): (String) -> String {

    val structureType = "hospitals"
    var numBuildings = 5

    return { playerName ->
        val currentYear = 2020
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

}