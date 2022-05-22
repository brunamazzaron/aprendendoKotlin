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

//As classes são as responsáveis por modificar seus atributos.
//A boa prática de orientação a objetos é que qualquer comportamento
// que ajuste o estado da classe (modifique os atributos), deve ser implementado pela própria classe.
class Conta{
    var titular = ""
    var numeroConta = 0
    //dessa forma nao deixamos o saldo acessivel
    private var saldo = 0.0

    //funçao membro de uma classe, métodos ou comportamentos da classe
    fun deposita(valor: Double){
        this.saldo += valor
    }

    fun saca(valor: Double){
        if(saldo >= valor){
            saldo -= valor
        }
    }

    // Ao analisar o código da classe Conta, utilizamos getter e setter
    // para acessar o campo do saldo. Percebemos que essa técnica
    // é conhecida como encapsulamento e é bastante comum
    // em Orientação a Objetos
    //Para impedir a manipulação direta do atributo em qualquer ponto do código.
    //Ao encapsular um atributo, apenas a classe é capaz de modificar o valor, como preferir.
    fun transferir(valor: Double, destino: Conta): Boolean{
        if(saldo >= valor){
            saldo -= valor
            destino.saldo += valor
            return true
        }
            return false
        }

    fun getSaldo(): Double{
        return saldo
    }

    fun setSaldo(valor : Double){
         if(saldo > 0){
             saldo = valor
         }
    }
}

fun admConta(){
    val contaAlex = Conta()
    contaAlex.titular = "----Alex-----"
    contaAlex.numeroConta = 123
    contaAlex.setSaldo(4000.00)
    println("Deposito: Conta Alex:${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.getSaldo()}")


    val contaFran = Conta()
    contaFran.titular = "----Fran----"
    contaFran.numeroConta = 1234
    contaFran.setSaldo(5000.00)
    println("Deposito: Conta Fran:${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.getSaldo()}")


    contaFran.deposita( 150.00)
    println("Deposito: Conta Fran:${contaFran.getSaldo()}")

    contaAlex.deposita(150.00)
    println("Deposito: Conta Alex:${contaAlex.getSaldo()}")

    contaAlex.saca(1000.00)
    contaFran.saca(1000.00)

    println("Saque:")
    println("Saca: Conta Alex:${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.getSaldo()}")
    println("Saca: Conta Fran:${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.getSaldo()}")

    println("transferencia:")
    if(contaAlex.transferir(200.00, contaFran)){
        println("Sucesso")
        println("transferencia: Conta Alex:${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.getSaldo()}")
        println("transferencia: Conta Fran:${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.getSaldo()}")
    }else{
        return println("Falha!")
    }
}

fun contas(){
    //Ao trabalhar com Orientação a Objetos, precisamos ficar atentos ao usar uma variável por conta da atribuição por cópia ou referência. Ao alterar uma variável de um objeto, todas as variáveis que apontam para o objeto enxergam o mesmo valor.
    //Utilizar uma referência, qualquer modificação que é feita no objeto é único para todas as variáveis que apontam para a referência.
    val contaJoao = Conta()
    contaJoao.titular = "-----João-----"
    contaJoao.numeroConta = 123
    contaJoao.setSaldo(600.00)

    val contaMaria = Conta()
    contaMaria.titular = "-----Maria-----"
    contaMaria.numeroConta = 122
    contaMaria.setSaldo(900.00)

    println("Conta Joao:${ contaJoao.titular }, ${contaJoao.numeroConta}, ${contaJoao.getSaldo()}")
    println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, ${contaMaria.getSaldo()}")

    contaMaria.deposita( 50.00)
    contaJoao.deposita(100.00)
//    contaMaria.saldo += 100.00
//    contaJoao.saldo += 50.00


    println("Conta Joao:${ contaJoao.titular },Numero da conta ${contaJoao.numeroConta}, Saldo atualizado ${contaJoao.getSaldo()}")
    println("Conta Maria:${contaMaria.titular},Numero da conta ${ contaMaria.numeroConta }, Saldo atualizado ${contaMaria.getSaldo()}")

    println("saque conta Joao")
    contaJoao.saca(20.00)
    println(contaJoao.getSaldo())

    println("saque conta Maria")
    contaMaria.saca(20.00)
    println(contaMaria.getSaldo())

    println("saque conta EM EXCESSO Joao")
    contaJoao.saca(0.10)
    println(contaJoao.getSaldo())

    println("saque conta EM EXCESSO Maria")
    contaMaria.saca(0.10)
    println(contaMaria.getSaldo())

    println("Transferencia 1")
    if(contaMaria.transferir(200.00, contaJoao)){
        println("sucesso!")
    }else{
        println("falha!")
    }


    println("Conta Joao:${contaJoao.titular}, ${ contaJoao.numeroConta }, Transferência: ${contaJoao.getSaldo()}")
    println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, Transferência: ${contaMaria.getSaldo()}")


    println("Transferencia 2")
    if(contaJoao.transferir(900.00, contaMaria)){
        println("sucesso!")
    }else{
        println("falha!")
    }

    println("Conta Joao:${contaJoao.titular}, ${ contaJoao.numeroConta }, Transferência: ${contaJoao.getSaldo()}")
    println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, Transferência: ${contaMaria.getSaldo()}")

}


fun variaveis(){
    val numero = 10
    var numeroX = numero
    numeroX++

    var numeroY = numeroX
    numeroY++

    println("--variaveis primitivas--$numeroX")
    println("--variaveis primitivas--$numeroY")
}

fun main() {
    bytebank()
    testaCondicoes(saldo)
    loop()
    down()
    pula()
    usandoWhile()
    admConta()
    variaveis()
    contas()
}