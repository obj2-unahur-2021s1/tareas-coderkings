package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas :Int, val responsable :Responsable) {
    val empleados = mutableListOf<Empleado>()

    fun nominaEmpleados() = empleados + responsable
}

class Empleado(val sueldoPorHora :Int) {

}

class Responsable(val sueldo :Int) {

}


