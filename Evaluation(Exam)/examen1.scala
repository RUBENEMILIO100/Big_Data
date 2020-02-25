
// Diaz Martinez Ruben Emilio
//Flores Acosta Alfredo 

// dada una matriz calcule la difrencia absoluta entre las sumas de sus diagonales
// por ejemplo, la matriz cuadrada se muestra a continuacion.


//Funcion descriptiva

//Desarrolar una funcion llamada diagonalDiference en un scrip con el lenjuaje
//de programacion Scala. Esta debe devolver un numero entero que represente la diferencia de la diagonal absoluta.




val  arr = (( 11 , 2 , 4 ), ( 4 , 5 , 6 ), ( 10 , 8 , - 12 ))


def  DAbsoluta (arre: (( Int , Int , Int ), ( Int , Int , Int ), ( Int , Int , Int ))) :  Int  = {
    val  diagonal_1  = (arre._1._1) + (arre._2._2) + (arre._3._3)
    val  diagonal_2  = (arre._1._3) + (arre._2._2) + (arre._3._1)

    var  diferenciacalculada = diagonal_1 - diagonal_2
    var  resul = math.abs (diferenciacalculada)
    return resul
}

DAbsoluta(arr)
















//21/febrero/2020 
//alfredo/emilio/examem.


