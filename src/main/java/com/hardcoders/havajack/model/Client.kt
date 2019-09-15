package com.hardcoders.havajack.model

import javax.persistence.*

@Entity
class Client(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val inn: String = "",

    var availableAmount: Double = 0.0,

    var lockedAmount: Double = 0.0,

    val tax: Double = 0.04,

    val invest: Double = 0.005, // per month

    @OneToOne
    val account: Account?

) {
    constructor(): this(0, "",
            0.0,
            0.0,
            0.04,
            0.005,
            null) {

    }
}
