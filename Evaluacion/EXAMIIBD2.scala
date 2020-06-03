// DIAZ MARTINEZ RUBEN EMILIO, FLORES ACOSTA ALFREDO.
// TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES.

// LIBRERIA " MLlib "  DE SPARK
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors

// USAR EL DATASET IRIS QUE SE ENCUENTRA EN ESTA DESCRIPCION (1)
// DATASET FORMATO CSV https://github.com/jcromerohdz/iris  

// CARGA DE DATOS DEL DATASET
val data = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("iris.csv")

// POSTERIORMENTE SE HACE LA LIMPIEZA DE DATOS
val dataClean = data.na.drop()

// SE PROYECTAN LOS NOMBRES DE LAS COLUMNAS (2)
data.columns 

// DE IGUAL MANERA SE PROYECTA EL ESQUEMA  (3)
data.printSchema()

// IMPRESION DE LAS PRIMERAS 5 COLUMNAS (4)
data.show(5)
data.select($"sepal_length",$"sepal_width",$"petal_length",$"petal_width",$"species").show(5)

// ESTE METODO SE USA PARA EXTRAER O MOSTRAR LOS DATOS PARA SU MEJOR LECTURA DEL DATAFRAME (5)
data.describe().show()

// ESTA SECCION CUBRE ALGORITMOS PARA TRABAJAR CON CARACTERISTICAS,DIVIDIDAS QUE SE APROXIMAN EN GRUPOS DE DATOS (6)

val vectorFeatures = (new VectorAssembler().setInputCols(Array("sepal_length","sepal_width", "petal_length","petal_width")).setOutputCol("features"))

// AQUI SOLO SE TRASNFORMA USANDO EL DATAFRAME 
val features = vectorFeatures.transform(dataClean)

// CONVIERTE UNA SOLA COLUMNA EN UNA COLUMNA INDICE (SIMILAR A UNA COLUMNA DE FACTOR  X)
val speciesIndexer = new StringIndexer().setInputCol("species").setOutputCol("label")

//  AJUSTAMOS EL INDEX CON EL VECTOR FEATURES 
val dataIndexed = speciesIndexer.fit(features).transform(features)

// MODELO DE CLASIFICACION Y ARQUITECTURA (7) 

// "SPLITS" SE USA PARA SEPARAR OBTENER VALORES COMO LOS ARCHIVOS CSV DELIMITADOs POR LOS PIPELINES 
val splits = dataIndexed.randomSplit(Array(0.6, 0.4), seed = 1234L)

// VARIABLE DE ENTRENAMIENTO "train"  SE DECLARA CON EL 60% DE EL LAINFORMACION
val train = splits(0)

// POR EL OTRO LADO LA VARIABLE "test" SE DECLARA CON EL 40% RESTANTE DE LA INFORMACION
val test = splits(1)

// ANTERIORMENTE ESTE ES UN MODELO DE RED NEURONAL

val layers = Array[Int](4, 5, 4, 3)


val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// DATOS DE ENTRENAMIENTO
val model = trainer.fit(train)

// ENTRENAIENTO Y CORRIDA
val result = model.transform(test)

// IMPRIMIR RESULTADOS DEL MODELO (8)
val predictionAndLabels = result.select("prediction", "label")

// SE MUESTRA UN APROX DEL RESULTADO 
predictionAndLabels.show(50)
result.show(30)

// TESTEO DE EXATITUD O PRESISION 
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
println(s"Prueba de precisión = ${evaluator.evaluate(predictionAndLabels)}")

