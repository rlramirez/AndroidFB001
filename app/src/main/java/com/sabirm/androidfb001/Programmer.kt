package com.sabirm.androidfb001

import java.util.*

class Programmer(val name: String, val age: Int, val languages: Array<Language> ) {
    enum class Language{
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT,
        PHP,
        PYTHON
    }

    fun code(){
        for (language in languages){
            println("Estoy programando en: "+language)
        }
    }
}