package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
    it("nomina de empleados") {
      val responsable = Responsable(600)
      val tarea = Tarea(300,responsable)
      val empleado1 = Empleado(500)
      val empleado2 = Empleado(500)
      tarea.empleados.add(empleado1)
      tarea.empleados.add(empleado2)
      tarea.nominaEmpleados() shouldBe mutableListOf(empleado1,empleado2,responsable)
    }

  }


})
