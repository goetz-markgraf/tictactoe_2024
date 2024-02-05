val playerField = mutableListOf('1', '2', '3', '4', '5', '6', '7', '8', '9')

enum class Player {
    X, O
}

var scoreX = 0
var scoreO = 0
var shouldPrintScores = false

fun main() {
    var player = Player.X
    showField()

    while (true) {
        place(player)
        check(player)
        player = if (player == Player.X) Player.O else Player.X

        if (shouldPrintScores) {
            println("Score X: $scoreX")
            println("Score O: $scoreO")
            break
        }

        if (playerField.all { it == 'X' || it == 'O' }) {
            println("It's a tie!")
            break
        }
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

fun place(player: Player) {
    print(player.name + " player's turn: ")
    val index = readLine()?.toIntOrNull()

    if (index != null && index in 1..9) {
        if (playerField[index - 1] !in listOf('X', 'O')) {
            playerField[index - 1] = if (player == Player.X) 'X' else 'O'
            showField()
        } else {
            println("The cell is already taken!")
            return
        }
    } else {
        println("Enter a number between 1 and 9")
        return
    }
}

fun check(player: Player) {
    val symbolToCheck = if (player == Player.X) 'X' else 'O'

    if (playerField[0] == symbolToCheck && playerField[1] == symbolToCheck && playerField[2] == symbolToCheck ||
        playerField[3] == symbolToCheck && playerField[4] == symbolToCheck && playerField[5] == symbolToCheck ||
        playerField[6] == symbolToCheck && playerField[7] == symbolToCheck && playerField[8] == symbolToCheck ||
        playerField[0] == symbolToCheck && playerField[3] == symbolToCheck && playerField[6] == symbolToCheck ||
        playerField[1] == symbolToCheck && playerField[4] == symbolToCheck && playerField[7] == symbolToCheck ||
        playerField[2] == symbolToCheck && playerField[5] == symbolToCheck && playerField[8] == symbolToCheck ||
        playerField[0] == symbolToCheck && playerField[4] == symbolToCheck && playerField[8] == symbolToCheck ||
        playerField[2] == symbolToCheck && playerField[4] == symbolToCheck && playerField[6] == symbolToCheck
    ) {
        if (player == Player.X) {
            scoreX++
        } else {
            scoreO++
        }
        shouldPrintScores = true
    }
}
//By Artemis