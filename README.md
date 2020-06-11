# Big_Data

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
                                         
# Instructions

Develop the following instructions in Spark with the Scala programming language.

Objective:
The objective of this practical exam is to try to group clients from specific regions
from a wholesale distributor. This is based on the sales of some product categories.        


''' scala
// # 1- Import a simple Spark session.

import org.apache.spark.sql.SparkSession

//                        ^
// Spark Session -------- ^

// # 2 Use the lines of code to minimize errors

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// # 3 Create an instance of the Spark session

val spark = SparkSession.builder().getOrCreate()

// # 4 Import the Kmeans library for the grouping algorithm. 

import org.apache.spark.ml.clustering.KMeans

// # 5 Loads the Wholesale Customers Data dataset
// From https://github.com/jcromerohdz/BigData/blob/master/Spark_clustering/Wholesale%20customers%20data.csv 

val dataset = spark.read.option("header","true").option("inferSchema","true").format("csv").load("Wholesale customers data.csv")

// # 6 Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper,
// Delicassen and call this set feature_data
val feature_data = dataset.select($"Fresh", $"Milk", $"Grocery", $"Frozen", $"Detergents_Paper", $"Delicassen")

// # 7 Import Vector Assembler and Vector
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

// # 8 Create a new Vector Assembler object for feature columns as a
// input set, remembering that there are no labels
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")

// # 9 Use the assembler object to transform feature_data
val traning = assembler.transform(feature_data)

// # 10 Create a Kmeans model with K = 3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(traning)

// # 11 Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.
// Squared Errors
val WSSSE = model.computeCost(traning)
println(s"Within Set Sum of Squared Errors = $WSSSE")

// Centers
println("Cluster Centers: ")
model.clusterCenters.foreach(println)

'''
