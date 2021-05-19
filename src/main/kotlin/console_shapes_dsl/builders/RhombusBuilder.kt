package console_shapes_dsl.builders

import console_shapes.shapes.Rhombus

class RhombusBuilder: ShapeBuilder() {
    override fun build() = Rhombus(lines, char)
}
