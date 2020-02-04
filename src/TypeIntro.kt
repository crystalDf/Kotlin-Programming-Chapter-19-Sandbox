const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {

    val playerName: String = "Star"
    var experiencePoints: Int = 5
    var hasSteed: Boolean = false

    val pubName: String = "the Unicorn’s Horn"
    val publicanName: String = "Crystal"
    val gold: Int = 50
    val menu: List<String> = listOf("mead", "wine", "LaCroix")

    val numLetters = "Mississippi".count { letter -> letter == 's' }

    experiencePoints += 5

    println(experiencePoints)
    println(playerName)
    println(playerName.reversed())

    println(numLetters)
}
