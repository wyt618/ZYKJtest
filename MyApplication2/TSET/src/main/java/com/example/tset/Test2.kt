package com.example.tset

import android.graphics.PointF
import java.sql.DriverManager.println


class Test2 {

    fun main(args: Array<String>) {
        var x: Float = 1f
        var y = 1f
        var mc = 3f
        YPoint(x, y, 1f)
        println(x.toString() + y.toString())
    }
    internal class YPoint(var x: Float, var y: Float, var mc: Float) {
        var left: PointF? = null
        var right: PointF? = null


        internal fun setMc(mc: Float) {
            this.mc = mc
            right!!.x = x + mc
            left!!.x = x - mc
        }

        internal fun setX(x: Float) {
            this.x = x
            right!!.x = x + mc
            left!!.x = x - mc
        }

        internal fun setY(y: Float) {
            this.y = y
            left!!.y = y
            right!!.y = y
        }

        fun setLeftX(leftX: Float) {
            left!!.x = leftX
            x = (left!!.x + right!!.x) / 2
        }

        override fun toString(): String {
            return "YPoint{" +
                    "x=" + x +
                    ", y=" + y +
                    ", mc=" + mc +
                    ", left=" + left +
                    ", right=" + right +
                    '}'
        }

        init {
            if (left == null) left = PointF()
            if (right == null) right = PointF()
            right!!.x = x + mc
            left!!.x = x - mc
            left!!.y = y
            right!!.y = y
        }


    }
}

