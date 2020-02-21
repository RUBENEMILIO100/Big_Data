// Arrays
// Arrays are mutable, List are not
//Practice 2 (Session_3) 
// Diaz Martinez Ruben Emilio #15210791
// Flores Acosta Alfredo # 

import scala.collection.mutable.ListBuffer
val list = collection.mutable.ListBuffer("red","white","black")

// 1. Create a list called "list" with the elements "red", "white", "black"

list+= "green"
list+= "yellow"
list+= "blue"
list+= "orange" 

list+= "perla"

// 3. Bring the "list" "green", "yellow", "blue" items



list slice (3,6)

// 4. Create a number array in the 1-1000 range in 5-in-5 steps

Array.range(1,1000, 5)

// 5. What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets

var list2 = Lista (1,3,3,4,6,7,3,7)
list2.toSet

// 6. Create a mutable map called names containing the following
// "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"

var mutmap = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Susana", 27))

// 6 a. Print all map keys

val names = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23),("Susana",27))

println(mutmap)

// 7 b . Agrega el siguiente valor al mapa("Miguel", 23)

mutmap += ("Miguel" -> 23)
