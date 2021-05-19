package console_shapes_dsl.builders

import console_shapes.shapes.Triangle

class TriangleBuilder: ShapeBuilder() {
    override fun build() = Triangle(lines, char)
}
