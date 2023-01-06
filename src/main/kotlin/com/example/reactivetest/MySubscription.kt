package com.example.reactivetest

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

// 구독 정보(구독자, 어떤 데이터를 구독할지)
class MySubscription(
    private val s: Subscriber<in Int>,
    private val it: Iterator<Int>
) : Subscription {

    init {
//        println("신문사 : 구독정보 생성 완료")
    }
    override fun request(n: Long) {
        var i = n
        while (i > 0) {
            if (it.hasNext()) {
                s.onNext(it.next())
            } else {
                s.onComplete()
                break
            }
            i--
        }
    }

    override fun cancel() {
    }
}
