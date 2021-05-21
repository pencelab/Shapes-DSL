import console_shapes_dsl.external.panel
import console_shapes_dsl.external.*

fun main() {
    panel {
        val square = square {
            lines = 8
            char = 'd'
        }
        space()
        val triangle = triangle {
            lines = 7
            char = 's'
        }
        space()
        val rhombus = rhombus {
            lines = 11
            char = 'l'
        }
        space()
        composed { square union rhombus }
        space()
        composed { rhombus + triangle }
        space()
        composed { square intersection rhombus }
        space()
        composed { rhombus - triangle }
        space()
        composed { square union rhombus union triangle }
        space()
        composed { square intersection rhombus intersection triangle }
        space()
        composed {

            val smallSquare = square {
                lines = 4
                char = 'x'
            }

            val smallTriangle = triangle {
                lines = 5
                char = 'o'
            }

            smallSquare + smallTriangle union rhombus { lines = 5 }
        }
    }.print()
}
