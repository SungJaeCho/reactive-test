package com.example.reactivetest

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class MySub: Subscriber<Int> {

    private var s: Subscription? = null
    private var bufferSize = 2L

    override fun onSubscribe(s: Subscription?) {
        println("구독자 : 구독 정보 잘 받았어")
        this.s = s
        println("구독자 : 나이제 신문 1개씩 줘")
        s?.request(bufferSize) //백프레셔 소비자가 한번에 처리할 수 있는 개수를 요청
    }

    override fun onNext(t: Int?) {
        println("onNext(): $t")
        bufferSize--
        if (bufferSize == 0L) {
            println("하루지남------")
            bufferSize = 2L
            s?.request(bufferSize)
        }
    }

    override fun onError(t: Throwable?) {
        println("구독중 에러")
    }

    override fun onComplete() {
        println("구독 완료")
    }
}
