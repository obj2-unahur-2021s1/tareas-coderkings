package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
    val responsable = Responsable(600)
    val tarea = Tarea(300,responsable,5000)
    val empleado1 = Empleado(500)
    val empleado2 = Empleado(500)
    tarea.empleados.add(empleado1)
    tarea.empleados.add(empleado2)

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


})
