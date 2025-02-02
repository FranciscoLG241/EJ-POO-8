



class Libro(val titulo: String, val autor: String, val numeroPaginas: Int, val calificacion: Int) {

    fun mostrarInfo() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Número de páginas: $numeroPaginas")
        println("Calificación: $calificacion/10")
    }
}




class ConjuntoLibros(private val capacidad: Int) {

    private val libros = ArrayList<Libro>()


    fun añadirLibro(libro: Libro): Boolean {
        return if (libros.size < capacidad && libros.none { it.titulo == libro.titulo || it.autor == libro.autor }) {
            libros.add(libro)
            true
        } else {
            false
        }
    }



    fun eliminarPorTitulo(titulo: String): Boolean {
        val libro = libros.find { it.titulo == titulo }
        return if (libro != null) {
            libros.remove(libro)
            true
        } else {
            false
        }
    }



    fun eliminarPorAutor(autor: String): Boolean {
        val libro = libros.find { it.autor == autor }
        return if (libro != null) {
            libros.remove(libro)
            true
        } else {
            false
        }
    }



    fun libroConMayorCalificacion(): Libro? {
        return libros.maxByOrNull { it.calificacion }
    }




    fun libroConMenorCalificacion(): Libro? {
        return libros.minByOrNull { it.calificacion }
    }




    fun mostrarContenido() {
        if (libros.isEmpty()) println("El conjunto está vacío.")
        else libros.forEach { it.mostrarInfo(); println() }
    }

}

fun main() {

    val libro1 = Libro("RFRWRGRG", "GRWGWRGRWGW", 417, 10)
    val libro2 = Libro("GWGWRGRE", "FEWFEWFEWG", 328, 8)


    val conjunto = ConjuntoLibros(5)


    conjunto.añadirLibro(libro1)
    conjunto.añadirLibro(libro2)


    println("Contenido del conjunto después de añadir los libros:")
    conjunto.mostrarContenido()


    conjunto.eliminarPorTitulo("RFRWRGRG")
    println("Contenido después de eliminar por título (RFRWRGRG:")
    conjunto.mostrarContenido()

    conjunto.eliminarPorAutor("GRWGWRGRWGW")
    println("Contenido después de eliminar por autor (GRWGWRGRWGW):")
    conjunto.mostrarContenido()


    val libro3 = Libro("Las aventuras en Kotlin", "Intell", 180, 9)
    conjunto.añadirLibro(libro3)


    println("Contenido final del conjunto:")
    conjunto.mostrarContenido()


    val libroMayor = conjunto.libroConMayorCalificacion()
    val libroMenor = conjunto.libroConMenorCalificacion()


    println("Libro con mayor calificación:")
    libroMayor?.mostrarInfo()

    println("Libro con menor calificación:")
    libroMenor?.mostrarInfo()
}
