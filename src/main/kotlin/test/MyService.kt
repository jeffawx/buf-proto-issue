package test

import demo.user

class MyService {

    fun test() {
        val user = user {
            name = "test"
        }
        println(user)
    }
}

fun main() {
    MyService().test()
}