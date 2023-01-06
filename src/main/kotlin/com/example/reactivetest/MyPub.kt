package com.example.reactivetest

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber

class MyPub() : Publisher<Int> {

    val its : Iterator<Int> = arrayOf(1,2,3,4,5,6,7,8,9,10).iterator()

    override fun subscribe(s: Subscriber<in Int>) {
        println("신문사의뢰")
        println("신문사 : 구독정보 생성")
        val subscription = MySubscription(s, its)
        println("신문사 : 구독정보 생성완료")
        s.onSubscribe(subscription)
    }
}
