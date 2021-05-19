package console_shapes_dsl.builders

import console_shapes.shapes.Shape
import console_shapes_dsl.external.ShapeDsl

@ShapeDsl
abstract class ShapeBuilder {

    private companion object {
        const val DEFAULT_CHAR = '*'
    }

    var char = DEFAULT_CHAR
    var lines = 0

    abstract fun build(): Shape
}
