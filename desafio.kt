enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO } //O elemento "DIFICIL" foi modificado para "AVANCADO" apenas para soar melhor

//a propriedade idade foi tornada como var, visto que a idade muda a cada ano. A classe Usuário foi transformada em uma data class, visto que está classe possui
//a função de representar um usuário com seus dados
data class Usuario(val nome: String, var idade: Int) 

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

//a propriedade "nivel" foi adicionada para representar a dificuldade do curso
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    //o parâmetro foi transformado em um varargs, permitindo matricular um ou mais usuários ao mesmo tempo
    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(listOf(*usuarios))
    }
}

fun main() {
    //instanciação de alguns usuário
    val user1 = Usuario("Altair", 20)
    val user2 = Usuario("Alexandre", 17)
    val user3 = Usuario("Jake", 16)
    
    //instanciação de alguns conteudos educacionais
    val cont1 = ConteudoEducacional("Desenvolvimento Unity")
    val cont2 = ConteudoEducacional("C++ Programming language", 75)
    val cont3 = ConteudoEducacional("C# Programming language")
    val cont4 = ConteudoEducacional("HTML", 80)
    
    //instanciação de duas formações
    val form1 = Formacao("Web developer", listOf(cont3, cont4), Nivel.INTERMEDIARIO)
    val form2 = Formacao("Game developer", listOf(cont1, cont2), Nivel.AVANCADO)
    
    //matriculação dos usuários as formações
    form1.matricular(user3)
    form2.matricular(user1, user2)
    
    //imprimo os dados apenas para mostrar que todos foram salvos com sucesso
    //form1
    println("Nome: ${form1.nome}")
    println("Conteúdos: ${form1.conteudos.joinToString{it.nome}}")
    println("Nível: ${form1.nivel}")
    println("Matriculados: ${form1.inscritos.joinToString{it.nome}}\n")
    
    //form2
    println("Nome: ${form2.nome}")
    println("Conteúdos: ${form2.conteudos.joinToString{it.nome}}")
    println("Nível: ${form2.nivel}")
    println("Matriculados: ${form2.inscritos.joinToString{it.nome}}")
}