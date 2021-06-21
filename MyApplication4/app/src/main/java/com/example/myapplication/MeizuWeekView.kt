package com.example.myapplication

import java.lang.String

class MeizuWeekView(context: Context) : WeekView(context) {
    private val mTextPaint: Paint = Paint()
    private val mSchemeBasicPaint: Paint = Paint()
    private val mRadio: Float
    private val mPadding: Int
    private val mSchemeBaseLine: Float

    /**
     *
     * @param canvas    canvas
     * @param calendar  日历日历calendar
     * @param x         日历Card x起点坐标
     * @param hasScheme hasScheme 非标记的日期
     * @return true 则绘制onDrawScheme，因为这里背景色不是是互斥的
     */
    protected fun onDrawSelected(canvas: Canvas, calendar: Calendar?, x: Int, hasScheme: Boolean): Boolean {
        mSelectedPaint.setStyle(Paint.Style.FILL)
        mSelectedPaint.setColor(-0x7f303031)
        canvas.drawRect(x + mPadding, mPadding, x + mItemWidth - mPadding, mItemHeight - mPadding, mSelectedPaint)
        return true
    }

    protected fun onDrawScheme(canvas: Canvas, calendar: Calendar, x: Int) {
        mSchemeBasicPaint.setColor(calendar.getSchemeColor())
        canvas.drawCircle(x + mItemWidth - mPadding - mRadio / 2, mPadding + mRadio, mRadio, mSchemeBasicPaint)
        canvas.drawText(calendar.getScheme(), x + mItemWidth - mPadding - mRadio, mPadding + mSchemeBaseLine, mTextPaint)
    }

    protected fun onDrawText(canvas: Canvas, calendar: Calendar, x: Int, hasScheme: Boolean, isSelected: Boolean) {
        val cx: Int = x + mItemWidth / 2
        val top: Int = -mItemHeight / 6
        if (isSelected) {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    mSelectTextPaint)
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10, mSelectedLunarTextPaint)
        } else if (hasScheme) {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    if (calendar.isCurrentMonth()) mSchemeTextPaint else mOtherMonthTextPaint)
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10, mCurMonthLunarTextPaint)
        } else {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    if (calendar.isCurrentDay()) mCurDayTextPaint else if (calendar.isCurrentMonth()) mCurMonthTextPaint else mOtherMonthTextPaint)
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + mItemHeight / 10,
                    if (calendar.isCurrentDay()) mCurDayLunarTextPaint else if (calendar.isCurrentMonth()) mCurMonthLunarTextPaint else mOtherMonthLunarTextPaint)
        }
    }

    companion object {
        /**
         * dp转px
         *
         * @param context context
         * @param dpValue dp
         * @return px
         */
        private fun dipToPx(context: Context, dpValue: Float): Int {
            val scale: Float = context.getResources().getDisplayMetrics().density
            return (dpValue * scale + 0.5f).toInt()
        }
    }

    init {
        mTextPaint.setTextSize(dipToPx(context, 8f))
        mTextPaint.setColor(-0x1)
        mTextPaint.setAntiAlias(true)
        mTextPaint.setFakeBoldText(true)
        mSchemeBasicPaint.setAntiAlias(true)
        mSchemeBasicPaint.setStyle(Paint.Style.FILL)
        mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER)
        mSchemeBasicPaint.setColor(-0x12acad)
        mSchemeBasicPaint.setFakeBoldText(true)
        mRadio = dipToPx(getContext(), 7f).toFloat()
        mPadding = dipToPx(getContext(), 4f)
        val metrics: Paint.FontMetrics = mSchemeBasicPaint.getFontMetrics()
        mSchemeBaseLine = mRadio - metrics.descent + (metrics.bottom - metrics.top) / 2 + dipToPx(getContext(), 1f)
    }
}