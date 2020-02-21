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
# Practices1, Session 1.

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
# Practices 2, Unit_1, Session 2.
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
 ```scala
 6(b). Add the following value to the map ("Miguel", 23). 
```

 ```scala
mutmap += ("Miguel" -> 23)
println(mutmap)
```
# Practices 3, Unit_1 ,Mathematical Fibonacci models (Code) Session 3.

# Examples Bifunacci code.

 ```scala
First Algorithm
In this first algorithm a function was added that after having performed,
the corresponding operations the function will give us a result (return)
this must be an integer value (Int)
```

```scala
def funcion (n: Int): Int = 
{   
// If the number entered in the function is less than 2, the number entered will be returned
 if (n<2)
    {
        return n
    }
// In any case, the function will do a series of sums, and the result returns
  else
    {
        return funcion(n-1) + funcion(n-2)
    }
}

funcion(9)
```

 ```scala
Second Algorithm
In this second algorithm a function was added that after having performed
the corresponding operations the function will give us a result (return)
this must be an integer value with decimal points (Double)
```

 ```scala
 def funcion1(n: Double): Double =
{
// If the number entered in the function is less than 2, the number entered will be returned
   if (n<2)
    {
        return n
    }
// In any case, the following will be done
else
    {
// The mathematical formula is more extensive, but I decided to do it in small parts
// and then join it in the variable (j)
 var p = ((1+(Math.sqrt(5)))/2)
        var a = Math.pow(p,n)
        var b = Math.pow((1-p),n)
        var c = Math.sqrt(5)
        var j = ((a-(b)))/(c)
// The result of (j) will be the result upon return (return)
    return(j)
    }

}
funcion1(9)
```

 ```scala
 Third Algorithm
In this third algorithm a function was added that after having performed
the corresponding operations the function will give us a result (return)
this must be an integer value (Int)
 ```

```scala
def funcion2(n: Int): Int =
{
var a = 0
var b = 1
var c = 0

// A cycle (for) starts where k = 1, will start cycling until it becomes (n)
// (n) represents the value that will be entered into the function
 for (k <- 1 to n)
    {
// Depending on the cycle (for) the variables (c, a, b) will begin to change their result
// until the end of the cycle (for)
    c = b + a
        a = b
        b = c
    }
// The result will be returned with (return)
    return(a)
}
funcion2(9)
 ```
 
 # Practices 4, Unit_1,basic functions for the variable "df".
 
 ```scala 
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")
 ```
 ```scala
//1.  
df.select(avg($"Close")).show()
  ```
 
 ```scala
//2.  
aqui pones el codigo de la 2
  ```
  
 ```scala
//3.  
df.select(collect_set("Close")).show()
  ```
  
 ```scala
//4.  
aqui pones el codigo de la 4
  ```
 
  ```scala
//5.  
df.select(last("Close")).show()
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")
  ```
  
  ```scala
//6.  
codigo de la 6
  ```
```scala
//7.  
df.select(min("Close")).show()
  ```
  ```scala
//8.  
codigo de la 8
  ```
  
  ```scala  
//9.  
df.select(sum("High")).show()
  ``` 
  
 ```scala  
//10.  
codigo de la 10
  ``` 
  
```scala  
//11. 
df.select(countDistinct("Volume")).show()
  ``` 
  
```scala  
//12. 
codigo de la 12
  ``` 
  ```scala  
//13. 
df.select(var_pop("Close")).show()
  ``` 
  
   ```scala  
//14. 
codigo de la 14
  ``` 

```scala  
//15. 
df.select(reverse($"Date")).show()
  ``` 
 
 ```scala  
//16. 
codigo de la 16
  ``` 
  
  ```scala  
//17. 
df.select(dayofmonth($"Date")).show()
  ``` 
