package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas :Int, val responsable :Responsable , val costoInfraestructura :Int) {
    val empleados = mutableListOf<Empleado>()

    fun nominaEmpleados() = empleados + responsable
    fun horasNecesarias() = horasEstimadas / cantidadEmpleados()
    fun cantidadEmpleados() = empleados.size
    fun sueldoPorHoraCadaEmpleado() = empleados.sumBy{ it.sueldoPorHora }
    fun costo() =
        horasNecesarias() * sueldoPorHoraCadaEmpleado() +
        horasEstimadas * responsable.sueldo +
        costoInfraestructura
}

class Empleado(val sueldoPorHora :Int) {

}

class Responsable(val sueldo :Int) {

}


