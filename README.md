# Shapes-DSL
This is a project that shows how to build a DSL in Kotlin.

**Branches:**

- `master`: Initial code.

- `dsl`: DSL completed.

- `dsl-enhanced`: DSL completed + some improvements.

### What the application does

The initial code defines geometric shapes and a panel which contains a shapes' list to print them to the console simulating a physical printer, side by side, line by line, top-down.

All the shapes are capable of being combined with other shapes by two operations: *Union* and *Intersection*.

**Console output sample:**
```
dddddddd         s              l        dddddldd           ls              l                   dddddlsd                
dddddddd        sss            lll       ddddllld          lsss            lll         ss       ddddlsss             ss 
dddddddd       sssss          lllll      dddlllll         lsssss          lllll       ssss      dddlsssss           ssss
dddddddd      sssssss        lllllll     ddlllllll       lsssssss        llllll      ssssss     ddlsssssss         sssss
dddddddd     sssssssss      lllllllll    dlllllllll     lsssssssss      lllllll     ssssssss    dlsssssssss       ssssss
dddddddd    sssssssssss    lllllllllll   lllllllllll   lsssssssssss    llllllll    ssssssssss   lsssssssssss     sssssss
dddddddd   sssssssssssss    lllllllll    dlllllllll    sssssssssssss    lllllll    sssssssss    sssssssssssss    sssssss
dddddddd                     lllllll     ddlllllll       lllllll         llllll                 ddlllllll               
                              lllll         lllll         lllll                                    lllll                
                               lll           lll           lll                                      lll                 
                                l             l             l                                        l                   
```
### DSL purpose

The main purpose is to learn what a DSL is and understand how plenty of libraries that we include in our projects are built under the hood. We are going to achieve it by writing code that enables us to turn code that looks like this...

```
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
...
panel.print()
```
...into code that looks like this...
```
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
    ...
}.print()
```

