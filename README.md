# Big_Data Unit_1

                                           TECNOLÓGICO NACIONAL DE MÉXICO
                                          INSTITUTO TECNOLÓGICO DE TIJUANA

                                              SUBDIRECCIÓN ACADÉMICA
                                      DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN

                                                    SEMESTRE: 
                                                Enero - Junio 2020
                                                     CARRERA: 
                                Ing. Tecnologías de la Información y Comunicaciones

                                                     MATERIA:
                                                   Datos Masivos
                                          
                                                  UNIDAD A EVALUAR:
                                                      Unidad 1

                                         NOMBRE Y NÚMERO DE CONTROL DEL ALUMNO:
                                         Diaz Martinez Ruben Emilio #15210791
                                         Flores Acosta Alfredo #15210331
                                                NOMBRE DEL MAESTRO (A):
                                         Dr. Jose Christian Romero Hernandez 
# Practices, Session 1.

    1- Develop an algorithm in scala that calculates the radius of a circle.
    2- Develop an algorithm in scala that tells me if a number is a prime number.
    3- Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet".
    4- Given the variable message = "Hola Luke soy tu padre!" use slilce to extract the sequence "Luke".
    5- What is the difference of a value and a variable in scala?.
    6- Given the tuple (2,4,5,1,2,3,3.1416,23) return the number 3.1416. 
    
```scala
1- Develop an algorithm in scala that calculates the radius of a circle.
```
```scala
val c = 6

var radius = c/(2*3.1416)
```
```scala
2- Develop an algorithm in scala that tells me if a number is a prime number.
```
```scala
def Esprimo(i :Int) : Boolean = {
    if (i <= 1)
    false
    else if (i==2)
    true
    else
    !(2 to (i-1)).exists(x=> i % x==0)
}
```
```scala
3. Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet"
```
```scala
var bird = "tweet"
println ("Im writen a  " + bird)
```
```scala
4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract thesequence "Luke"
```

```scala
var variable = "Hello Luke i am your father!"
variable.slice(5,9)
```

```scala
5. What is the difference in value and a variable in scala?
```
```scala
Value (val) is assigned a value and can no longer be changed
Variable (var) the assigned value can be changed
```
```scala
6. Given the tuple ((2,4,5), (1,2,3), (3,114,23))) return the number 3.1416
```

```scala
var my_tup = (2,4,5,1,2,3,3.1416,23)
my_tup._7
```
# Practices, Session 2.
    1- Create a list called "list" with the elements "red", "white", "black".
    2- Add 5 more items to "list": "green", "yellow", "blue", "orange", "pearl".
    3- Bring the elements of "list" "green", "yellow", "blue".
    4- Create a number array in the 1-1000 range in 5-in-5 steps.
    5- What are the unique elements of the List (1,3,3,4,6,7,3,7) use conversion to sets.
    6- Create a mutable map called "names" that contains the following "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27".
    7- Print all map keys.
    8- Add the following value to the map ("Miguel", 23).
    
 ```scala
 1. Create a list called "list" with the elements "red", "white", "black"
```

```scala
list+= "red"
list+= "white"
list+= "black"
list+= "orange" 
list+= "pearl"
```

 ```scala
 2. Add 5 more items to "list": "green" ,"yellow", "blue", "orange", "pearl"
```

 ```scala
 list = "verde" ::"yellow" ::"blue" ::"orange" ::"pearl" :: list
```

 ```scala
 3. Bring the "list" "green", "yellow", "blue" items
```

 ```scala
 list slice (3,6)
```

 ```scala
 4.Create a number array in the 1-1000 range in 5-in-5 steps
```

 ```scala
 Array.range(1,1000, 5)
```

 ```scala
 5. What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets
```

```scala
var list2 = Lista (1,3,3,4,6,7,3,7)
list2.toSet
```

 ```scala
 6. Create a mutable map called names containing the following "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27
```

 ```scala
 var mutmap = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Susana", 27))
```

 ```scala
 6(a). Print all map keys
```

 ```scala
val names = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23),("Susana",27))
println(mutmap)
```







