// Diaz Martinez Ruben Emilo  # 15210791
// Fores Acosta Alfredo  # 15210331

// 1- Cominenza una simple sesion Spark

import org.apache.spark.sql.SparkSession 

val spark = SparkSession.builder().getOrCreate()

// 2- Cargue  el archivo Netflix Stock CSV, haga que Spark infiera los tiopos de dato

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv") 

// 3-  Cuales son los nombres de la columnas ? 

df.show() 

//4-  Como es el esquema ? 

df.printSchema() 


// 5- Impirme las primeras 5 columnas 

df.head(5) 

 // 6- Usa describe () para aprender sobre el DataFrame

df.describe().show()

// 7-  crea un data frame 

val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))

// 8-  Que dia tuvo el pico mas alto en la columna ?

df.select(max("Close")).show() 

// 9 la columna Close significa como cerro ese dia la bolsa
// : Es el valor de cierre de las acciones de netflix.

// 10- Cual es el maximo y minimo de la columna volumen 

df.select(max("Volume")).show()
df.select(min("Volume")).show()

// 11- con syntaxiyx de scala contesta las siguiente

// A) Cuanto dias fue la columna inferios a 600 <

df.filter($"Close" < 600).count()

//B) que porcentaje del tiempo fue la comlumna higth >500

val res = df.select($"High").filter($"High">500).count()
val por = (res * 1.0 )/100.0

// C What is the correlation of pearson between the column high and volume

df.select(corr("High", "Volume")).show()

// D What is the maximum of the high column per year

//The year is obtained and added in a new column
val df2 = df.withColumn("Year", year(df("Date")))

//It is grouped to the years
val dfmax = df2.groupBy("Year").max()

//The maximum highs per year ordered are taken out
dfmax.select($"Year", $"max(High)").orderBy("Year").show()


//11e What is the average of the close column for each calendar month

//The month is taken from the date and added as a new column
val df3 = df.withColumn("Month", month(df("Date")))

//The month is grouped with close
val df3prom = df3.select($"Month",$"Close").groupBy("Month").mean()

//The average is taken out and shown in order by month
df3prom.select($"Month",$"avg(Close)").orderBy("Month").show()
