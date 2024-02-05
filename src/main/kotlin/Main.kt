val playerField = mutableListOf('1','2','3','4','5','6','7','8','9')
val choiceX = mutableListOf(' ')
val choiceO = mutableListOf(' ')
var priority = true

fun main() {
    while (true) {
        place()
        priority = !priority
    }
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

fun place() {
    val index = readln().toIntOrNull()
    if (index != null && index in 1..9) {
        if (priority) {
            playerField[index - 1] = 'X'
        } else {
            playerField[index - 1] = 'O'
        }
        showField()
    } else {
        println("Enter a number between 1 and 9")
    }
}