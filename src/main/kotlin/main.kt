import console_shapes.container.Panel
import console_shapes.shapes.*

fun main() {
    val panel = Panel()
    val square = Square(8, 'd')
    val triangle = Triangle(7, 's')
    val rhombus = Rhombus(11, 'l')

    panel.addShape(square)
    panel.addShape(Space)
    panel.addShape(triangle)
    panel.addShape(Space)
    panel.addShape(rhombus)
    panel.addShape(Space)
    panel.addShape(
        ComposedShape(square, rhombus, ComposedShape.Operation.UNION)
    )
    panel.addShape(Space)
    panel.addShape(
        ComposedShape(rhombus, triangle, ComposedShape.Operation.UNION)
    )
    panel.addShape(Space)
    panel.addShape(
        ComposedShape(square, rhombus, ComposedShape.Operation.INTERSECTION)
    )
    panel.addShape(Space)
    panel.addShape(
        ComposedShape(rhombus, triangle, ComposedShape.Operation.INTERSECTION)
    )
    panel.addShape(Space)
    panel.addShape(
        ComposedShape(
            ComposedShape(square, rhombus, ComposedShape.Operation.UNION),
            triangle,
            ComposedShape.Operation.UNION
        )
    )
    panel.addShape(Space)
    panel.addShape(
        ComposedShape(
            ComposedShape(square, rhombus, ComposedShape.Operation.INTERSECTION),
            triangle,
            ComposedShape.Operation.INTERSECTION
        )
    )

    panel.print()
}
