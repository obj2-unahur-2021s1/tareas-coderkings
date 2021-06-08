package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
    val responsable = Empleado(600)
    val empleado1 = Empleado(500)
    val empleado2 = Empleado(500)
    val tarea = TareaBasico(300,responsable,5000, listOf(empleado1, empleado2))

    it("nomina de empleados") {
      tarea.nominaEmpleados() shouldBe mutableListOf(empleado1,empleado2,responsable)
    }

    it("Horas necesarias, 300 horasEstimadas / 2 empleados") {
      tarea.horasNecesarias() shouldBe 150
    }
    it("Costo tarea") {
      tarea.costo() shouldBe 335000//150*1000 + 300*600 + 5000
    }
  }
  describe("Tareas Integrada") {
    val empleado1 = Empleado(500)
    val empleado2 = Empleado(500)

    val responsable1 = Empleado(1000)
    val responsable2 = Empleado(1000)
    val responsableEnIntegracion = Empleado(1000)

    val tareaBasico1 = TareaBasico(50, responsable1, 1000, listOf(empleado1))
    val tareaBasico2 = TareaBasico(50, responsable2, 1000, listOf(empleado2))
    val tareasIntegrados = TareaDeIntegracion(responsableEnIntegracion, listOf(tareaBasico1, tareaBasico2))
    describe("Nomina de Empleados") {
      tareasIntegrados.nominaEmpleados().shouldContainAll(empleado1, empleado2, responsable1, responsable2, responsableEnIntegracion )
    }
    describe("Cuanto demora en terminar las subTareas, mas una hora para reuniones de planificaion por cada 8hs de trabajo") {
      tareasIntegrados.horasNecesarias().shouldBe(112)
    }
    describe("la suma de costo en subtareas + bonus del responsable a 3%") {
      tareasIntegrados.costo().shouldBe(156560)
    }
  }
})
