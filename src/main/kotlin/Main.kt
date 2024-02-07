enum class Player {
    X, O
}

enum class State {
    WIN_X, WIN_O, TIE, IN_PROGRESS
}

enum class Action {
    MOVE, STOPP, NEU, INFO, HILFE
}

fun main() {
    var playerField = listOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
    var player = Player.X

    print("Enter your name, Player X: ")
    val playerXName = readln()
    print("Enter your name, Player O: ")
    val playerOName = readln()
    showField(playerField)

    while (true) {
        val result = place(playerField, player, if (player == Player.X) playerXName else playerOName)
        playerField = result.first
        val action = result.second

        if (action == Action.MOVE) {
            val state = check(playerField, player)

            if (state == State.WIN_X) {
                println("$playerXName won!")
                break
            } else if (state == State.WIN_O) {
                println("$playerOName won!")
                break
            } else if (state == State.TIE) {
                println("Tie!")
                break
            }
            player = if (player == Player.X) Player.O else Player.X
        } else if (action == Action.STOPP) {
            break
        } else if (action == Action.NEU) {
          val newPlayerField = playerField.mapIndexed{index,element->(index+49).toChar()}
            showField(newPlayerField)
            playerField=newPlayerField
        } else if (action == Action.INFO) {

        } else if (action == Action.HILFE) {
            println("STOPP: das Spiel beenden\nNEU: das Spiel neustarten\nINFO: die Namen und die Anzahl gesetzter Felder der Spieler und der Spielfeld anzeigen")
        }
    }
}

fun showField(playerField: List<Char>) {
    println("+---+---+---+")
    println("| " + playerField[0] + " | " + playerField[1] + " | " + playerField[2] + " |")
    println("+---+---+---+")
    println("| " + playerField[3] + " | " + playerField[4] + " | " + playerField[5] + " |")
    println("+---+---+---+")
    println("| " + playerField[6] + " | " + playerField[7] + " | " + playerField[8] + " |")
    println("+---+---+---+")
}

fun place(playerField: List<Char>, player: Player, playerName: String): Pair<List<Char>, Action?> {
    print("$playerName\'s turn: ")
    val command = readln().trim().uppercase()
    when (command) {
        Action.STOPP.toString() -> return Pair(playerField, Action.STOPP)
        Action.NEU.toString() -> return Pair(playerField, Action.NEU)
        Action.INFO.toString() -> return Pair(playerField, Action.INFO)
        Action.HILFE.toString() -> return Pair(playerField, Action.HILFE)
    }
    val cell = command.toIntOrNull()
    if (cell != null && cell in 1..9) {
        if (playerField[cell - 1] !in listOf('X', 'O')) {
            val newPlayerField = playerField.toMutableList()
            newPlayerField[cell - 1] = if (player == Player.X) 'X' else 'O'
            showField(newPlayerField)
            return Pair(newPlayerField, Action.MOVE)
        } else {
            println("The cell is already taken!")
            return Pair(playerField, Action.MOVE)
        }
    } else {
        println("Enter a number between 1 and 9")
        return Pair(playerField, null)
    }
}

fun check(playerField: List<Char>, player: Player): State {
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
        return if (player == Player.X) State.WIN_X else State.WIN_O
    } else if (playerField.all { it == 'X' || it == 'O' }) {
        return State.TIE
    } else {
        return State.IN_PROGRESS
    }
}