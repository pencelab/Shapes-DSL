package console_shapes.container

import console_shapes.shapes.Shape

class Panel {
    private val shapes = mutableListOf<Shape>()

    fun addShape(shape: Shape) {
        this.shapes.add(shape)
    }

    fun print() {
        val lines = shapes.map { it.size }.maxOrNull() ?: 0
        repeat(lines) {
            shapes.forEach { shape ->
                print(shape.line(it))
            }
            println()
        }
    }

}