var playerField= mutableListOf('1','2','3','4','5','6','7','8','9')
fun main() {
    showField()
}
fun showField(){
    println("+---+---+---+")
    println("| " + playerField[0]+ " | " +playerField[1]+" | "+playerField[2]+" |")
    println("+---+---+---+")
    println("| " + playerField[3]+ " | " +playerField[4]+" | "+playerField[5]+" |")
    println("+---+---+---+")
    println("| " + playerField[6]+ " | " +playerField[7]+" | "+playerField[8]+" |")
    println("+---+---+---+")
}