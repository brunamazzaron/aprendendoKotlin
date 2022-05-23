
//As classes são as responsáveis por modificar seus atributos.
//A boa prática de orientação a objetos é que qualquer comportamento
// que ajuste o estado da classe (modifique os atributos), deve ser implementado pela própria classe.
class Conta{
    var titular = ""
    var numeroConta = 0
    var saldo = 0.0
        private set
    //sempre acessa por meio de um set ou um get
        //field receve o valor inicial
    //chamado de proprites
    // serve para alterar o valor

    //funçao membro de uma classe, métodos ou comportamentos da classe
    fun deposita(valor: Double){
        if(valor > 0) {
            this.saldo += valor
        }
    }
//Properties apresentam o mesmo comportamento de
// métodos de acesso e é mais idiomático ao Kotlin.

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

}

fun admConta(){
    //Ao trabalhar com Orientação a Objetos, precisamos ficar atentos ao usar uma variável por conta da atribuição por cópia ou referência.
    // Ao alterar uma variável de um objeto, todas as variáveis que apontam para o objeto enxergam o mesmo valor.
    //Utilizar uma referência, qualquer modificação que é feita no objeto é único para todas as variáveis que apontam para a referência.
    val contaJoao = Conta()
    contaJoao.titular = "-----João-----"
    contaJoao.numeroConta = 123
    contaJoao.deposita(600.00)
    println("Conta Joao:${ contaJoao.titular }, ${contaJoao.numeroConta}, ${contaJoao.saldo}")

    val contaMaria = Conta()
    contaMaria.titular = "-----Maria-----"
    contaMaria.numeroConta = 122
    contaMaria.deposita(900.00)
    println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, ${contaMaria.saldo}")

    val contaAlex = Conta()
    contaAlex.titular = "----Alex-----"
    contaAlex.numeroConta = 111
    contaAlex.deposita(4000.00)
    println("Conta Alex:${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.saldo}")

    val contaFran = Conta()
    contaFran.titular = "----Fran----"
    contaFran.numeroConta = 133
    contaFran.deposita(5000.00)
    println("Conta Fran:${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.saldo}")

    println("-----Deposito-----")
    contaMaria.deposita( 50.00)
    println("Deposito: -----Maria----- ${contaMaria.saldo}")

    contaJoao.deposita(100.00)
    println("Deposito: -----Joao----- ${contaJoao.saldo}")
//    contaMaria.saldo += 100.00
//    contaJoao.saldo += 50.00

    contaFran.deposita( 150.00)
    println("Deposito: -----Fran-----${contaFran.saldo}")

    contaAlex.deposita(150.00)
    println("Deposito: -----Alex----- ${contaAlex.saldo}")

    println("----Saque----")
    contaJoao.saca(20.00)
    contaMaria.saca(20.00)

    contaAlex.saca(1000.00)
    contaFran.saca(1000.00)

    println("Saca: ----Alex-----${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.saldo}")
    println("Saca: ----Fran-----${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.saldo}")

    println("-----Transferencia-----")
    if(contaAlex.transferir(200.00, contaFran)){
        println("Sucesso")
        println("transferencia: ----Alex----${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.saldo}")
        println("transferencia: ----Fran-----${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.saldo}")
    }else if(contaMaria.transferir(200.00, contaJoao)) {
        println("Conta Joao:${contaJoao.titular}, ${ contaJoao.numeroConta }, Transferência: ${contaJoao.saldo}")
        println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, Transferência: ${contaMaria.saldo}")
    }else if(contaJoao.transferir(900.00, contaMaria)){
        println("sucesso!")
        println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, Transferência: ${contaMaria.saldo}")
        println("Conta Joao:${contaJoao.titular}, ${ contaJoao.numeroConta }, Transferência: ${contaJoao.saldo}")
    }else{
        return println("Falha!")
    }

    println("saque conta EM EXCESSO Joao")
    contaJoao.saca(0.10)
    println(contaJoao.saldo)

    println("saque conta EM EXCESSO Maria")
    contaMaria.saca(0.10)
    println(contaMaria.saldo)
}

fun main() {
    admConta()
}