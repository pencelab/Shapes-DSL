package console_shapes_dsl.external

import console_shapes.container.Panel
import console_shapes.shapes.*
import console_shapes_dsl.builders.ComposedScope
import console_shapes_dsl.builders.RhombusBuilder
import console_shapes_dsl.builders.SquareBuilder
import console_shapes_dsl.builders.TriangleBuilder

inline fun panel(init: (@ShapeDsl Panel).() -> Unit): Panel {
    return Panel().apply { init() }
}

inline fun Panel.square(init: SquareBuilder.() -> Unit): Square {
    return SquareBuilder().apply { init() }.build().also { this.addShape(it) }
}

inline fun Panel.triangle(init: TriangleBuilder.() -> Unit): Triangle {
    return TriangleBuilder().apply { init() }.build().also { this.addShape(it) }
}

inline fun Panel.rhombus(init: RhombusBuilder.() -> Unit): Rhombus {
    return RhombusBuilder().apply { init() }.build().also { this.addShape(it) }
}

inline fun Panel.composed(init: ComposedScope.() -> ComposedShape): ComposedShape {
    return ComposedScope().run { init() }.also { this.addShape(it) }
}

fun Panel.space() {
    this.addShape(Space)
}

infix fun Shape.union(shape: Shape): ComposedShape {
    return ComposedShape(this, shape, ComposedShape.Operation.UNION)
}

infix fun Shape.intersection(shape: Shape): ComposedShape {
    return ComposedShape(this, shape, ComposedShape.Operation.INTERSECTION)
}

operator fun Shape.plus(shape: Shape): ComposedShape = this union shape

operator fun Shape.minus(shape: Shape): ComposedShape = this intersection shape

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class ShapeDsl
