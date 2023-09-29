// [Playground](https://pl.kotl.in/3dTUGvuC)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun calcularTempoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 30)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 40)

    val formacao = Formacao("Desenvolvimento Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Formação: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    println("Conteúdos:")
    formacao.conteudos.forEach { println("- ${it.nome} (${it.duracao} minutos)") }

    println("\nPessoas Matriculadas:")
    formacao.inscritos.forEach { println("- ${it.nome}") }

    println("\nTempo Total da Formação: ${formacao.calcularTempoTotal()} minutos")
}

