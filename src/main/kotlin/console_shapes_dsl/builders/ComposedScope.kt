package console_shapes_dsl.builders

import console_shapes.shapes.Rhombus
import console_shapes.shapes.Square
import console_shapes.shapes.Triangle
import console_shapes_dsl.external.ShapeDsl

@ShapeDsl
class ComposedScope {

    fun square(init: SquareBuilder.() -> Unit): Square {
        return SquareBuilder().apply { init() }.build()
    }

    fun triangle(init: TriangleBuilder.() -> Unit): Triangle {
        return TriangleBuilder().apply { init() }.build()
    }

    fun rhombus(init: RhombusBuilder.() -> Unit): Rhombus {
        return RhombusBuilder().apply { init() }.build()
    }
}