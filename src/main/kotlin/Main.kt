val playerField = mutableListOf('1','2','3','4','5','6','7','8','9')
val choiceX = mutableListOf(' ',' ',' ',' ',' ')
val choiceO = mutableListOf(' ',' ',' ',' ',' ')

fun main() {
    showField()
    placeX()
}
fun showField() {
    println("+---+---+---+")
    println("| " + playerField[0] + " | " + playerField[1] + " | " + playerField[2] + " |")
    println("+---+---+---+")
    println("| " + playerField[3] + " | " + playerField[4] + " | " + playerField[5] + " |")
    println("+---+---+---+")
    println("| " + playerField[6] + " | " + playerField[7] + " | " + playerField[8] + " |")
    println("+---+---+---+")
}

fun placeX() {
    val index = readln().toIntOrNull()
    if (index != null) {
        playerField[index - 1] = 'X'
        showField()
        placeO()
    } else {
        println("Enter a number between 1 and 9")
        placeX()
    }
}

fun placeO() {
    val index = readln().toIntOrNull()
    if (index != null) {
        playerField[index - 1] = 'O'
        showField()
        placeX()
    } else {
        println("Enter a number between 1 and 9")
        placeO()
    }
}