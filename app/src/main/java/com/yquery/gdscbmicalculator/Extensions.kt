package com.yquery.gdscbmicalculator

class Extensions {

    companion object {
        fun Float.shorten(decimals: Int): Float {
            return String.format("%.$decimals" + "f", this).replace(',', '.').toFloat()
        }
    }

}