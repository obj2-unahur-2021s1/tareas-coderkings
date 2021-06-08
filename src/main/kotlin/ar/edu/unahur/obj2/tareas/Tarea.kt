package ar.edu.unahur.obj2.tareas

abstract class Tarea(val responsable: Empleado) {
    abstract fun nominaEmpleados(): List<Empleado>
    abstract fun horasNecesarias(): Int
    abstract fun costo(): Int
}

class TareaBasico(val horasEstimadas: Int, responsable: Empleado , val costoInfraestructura: Int, val empleadosContratados: List<Empleado>): Tarea(responsable) {

    override fun nominaEmpleados() = (empleadosContratados + responsable).toList()
    override fun horasNecesarias() = horasEstimadas / cantidadEmpleados()
    fun cantidadEmpleados() = empleadosContratados.size
    fun sueldoPorHoraAEmpleados() = empleadosContratados.sumBy{ it.sueldoPorHora }
    fun sueldoPorEmpleados() = horasNecesarias() * sueldoPorHoraAEmpleados()
    fun sueldoResponsable() = horasEstimadas * responsable.sueldoPorHora
    override fun costo() =
        sueldoPorEmpleados() +
        sueldoResponsable() +
        costoInfraestructura
}

class TareaDeIntegracion(responsable: Empleado,val subTareas: List<TareaBasico>): Tarea(responsable) {
    override fun nominaEmpleados() = (nomimaDeSubTareas() + responsable).toList()
    override fun horasNecesarias() = horasEnTerminarlasTareas() + tiempoDePlanificacion()
    override fun costo() = costoTotalEnSubTareas() + bonusExtraResponsable()

    fun horasEnTerminarlasTareas() = subTareas.sumBy { it.horasNecesarias() }
    fun nomimaDeSubTareas() = subTareas.flatMap { it.nominaEmpleados() }
    fun tiempoDePlanificacion() = horasEnTerminarlasTareas() / 8
    fun costoTotalEnSubTareas() = subTareas.sumBy { it.costo() }
    fun bonusExtraResponsable() = costoTotalEnSubTareas() * 3 / 100

}
class Empleado(val sueldoPorHora :Int) {

}