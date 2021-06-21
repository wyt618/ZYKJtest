package com.example.myapplication

import java.lang.String

class MeiZuMonthView(context: Context) : MonthView(context) {
    /**
     * 自定义魅族标记的文本画笔
     */
    private val mTextPaint: Paint = Paint()

    /**
     * 自定义魅族标记的圆形背景
     */
    private val mSchemeBasicPaint: Paint = Paint()
    private val mRadio: Float
    private val mPadding: Int
    private val mSchemeBaseLine: Float

    /**
     * 绘制选中的日子
     * @param canvas    canvas
     * @param calendar  日历日历calendar
     * @param x         日历Card x起点坐标
     * @param y         日历Card y起点坐标
     * @param hasScheme hasScheme 非标记的日期
     * @return 返回true 则会继续绘制onDrawScheme，因为这里背景色不是是互斥的，所以返回true，返回false，则点击scheme标记的日子，则不继续绘制onDrawScheme，自行选择即可
     */
    protected fun onDrawSelected(canvas: Canvas, calendar: Calendar?, x: Int, y: Int, hasScheme: Boolean): Boolean {
        mSelectedPaint.setStyle(Paint.Style.FILL)
        mSelectedPaint.setColor(-0x7f303031)
        canvas.drawRect(x + mPadding, y + mPadding, x + mItemWidth - mPadding, y + mItemHeight - mPadding, mSelectedPaint)
        return true
    }

    /**
     * 绘制标记的事件日子
     * @param canvas   canvas
     * @param calendar 日历calendar
     * @param x        日历Card x起点坐标
     * @param y        日历Card y起点坐标
     */
    protected fun onDrawScheme(canvas: Canvas, calendar: Calendar, x: Int, y: Int) {
        mSchemeBasicPaint.setColor(calendar.getSchemeColor())
        canvas.drawCircle(x + mItemWidth - mPadding - mRadio / 2, y + mPadding + mRadio, mRadio, mSchemeBasicPaint)
        canvas.drawText(calendar.getScheme(), x + mItemWidth - mPadding - mRadio, y + mPadding + mSchemeBaseLine, mTextPaint)
    }

    /**
     * 绘制文本
     * @param canvas     canvas
     * @param calendar   日历calendar
     * @param x          日历Card x起点坐标
     * @param y          日历Card y起点坐标
     * @param hasScheme  是否是标记的日期
     * @param isSelected 是否选中
     */
    protected fun onDrawText(canvas: Canvas, calendar: Calendar, x: Int, y: Int, hasScheme: Boolean, isSelected: Boolean) {
        val cx: Int = x + mItemWidth / 2
        val top: Int = y - mItemHeight / 6
        if (isSelected) { //优先绘制选择的
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    mSelectTextPaint)
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + mItemHeight / 10, mSelectedLunarTextPaint)
        } else if (hasScheme) { //否则绘制具有标记的
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    if (calendar.isCurrentMonth()) mSchemeTextPaint else mOtherMonthTextPaint)
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + mItemHeight / 10, mCurMonthLunarTextPaint)
        } else { //最好绘制普通文本
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    if (calendar.isCurrentDay()) mCurDayTextPaint else if (calendar.isCurrentMonth()) mCurMonthTextPaint else mOtherMonthTextPaint)
            canvas.drawText(calendar.getLunar(), cx, mTextBaseLine + y + mItemHeight / 10,
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
        mSchemeBasicPaint.setFakeBoldText(true)
        mRadio = dipToPx(getContext(), 7f).toFloat()
        mPadding = dipToPx(getContext(), 4f)
        val metrics: Paint.FontMetrics = mSchemeBasicPaint.getFontMetrics()
        mSchemeBaseLine = mRadio - metrics.descent + (metrics.bottom - metrics.top) / 2 + dipToPx(getContext(), 1f)
    }
}