package com.example.digi_locker


var current : Int? = null


class AppConstants {

    var sections = arrayListOf<String>("License","RC","Id card","Passport","Records","Others")

    fun setScreen(cur : Int){
        current = cur
    }

    fun getCurrentScreen():Int?{
        return current
    }

}