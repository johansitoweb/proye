data class Tarea(val descripcion: String, var completada: Boolean = false)  

fun main() {  
    val tareas = mutableListOf<Tarea>()  
    var op: Int  

    do {  
        println("\n--- Lista de Tareas ---")  
        println("1. Agregar tarea")  
        println("2. Listar tareas")  
        println("3. Marcar tarea como completada")  
        println("4. Salir")  

        print("Seleccione una opción: ")  
        op = readLine()!!.toInt()  

        when (op) {  
            1 -> {  
                // Agregar tarea  
                print("Ingrese la descripción de la tarea: ")  
                val descripcion = readLine()!!  
                tareas.add(Tarea(descripcion))  
                println("Tarea agregada: $descripcion")  
            }  
            2 -> {  
                // Listar tareas  
                if (tareas.isEmpty()) {  
                    println("No hay tareas en la lista.")  
                } else {  
                    println("Tareas:")  
                    for ((indice, tarea) in tareas.withIndex()) {  
                        val estado = if (tarea.completada) "✔️ Completada" else "❌ Pendiente"  
                        println("${indice + 1}. ${tarea.descripcion} - $estado")  
                    }  
                }  
            }  
            3 -> {  
                // Marcar tarea como completada  
                println("Ingrese el número de la tarea a marcar como completada:")  
                val numeroTarea = readLine()!!.toIntOrNull()  

                if (numeroTarea != null && numeroTarea in 1..tareas.size) {  
                    tareas[numeroTarea - 1].completada = true  
                    println("Tarea marcada como completada.")  
                } else {  
                    println("Número de tarea inválido.")  
                }  
            }  
            4 -> {  
                println("Saliendo...")  
            }  
            else -> {  
                println("Opción no válida. Intente de nuevo.")  
            }  
        }  
    } while (op != 4)  
}