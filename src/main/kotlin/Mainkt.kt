
//As classes são as responsáveis por modificar seus atributos.
//A boa prática de orientação a objetos é que qualquer comportamento
// que ajuste o estado da classe (modifique os atributos), deve ser implementado pela própria classe.
class Conta(titular: String, numeroConta: Int){
    val titular = titular //Inicializacao de propriets
    val numeroConta = numeroConta
    var saldo = 0.0
        private set // só nossa classe pode modificar
    //se quiser criar uma representaçao de uma pessoa em crio uma pessoa, cria as regras
    //sempre acessa por meio de um set ou um get
    //field receve o valor inicial
    //chamado de proprites
    // serve para alterar o valor

    //RESPONSAVEL POR CRIAR/vida A NOSSA CLASSE
//    constructor(titular: String, numeroConta: Int){
//        this.titular
//        this.numeroConta
//    }

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
    val contaJoao = Conta(titular = "-----João-----",numeroConta = 123) // eu instanciei a classe Conta()
    contaJoao.deposita(600.00)
    println("Conta Joao:${ contaJoao.titular }, ${contaJoao.numeroConta}, ${contaJoao.saldo}")

    val contaMaria = Conta(titular = "-----Maria-----",numeroConta = 122)
    contaMaria.deposita(900.00)
    println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, ${contaMaria.saldo}")

    val contaAlex = Conta(titular = "----Alex-----", numeroConta = 111)
    contaAlex.deposita(4000.00)
    println("Conta Alex:${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.saldo}")

    val contaFran = Conta( titular = "----Fran----", numeroConta = 133)
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
    //contaAlex é um objeto chamando um comportamento saca
    contaFran.saca(1000.00)

    println("Saca: ----Alex-----${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.saldo}")
    println("Saca: ----Fran-----${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.saldo}")

    println("-----Transferencia-----")
    if(contaAlex.transferir(200.00, contaFran)){
        println("transferencia: ----Alex----${ contaAlex.titular }, ${contaAlex.numeroConta}, ${contaAlex.saldo}")
        println("transferencia: ----Fran-----${contaFran.titular}, ${ contaFran.numeroConta }, ${contaFran.saldo}")
    }else if(contaMaria.transferir(200.00, contaJoao)) {
        println("Conta Joao:${contaJoao.titular}, ${ contaJoao.numeroConta }, Transferência: ${contaJoao.saldo}")
        println("Conta Maria:${contaMaria.titular}, ${ contaMaria.numeroConta }, Transferência: ${contaMaria.saldo}")
    }else if(contaJoao.transferir(900.00, contaMaria)){
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

//reforçando:
//Classe representaçao de um item fisico, ideias ou conceitos abstratos do mundo real
// atributos sao as propriedades e os metodos sendo as funcionalidades

//Classes orginam uma instâncias sob requisiçao no processo de instanciaçao

//as instancias sao chamadas de objetos

//

//data class Pessoa( val name: String,  val id: Number,  val cpf: String,  val prof: String){
//    constructor(name: String) : this(name,1,"", "")
//    constructor(name: String, prof: String) : this(name,2,"", prof)
//    constructor(enfermeiro: Enfermeiro) : this(enfermeiro.name, enfermeiro.prof)
//}
//
//data class Enfermeiro(val name: String, var prof: String) {
//
//    fun medicar(){
//        println("medicado")
//    }
//}


fun main() {
    admConta()
//    val pessoa1 = Pessoa( "Bruna", 123, "1239484", "Professor")
//    println(pessoa1)
//
//    val pessoa2 = Pessoa(name = "Clara")
//    println(pessoa2)
//
//    val enfermeiro1 = Enfermeiro("Cleber", "Enfermeiro" )
//    enfermeiro1.medicar()
//
//    val pessoa3 = Pessoa(enfermeiro1)
//    println(pessoa3)

}

//encapsulamento: ultilizando o getter e setter para acessar campo saldo é uma tecnica conhecida como
// Ao encapsular um atributo, apenas a classe é capaz de modificar o valor, como preferir.