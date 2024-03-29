var mensagem = "Bem vindo ao bytebank"
var titular = "Bruna"
var conta = 12345
var saldo = -4.0
var i = 0
fun bytebank(){
    println("$mensagem, Olá $titular, número da conta: $conta, saldo da conta: R$$saldo,00")
}

fun testaCondicoes(saldo: Double){
    if( saldo > 0.0){
        println(" USANDO IF ->> Conta positiva")
    }else if(saldo == 0.0){
        println("USANDO IF ->> Conta neutra")
    }else{
        println("USANDO IF ->> Conta negativa")
    }

    //Lembre-se que o plugin do Kotlin para o IntelliJ verifica as possíveis conversões. Para isso, utilize o atalho Alt + Enter quando aparecer o código sublinhado.
    when {
        saldo > 0.0 -> {
            println("USANDO WHEN ->> Conta positiva")
        }
        saldo == 0.0 -> {
            println("USANDO WHEN ->> Conta neutra")
        }
        else -> {
            println("USANDO WHEN ->> Conta negativa")
        }
    }

    //Lembra um switch case
    when {
        saldo > 0.0 -> println("USANDO WHEN EXPRESSION->> Conta positiva")
        saldo == 0.0 -> println("USANDO WHEN EXPRESSION ->> Conta neutra")
        else -> println("USANDO WHEN EXPRESSION ->> Conta negativa")
    }
}

fun loop(){
    for (i in 1..3) {
        var mensagem = "Bem vindo ao bytebank"
        var titular = "Bruna"
        var conta = 12345 + i
        var saldo = -4.0 + i
        println("$mensagem, Olá $titular, número da conta: $conta, saldo da conta: R$$saldo,00")
    }
}

fun down(){
    for (i in 5 downTo 1) {
        if (i == 4){
            break //continue
        }
        var mensagem = "Bem vindo ao bytebank"
        var titular = "Bruna"
        var conta = 1 + i
        var saldo = -4.0 + i
        println("USANDO O DOWNTO: $mensagem, Olá $titular, número da conta: $conta, saldo da conta: R$$saldo,00")
    }
}


fun usandoWhile(){
    var mensagem = "Bem vindo ao bytebank"
    var titular = "Bruna"
    var conta = 12345 + i
    var saldo = 4.0 + i
    while (i < 5) {
        println("USANDO O WHILE: $mensagem, Olá $titular, número da conta: $conta, saldo da conta: R$$saldo,00")
        i++;
    }
}


fun pula(){
    for (i in 3 downTo 1 step 2) {
        var mensagem = "Bem vindo ao bytebank"
        var titular = "Bruna"
        var conta = 12345 + i
        var saldo = -4.0 + i
        println("USANDO O Step: $mensagem, Olá $titular, número da conta: $conta, saldo da conta: R$$saldo,00")
    }
}

fun main() {
    bytebank()
    testaCondicoes(saldo)
    loop()
    down()
    pula()
    usandoWhile()
}