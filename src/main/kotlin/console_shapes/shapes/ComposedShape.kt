package console_shapes.shapes

class ComposedShape(first: Shape, second: Shape, operation: Operation): Shape() {

    enum class Operation {
        UNION,
        INTERSECTION
    }

    override val grid: Array<CharArray> = when(operation) {
        Operation.UNION -> first.union(second)
        Operation.INTERSECTION -> first.intersection(second)
    }

    private fun Shape.union(shape: Shape): Array<CharArray> {
        return Array(maxOf(this.size, shape.size)) {
            this.line(it).union(shape.line(it))
        }
    }

    private fun Shape.intersection(shape: Shape): Array<CharArray> {
        return Array(minOf(this.size, shape.size)) {
            this.line(it).intersection(shape.line(it))
        }
    }

    private fun CharArray.union(line: CharArray): CharArray {
        return CharArray(maxOf(this.size, line.size)) {
            when {
                it < line.size && line[it] != WHITE_SPACE -> line[it]
                it < this.size && this[it] != WHITE_SPACE -> this[it]
                else -> WHITE_SPACE
            }
        }
    }

    private fun CharArray.intersection(line: CharArray): CharArray {
        return CharArray(minOf(this.size, line.size)) {
            when {
                this[it] != WHITE_SPACE && line[it] != WHITE_SPACE -> line[it]
                else -> WHITE_SPACE
            }
        }
    }
}
