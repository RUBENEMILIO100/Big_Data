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
 
```scala 
Fourth Algorithm
In this fourth quarter, a function is agreed upon after having performed
// the corresponding operations the function will give us a result (back)
// this must be an integer value (Int)
def funcion3(n: Int): Int =
{
    var a = 0
    var b = 1
 // A cycle (for) starts where k = 1, will start cycling until it becomes (n)
// (n) represents the value that will be entered into the function
for(k <- 1 to n)
        {

            b = b + a
            a = b - a
 // Depending on the cycle (for) the variables (b, a) will begin to change their result
// until the end of the cycle (for)
        }
// The result will be returned with (return)
       return(a)
}
funcion3(9)
 ```
```scala 
// Fifth Algorithm
// In this fifth algorithm a function is performed that asks for an integer value (Int)
// then return an integer value with decimals (Double)
def funcion4(n: Int): Double =
{
// An array is created that starts from 0 to (n + 1)
    val vector = Array.range (0, n + 1)
// If the variable (n) is less than 2, that same variable is returned as a result
    if (n <2)
    {
        return (n)
    }
// Otherwise the vector with space (0) will have a value of zero (0)
// and the vector with space (1) will have a value of one (1)
    else
    {
        vector (0) = 0
        vector (1) = 1
// Start cycling with a for the vector
        for (k <- 2 to n)
        {
            vector (k) = vector (k-1) + vector (k-2)
        }
// The result will be the variable (n) according to the established vector
        return vector (n)
    }
}
function4 (9)
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
df.select(collect_list("Close")).show() 
  ```
  
 ```scala
//3.  
df.select(collect_set("Close")).show()
  ```
  
 ```scala
//4.  
df.select(first("Close")).show()

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
df.select(max("Close")).show()
  ```
```scala
//7.  
df.select(min("Close")).show()
  ```
  ```scala
//8.  
df.select(skewness("Low")).show()
  ```
  
  ```scala  
//9.  
df.select(sum("High")).show()
  ``` 
  
 ```scala  
//10. 
df.select(kurtosis("Low")).show()
  ``` 
  
```scala  
//11. 
df.select(countDistinct("Volume")).show()
  ``` 
  
```scala  
//12. 
df.select(mean("High")).show()
  ``` 
  ```scala  
//13. 
df.select(var_pop("Close")).show()
  ``` 
  
   ```scala  
//14. 
df.select(concat($"High", $"Low")).show()

  ``` 

```scala  
//15. 
df.select(reverse($"Date")).show()
  ``` 
 
 ```scala  
//16. 
df.select(current_date()).show()

  ``` 
  
  ```scala  
//17. 
df.select(dayofmonth($"Date")).show()
  ``` 
  
  ```scala  
//18. 
df.select(dayofweek($"Date")).show()

  ```

```scala  
//19. 
df.select(month($"Date")).show()
  ```
  
 ```scala  
//20. 
df.select(year($"Date")).show()
  ```
  
  # Homework_1 Unit_1, Pearson correlation
  
              
  # What is Pearson Correlation?

Correlation between sets of data is a measure of how well they are related. The most common measure of correlation in stats is the Pearson Correlation. The full name is the Pearson Product Moment Correlation (PPMC). It shows the linear relationship between two sets of data. In simple terms, it answers the question, Can I draw a line graph to represent the data? Two letters are used to represent the Pearson correlation: Greek letter rho (ρ) for a population and the letter “r” for a sample.
Potential problems with Pearson correlation.

The PPMC is not able to tell the difference between dependent variables and independent variables. For example, if you are trying to find the correlation between a high calorie diet and diabetes, you might find a high correlation of .8. However, you could also get the same result with the variables switched around. In other words, you could say that diabetes causes a high calorie diet. That obviously makes no sense. Therefore, as a researcher you have to be aware of the data you are plugging in. In addition, the PPMC will not give you any information about the slope of the line; it only tells you whether there is a relationship.

  # Real Life Example

Pearson correlation is used in thousands of real life situations. For example, scientists in China wanted to know if there was a relationship between how weedy rice populations are different genetically. The goal was to find out the evolutionary potential of the rice. Pearson’s correlation between the two groups was analyzed. It showed a positive Pearson Product Moment correlation of between 0.783 and 0.895 for weedy rice populations. This figure is quite high, which suggested a fairly strong relationship.

<iframe src="https://giphy.com/embed/Xb7iV9lbbTTAmkRBAP" width="480" height="374" frameBorder="0" class="giphy-embed"   allowFullScreen></iframe><p><a href="https://giphy.com/gifs/Xb7iV9lbbTTAmkRBAP">via GIPHY</a></p>
