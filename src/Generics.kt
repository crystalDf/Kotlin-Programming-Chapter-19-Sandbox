class LootBox<T : Loot>(vararg items: T) {

    var open = false
    private var loot: Array<out T> = items

    operator fun get(index: Int): T? = loot[index].takeIf { open }

    fun fetch(index: Int): T? {
        return loot[index].takeIf { open }
    }

    fun <R> fetch(index: Int, lootModFunction: (T) -> R): R? {

        return lootModFunction(loot[index]).takeIf { open }
    }


}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)

fun main() {

    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15),
        Fedora("a dazzling magenta fedora", 25))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run {

        println("You retrieve $name from the box!")
    }

    val coin = lootBoxOne.fetch(0) {

        Coin(it.value * 3)
    }

    coin?.let { println(it.value) }

    val fedora = lootBoxOne[1]

    fedora?.let { println(it.name) }

    randomOrBackupLoot {
        Fedora("a backup fedora", 15)
    }.run {
        println(name)
    }
}

inline fun <reified T> randomOrBackupLoot(backupLoot: () -> T): T {

    val items = listOf(Coin(14), Fedora("a fedora of the ages", 150))
    val randomLoot: Loot = items.shuffled().first()

    return if (randomLoot is T) {
        randomLoot
    } else {
        backupLoot()
    }
}