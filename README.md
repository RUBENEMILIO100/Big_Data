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
                                         
                                         
    
    
    
    
# Contenido 
<a href="https://github.com/RUBENEMILIO100/Big_Data/blob/Unit_1/README.md#practices1-session-1">Practice 1</a>  

<a href="https://github.com/RUBENEMILIO100/Big_Data/blob/Unit_1/README.md#practices-2-unit_1-session-2">Practice 2</a>  

<a href="https://github.com/RUBENEMILIO100/Big_Data/blob/Unit_1/README.md#practices-3-unit_1-mathematical-fibonacci-models-code-session-3">Practice 3</a> 

<a href="https://github.com/RUBENEMILIO100/Big_Data/blob/Unit_1/README.md#practices-4-unit_1basic-functions-for-the-variable-df">Practice 4</a>

<a href="">Practice 5</a> 

<a href="https://github.com/RUBENEMILIO100/Big_Data/blob/Unit_1/README.md#homework_1-unit_1-pearson-correlation">Homework1</a>

<a href="">Homework2</a>

<a href="https://github.com/RUBENEMILIO100/Big_Data/blob/Unit_1/README.md#exam-1">Exam 1</a> 














                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
                                         
# Practices1, Session 1.

    1- Develop an algorithm in scala that calculates the radius of a circle.
     " In this practice only the radius will be calculated by means of values that will be integrated, that will be explained in the code this is exercise one" 
     
    2- Develop an algorithm in scala that tells me if a number is a prime number.
    "In this practice we use lists arrays and mutable maps, lists are declared as a variable of type list, to the lists you can add more elements and can be ordered in different ways"
    
    3- Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet".
    " In this practice 6 algorithms of the Fibonacci sequence were performed. The Fibonacci sequence is done by always adding the last 2 numbers (All the numbers present in the sequence are called Fibonacci numbers) and existing mathematical algorithms are used"
    
    4- Given the variable message = "Hola Luke soy tu padre!" use slilce to extract the sequence "Luke".
    " In this practice we import a spark sql session we create a variable for the spark session and then load a dataset to later use basic functions in the dataset obtaining very interesting results"
    
    5- What is the difference of a value and a variable in scala?.
    " Is a static number and the order one have a difeten value caracteres"
    
    6- Given the tuple (2,4,5,1,2,3,3.1416,23) return the number 3.1416.
    " "
    
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
    " Just call de color they mey have a value codition the requerie"
    
    2- Add 5 more items to "list": "green", "yellow", "blue", "orange", "pearl".
    " Add 5 items and the make litle list "
    
    3- Bring the elements of "list" "green", "yellow", "blue".
    " Call elements in the list they just call"
    
    4- Create a number array in the 1-1000 range in 5-in-5 steps.
    "new arra in the list adn called in a list"
    
    5- What are the unique elements of the List (1,3,3,4,6,7,3,7) use conversion to sets.
    " just a convertion in the list and called a new list "
    
    6- Create a mutable map called "names" that contains the following "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27".
    "Call the names in the list and ther followin whit name "
    
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
  # Functions for groups "df".
  
  ```scala
  import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")
 
//1.sumDistinct
df.select(sumDistinct("Sales")).show()
 
//2.last
df.select(last("Company")).show() //last data in company
 
//3.first
df.select(first("Person")).show() first data in person
 
//4.var_pop
df.select(var_pop("Sales")).show()
 
//5.avg
df.select(avg("Sales")).show()
 
//6.collect_list
df.select(collect_list("Sales")).show()
 
//7.var_samp
df.select(var_samp("Sales")).show()
 
//8.sum
df.select(sum("Sales")).show()
 
//9.stddev_pop
df.select(stddev_pop("Sales")).show()
 
//10.skewness
df.select(skewness("Sales")).show()
 
//11.min
df.select(min("Sales")).show()
 
//12.kurtosis
df.select(kurtosis("Sales")).show()
 
//13.collect_set
df.select(collect_set("Sales")).show()
 
//14.approx_count_distinct
df.select(approx_count_distinct("Company")).show()
 
//15.mean
df.select(mean("Sales")).show()
 
//16 return the first column of the dataframe
df.first
 
//17 Returns the dataframe columns
df.columns
 
//18 Add a column that derives from the high and Volume column
val df2 = df.withColumn("HV Ratio", df("High")+df("Volume"))
 
//19 Choose the volume column min
df.select(min("Volume")).show()
 
//20 Choose the volume column max
df.select(max("Volume")).show()

   ```
  
  # Homework_1 Unit_1, Pearson correlation
  
              
 # What is Pearson Correlation?
 
Correlation between sets of data is a measure of how well they are related. The most common measure of correlation in stats is the Pearson Correlation. The full name is the Pearson Product Moment Correlation (PPMC). It shows the linear relationship between two sets of data. In simple terms, it answers the question, Can I draw a line graph to represent the data? Two letters are used to represent the Pearson correlation: Greek letter rho (ρ) for a population and the letter “r” for a sample. Potential problems with Pearson correlation.
The PPMC is not able to tell the difference between dependent variables and independent variables. For example, if you are trying to find the correlation between a high calorie diet and diabetes, you might find a high correlation of .8. However, you could also get the same result with the variables switched around. In other words, you could say that diabetes causes a high calorie diet. That obviously makes no sense. Therefore, as a researcher you have to be aware of the data you are plugging in. In addition, the PPMC will not give you any information about the slope of the line; it only tells you whether there is a relationship.

