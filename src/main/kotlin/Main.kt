val playerField = mutableListOf('1','2','3','4','5','6','7','8','9')
val choiceX = mutableListOf(' ')
val choiceO = mutableListOf(' ')
var priority = true

fun main() {
    showField()
    while (true) {
        place()
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
        if (playerField[index-1] !in listOf('X','O')) {
            playerField[index - 1]=if(priority) 'X' else 'O'
            showField()
            priority= !priority
        } else {
            println("The cell is already taken!")
        }
    } else {
        println("Enter a number between 1 and 9")
    }
}