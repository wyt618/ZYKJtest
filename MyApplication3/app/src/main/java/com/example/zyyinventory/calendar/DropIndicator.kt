package com.example.zyyinventory.calendar

import android.content.Context
import android.graphics.Paint
import android.view.ViewGroup
import android.graphics.PointF


abstract class DropIndicator(context: Context?) : ViewGroup(context) {
    private var circleColor = 0
    private var clickColor = 0
    private var duration = 0
    private var mPainCircle: Paint? = null
    private val mPain = Paint()
    private var ratio = 50f
    private val c = 0.552284749831
    private val r = 1
    private var mWidth = 0
    private var mHeight = 0
    private var startX = 0f
    private var startY = 0
    private var totalOff = 0f
    private var distance = 0f
    private val currOff = 0
    private var mCurrentTime = 0f
    private var tabNum = 0
    private var p2: XPoint? = null
    private var p4: XPoint? = null
    private var p1: YPoint? = null
    private var p3: YPoint? = null
    private var mc = 0f
    private var radius = 0f
    private val roundColors = IntArray(4)
    private var div = 0f
    private var scale = 0.8f

    private var currentPos = 0
    private var toPos = -1


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    internal class YPoint(var x: Float, var y: Float, mc: Float) {
        public var bottom: PointF? = null
        public var top: PointF? = null

        init {
            this.mc = mc
            right!!.x = x + mc
            left!!.x = x - mc

        }
    }

}