package com.example.reactivetest

class App {
}

fun main() {
    val pub = MyPub() // 출판사 생성
    val sub = MySub() // 구독자 생성
    pub.subscribe(sub!!)
}
