val playerField = mutableListOf('1', '2', '3', '4', '5', '6', '7', '8', '9')

enum class Player {
    X, O
}

enum class Finish {
    WIN_X, WIN_O, TIE, IN_PROGRESS
}



fun main() {
    print("Enter your name, Player X: ")
    val playerX = readln()
    print("Enter your name, Player O: ")
    val playerO = readln()
    var player = Player.X
    showField()

    while (true) {
        val validMove = place(player, if (player == Player.X) playerX else playerO)

        if (validMove == true) {
            val state = check(player)

            if (state == Finish.WIN_X) {
                println("$playerX won!")
                break
            } else if (state == Finish.WIN_O) {
                println("$playerO won!")
                break
            } else if (state == Finish.TIE) {
                println("Tie!")
                break
            }
            player = if (player == Player.X) Player.O else Player.X
        } else if (validMove == null) {
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

fun place(player: Player, playerName: String):Boolean? {
    print("$playerName\'s turn: ")
    val index = readln().toIntOrNull()
    if (index != null && index in 1..9) {
        if (playerField[index - 1] !in listOf('X', 'O')) {
            playerField[index - 1] = if (player == Player.X) 'X' else 'O'
            showField()
            return true
        } else {
            println("The cell is already taken!")
            return false
        }
    } else if (index.toString() == "stopp") {
        return null
    } else if (index.toString() == "neu") {
        return true
    } else {
        println("Enter a number between 1 and 9")
        return false
    }
}

fun check(player: Player): Finish {
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
        return if (player == Player.X) return Finish.WIN_X else return Finish.WIN_O
    }
    else if (playerField.all{it=='X' || it=='O'}) {
        return Finish.TIE
    }
    else {
        return Finish.IN_PROGRESS
    }
}