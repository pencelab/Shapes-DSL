package console_shapes_dsl.builders

import console_shapes.shapes.Square

class SquareBuilder: ShapeBuilder() {
    override fun build() = Square(lines, char)
}