# Real Life Example

Pearson correlation is used in thousands of real life situations. For example, scientists in China wanted to know if there was a relationship between how weedy rice populations are different genetically. The goal was to find out the evolutionary potential of the rice. Pearson’s correlation between the two groups was analyzed. It showed a positive Pearson Product Moment correlation of between 0.783 and 0.895 for weedy rice populations. This figure is quite high, which suggested a fairly strong relationship.


<img src="https://i2.wp.com/media.giphy.com/media/1kTNRve3ou82rqpSC2/giphy.gif?resize=1400%2C9999&amp;ssl=1"    alt="https://i2.wp.com/media.giphy.com/media/1kTNRve3ou82rqpSC2/giphy.gif?resize=1400%2C9999&amp;ssl=1">


  # Homework_2 Unit_1,Variance formula 
  
The Pearson coefficient of variation (r) measures the variation of the data with respect to the average, regardless of the units in which they are.


The coefficient of variation takes values ​​between 0 and 1. If the coefficient is close to 0, it means that there is little variability in the data and it is a very compact sample. On the other hand, if they tend to 1 it is a very dispersed sample.

To easily interpret the coefficient, we can multiply it by one hundred to have it as a percentage.

# Exam 1

# Instructions

Given a square matrix, calculate the absolute difference between the sums of your diagonals.
For example, the square matrix is ​​shown below:

arr = [[11,2,, 4], [4,5,6,], [10,8, -12]

diagonal_1 = 11 + 5-12 = 4
diagonal_2 = 4 + 5 + 10 = 19

Absolute Difference = | 4 - 9 | = 15


# Descriptive function

Develop a function called diagonalDifference is a scrip with the programming language
Scala It must return an integer that represents the difference of the absolute diagonal.

Diaz Martinez Ruben Emilio

Flores Acosta Alfredo 

```scala  
val  arr = (( 11 , 2 , 4 ), ( 4 , 5 , 6 ), ( 10 , 8 , - 12 ))


def  DAbsoluta (arre: (( Int , Int , Int ), ( Int , Int , Int ), ( Int , Int , Int ))) :  Int  = {
    val  diagonal_1  = (arre._1._1) + (arre._2._2) + (arre._3._3)
    val  diagonal_2  = (arre._1._3) + (arre._2._2) + (arre._3._1)

    var  diferenciacalculada = diagonal_1 - diagonal_2
    var  resul = math.abs (diferenciacalculada)
    return resul
}

DAbsoluta(arr)

  ```
  
# Exam 2_Unit1

# Instructions:

Answer the following questions with Spark DataFrames using Netflix_2011_2016.csv CSV
Then answer the functions seen in class for each question and execute it later.


Instructions for DataFrame are used in Spark Scala
Code

 ```scala
 // Diaz Martinez Ruben Emilo # 15210791
// Fores Acosta Alfredo # 15210331

// 1- Start a simple Spark session

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder (). getOrCreate ()

// 2- Load the Netflix Stock CSV file, have Spark infer the data types

val df = spark.read.option ("header", "true"). option ("inferSchema", "true") csv ("Netflix_2011_2016.csv")

// 3- What are the names of the columns?

df.show ()

// 4- How is the scheme?

df.printSchema ()


// 5- Print the first 5 columns

df.head (5)

 // 6- Use describe () to learn about the DataFrame

df.describe (). show ()

// 7- create a data frame

val df2 = df.withColumn ("HV Ratio", df ("High") / df ("Volume"))

// 8- What day had the highest peak in the column?

df.select (max ("Close")). show ()

// 9 the Close column means how I close the bag that day
//: It is the closing value of netflix shares.

// 10- What is the maximum and minimum of the volume column

df.select (max ("Volume")). show ()
df.select (min ("Volume")). show ()

// 11- with scala syntaxiyx answer the following

// A) How many days was the column below 600 <

df.filter ($ "Close" <600) .count ()

// B) what percentage of the time was the higth> 500

val res = df.select ($ "High"). filter ($ "High"> 500) .count ()
val by = (res * 1.0) /100.0

// C What is the correlation of pearson between the column high and volume

df.select (corr ("High", "Volume")). show ()

// D What is the maximum of the high column per year

// The year is obtained and added in a new column
val df2 = df.withColumn ("Year", year (df ("Date")))

// It is grouped to the years
val dfmax = df2.groupBy ("Year"). max ()

// The maximum highs per year ordered are taken out
dfmax.select ($ "Year", $ "max (High)"). orderBy ("Year"). show ()


// 11e What is the average of the close column for each calendar month

// The month is taken from the date and added as a new column
val df3 = df.withColumn ("Month", month (df ("Date")))

// The month is grouped with close
val df3prom = df3.select ($ "Month", $ "Close"). groupBy ("Month"). mean ()

// The average is taken out and shown in order by month
df3prom.select ($ "Month", $ "avg (Close)"). orderBy ("Month"). show ()

 ```





