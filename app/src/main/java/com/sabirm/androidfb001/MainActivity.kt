package com.sabirm.androidfb001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //leccion1
        //variablesYConstantes()

        //leccion 2
        //tiposdeDatos()

        //leccion3
        //sentenciaIf()

        //leccion when
        //sentenciWhen()

        //leccion arrays
        //arrays()

        //leccion maps
        //maps()

        //Leccion loops
        //loops()

        //clases
        clases()
    }

    private fun variablesYConstantes(){
        //esto es comentario
        /*
        *
        * Esta es otra forma de colocar varialbes
        *
        * */

        // sección variables
        var myFirstVariable  = "Hola mundo.........."
        println(myFirstVariable)
        var secondVariable = myFirstVariable
        println(secondVariable)







        //Constantes
        val myFirstConstant="Presidente: Guillermo Laso"
        println(myFirstConstant)
        /// val myFirstConstant = "sd"
        val secondConstant=myFirstConstant

    }

    private fun tiposdeDatos(){
        //string
        val myString = "Hola Android"
        val myString2 = "Desarrollo de plataformas móviles"
        val myString3 = myString + " " + myString2
        println(myString3)

        //enteros (byte, short, int, long)
        val myInt =1
        val myInt2 =2
        val myInt3= myInt + myInt2
        println(myInt3)

        //decimales (float, double)
        val myFloat = 1.5f
        val myDouble = 1.5
        val myDouble2 = 2.6
        val myDouble3 = 1
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        //Boolean (Bool)
        val myBool = true
        val myBool2= false
        //val myBool3 = myBool + myBool2
        println(myBool == myBool2)
        println(myBool && myBool2)

    }

    private fun sentenciaIf(){
        val myNumber = 60
        //operadores condiciones
        /*
        *
        * > mayot que
        * < menor que
        * >= mayor o igual que
        * <= menor o igual que
        * == igualdad
        * != desigualdad
        *
        * */

        if ((myNumber < 10 && myNumber > 5 ) || myNumber==52) {
            println("$myNumber es mayor que 10000000")
        }else if(myNumber==60){
            println("$myNumber es menor que -------------------------")
        }else{
            println("$myNumber es mayor que 10 o menor o igual q 5 o = 53")
        }
    }

    private fun sentenciWhen(){
        val country = "Colombia"

        when(country){
            "Ecuador", "Colombia" -> {println("Idioma Españoooooooooooool")}
            "EEUU" -> {println("Idioma ingles")}
            "Francia" -> {println("Idioma Frances")}else->{println("No se conoce el idioma")}
        }
    }

    private fun arrays(){
        val name= "Ramiro"
        val surname ="Ramirez"
        val university = "UTPL"
        val age = "38"

        val myArray= arrayListOf<String>()
        myArray.add(name)
        myArray.add(surname)
        myArray.add(university)
        myArray.add(age)

        println(myArray)
        myArray.addAll(listOf("Hola", "Curso de android"))
        println(myArray)

        //elimina datos  del array
        myArray.removeAt(4)
        println(myArray)

        //recorrer el array
        myArray.forEach {
            println(it)
        }

        //otras operaciones
        println(myArray.count())
        myArray.clear()
        println(myArray.count())
        myArray.first()
        myArray.last()
        myArray.sort()

    }

    private fun maps(){
        var myMap: Map<String,Int> = mapOf()

        //añadir elementos
        myMap= mutableMapOf("Ramiro" to 1, "Pedro" to 2, "Sara" to 5)
        println(myMap)
        myMap["Carlos"]=7
        myMap.put("Abigail",8)
        println(myMap)
        myMap.put("Samantha",8)

        //acceder a datos
        println(myMap["Samantha"])

        //borrador de datos
        myMap.remove("Ramiro")
        println(myMap)
    }

    private fun loops(){
        //bubles
        val myArray = listOf("Carro","Tren","Avion","Barco")
        val myMap= mutableMapOf("Ramiro" to 1, "Pedro" to 2, "Sara" to 5)

        //for
        for (myString in myArray){
            println(myString)
        }

        for (myElement in myMap){
            println("${myElement.key}-${myElement.value}")
        }

        for (x in 0..10){
            println(x)
        }

        for (x in 9 until 30){
            println(x)
        }

        for (x in 0..10 step 2){
            println(x)
        }

        for (x in 10 downTo 0  step 3){
            println(x)
        }

        //while
        var x=0
        while (x<10){
            println(x)
            x+=2
        }
    }

    private fun clases(){
        val juan = Programmer(name = "Ramiro", age=35, arrayOf(Programmer.Language.JAVA, Programmer.Language.JAVASCRIPT))
        println(juan.name)
        juan.code()

        //val sara= Programmer(name = "Sara", age = 29, arrayOf("Flutter", "Java", "C++"))
        val sara= Programmer(name = "Sara", age = 29, arrayOf(Programmer.Language.KOTLIN))
        sara.code()
    }
}