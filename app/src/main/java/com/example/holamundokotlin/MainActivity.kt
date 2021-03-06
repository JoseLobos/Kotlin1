package com.example.holamundokotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Cursos(val nombre:String, val url: String)
class MainActivity : AppCompatActivity() {
    val  react = Cursos("React","react")
    val kot = Cursos("Kotlin","kotlin")
    var cursoActual = react.copy()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton=findViewById(R.id.botoncito) as Button
        boton.setOnClickListener{
            view -> switchCurso(cursoActual)
        }
        boton.setText(todosLosCursos())
    }
    fun switchCurso(curso:Cursos)
    {
        cursoActual= curso.copy()
        when(curso.url)
        {
            "react" -> cursoActual= kot.copy()
            "kotlin" -> cursoActual= react.copy()
            else -> print("Esto nunca va a pasar")
        }
        verEnPantalla ("Curso de ${cursoActual.nombre} en platzi.com/${cursoActual.url}")
    }
    fun verEnPantalla ( s :String)
    {
        val txt = findViewById(R.id.mensaje)as TextView
        txt.setText(s)
    }
    fun todosLosCursos () : String = "${react.nombre} y ${kot.nombre}"
}