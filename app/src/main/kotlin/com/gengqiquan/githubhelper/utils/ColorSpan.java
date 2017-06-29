
package com.gengqiquan.githubhelper.utils;

import android.os.Parcel;
import android.support.annotation.ColorInt;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public class ColorSpan extends CharacterStyle
        implements UpdateAppearance, ParcelableSpan {
    /**
     * Performs the click action associated with this span.
     */

    private final int mColor;

    public ColorSpan(@ColorInt int color) {
        mColor = color;
    }

    public ColorSpan(Parcel src) {
        mColor = src.readInt();
    }

    public int getSpanTypeId() {
        return getSpanTypeIdInternal();
    }

    /**
     * @hide
     */
    public int getSpanTypeIdInternal() {
        return 2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        writeToParcelInternal(dest, flags);
    }

    /**
     * @hide
     */
    public void writeToParcelInternal(Parcel dest, int flags) {
        dest.writeInt(mColor);
    }

    @ColorInt
    public int getForegroundColor() {
        return mColor;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(mColor);
        ds.setUnderlineText(false);
    }
}
