// DIAZ MARTINEZ RUBEN EMILIO, FLORES ACOSTA ALFREDO.
// TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES.

// SPARK "MLlib" BOOKSTORE
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature. {VectorAssembler, StringIndexer}
import org.apache.spark.ml.linalg.Vectors

// USE THE IRIS DATASET FOUND IN THIS DESCRIPTION (1)
// DATASET CSV FORMAT https://github.com/jcromerohdz/iris

// LOADING DATA FROM THE DATA
val data = spark.read.option ("header", "true"). option ("inferSchema", "true"). format ("csv"). load ("iris.csv")

// SUBSEQUENTLY CLEANED DATA
val dataClean = data.na.drop ()

// THE NAMES OF THE COLUMNS ARE PROJECTED (2)
data.columns

// IN THE SAME WAY THE SCHEME IS PROJECTED (3)
data.printSchema ()

// PRINTING OF THE FIRST 5 COLUMNS (4)
data.show (5)
data.select ($ "sepal_length", $ "sepal_width", $ "petal_length", $ "petal_width", $ "species"). show (5)

// THIS METHOD IS USED TO EXTRACT OR DISPLAY THE DATA FOR THE BEST READING OF THE DATAFRAME (5)
data.describe (). show ()

// THIS SECTION COVERS ALGORITHMS TO WORK WITH FEATURES, DIVIDED THAT APPROXIMATE IN DATA GROUPS (6)

val vectorFeatures = (new VectorAssembler (). setInputCols (Array ("sepal_length", "sepal_width", "petal_length", "petal_width")). setOutputCol ("features"))

// HERE IS ONLY TRANSFORMED USING THE DATAFRAME
val features = vectorFeatures.transform (dataClean)

// CONVERT A SINGLE COLUMN TO AN INDEX COLUMN (SIMILAR TO A FACTOR X COLUMN)
val speciesIndexer = new StringIndexer (). setInputCol ("species"). setOutputCol ("label")

// WE ADJUST THE INDEX WITH THE VECTOR FEATURES
val dataIndexed = speciesIndexer.fit (features) .transform (features)

// CLASSIFICATION AND ARCHITECTURE MODEL (7)

// "SPLITS" IS USED TO SEPARATE TO OBTAIN VALUES SUCH AS CSV FILES DELIMITED BY PIPELINES
val splits = dataIndexed.randomSplit (Array (0.6, 0.4), seed = 1234L)

// TRAINING VARIABLE "train" IS DECLARED WITH 60% OF THE INFORMATION
val train = splits (0)

// ON THE OTHER SIDE THE VARIABLE "test" IS DECLARED WITH THE REMAINING 40% OF THE INFORMATION
val test = splits (1)

// PREVIOUSLY THIS IS A NEURAL NETWORK MODEL

val layers = Array [Int] (4, 5, 4, 3)


val trainer = new MultilayerPerceptronClassifier (). setLayers (layers) .setBlockSize (128) .setSeed (1234L) .setMaxIter (100)

// TRAINING DATA
val model = trainer.fit (train)

// TRAINING AND RUNNING
val result = model.transform (test)

// PRINT MODEL RESULTS (8)
val predictionAndLabels = result.select ("prediction", "label")

// AN APPROX OF THE RESULT IS SHOWN
predictionAndLabels.show (50)
result.show (30)

// TESTING FOR ACCURACY OR PRESSURE
val evaluator = new MulticlassClassificationEvaluator (). setMetricName ("accuracy")
println (s "Accuracy test = $ {evaluator.evaluate (predictionAndLabels)}")

