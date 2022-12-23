package com.usercfaft.quizapp

 data class database(var name: String )
{


    public val que : Array<String> = arrayOf(

        "Which company owns the Android ?" ,"Who is CEO of Google ? " ," Official language for Android is ?"

    )

    val images:Array<Int> = arrayOf(R.drawable.google,R.drawable.sou,R.drawable.sou )



    val options: Array<Array<String>> = arrayOf(
        arrayOf("apple", "Google", "ibm", "Jetbrains"),
        arrayOf("Sundar Pichai", "nelson Mandela", "Rahul Gandhi", "Tim Cook"),
        arrayOf("c++","java","Kotlin","Dart")
    )

    val ans:Array<String> = arrayOf("Google","Sundar Pichai", "Kotlin" )



}