// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val matricula: String) {
    override fun toString(): String {
        return "Usuario: $nome | matricula: $matricula"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int) {
    override fun toString(): String {
        return "Conteudo: $nome | duracao: $duracao"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel)  {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        return """
        Formacao: $nome
        Conteudos: $conteudos
        Nivel: $nivel
        Alunos Matriculados: $inscritos
            """.trimIndent()
    }
}

fun geradorMat() : String {
    return (100..1000).random().toString()
}

fun main() {
    val vitoria = Usuario("Vitória", geradorMat())
    val valeria = Usuario("Váleria", geradorMat())
    val vandressa = Usuario("Vandressa", geradorMat())
    val gabriela = Usuario("Gabriela", geradorMat())


    val conteudoKotlin = ConteudoEducacional("Kotlin Experience", 40)
    val conteudoBI = ConteudoEducacional("Power BI", 60)
    val conteudoTechLeader = ConteudoEducacional("Gestao de Pessoas, Arquitetura de Projetos", 120)
    val conteudoJunior = ConteudoEducacional("Logica de programacao, Algoritmo, POO", 60)


    val formacaoAndroid = Formacao("Android Developer", listOf(conteudoJunior, conteudoKotlin), Nivel.BASICO)
    val formacaoUX = Formacao("UX Developer", listOf(conteudoBI), Nivel.BASICO)
    val formacaoTechLeader = Formacao("Tech Leader", listOf(conteudoTechLeader), Nivel.AVANCADO)
    val formacaoDevJunior = Formacao("Junior Developer", listOf(conteudoJunior), Nivel.BASICO)


    formacaoAndroid.matricular(vitoria)
    formacaoDevJunior.matricular(valeria, vandressa)
    formacaoTechLeader.matricular(gabriela)
    formacaoUX.matricular(vandressa)


    println("\n=======================================\n")
    println(formacaoAndroid)
    println("\n=======================================\n")
    println(formacaoDevJunior)
    println("\n=======================================\n")
    println(formacaoUX)
    println("\n=======================================\n")
    println(formacaoTechLeader)





}