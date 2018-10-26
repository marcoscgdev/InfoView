package com.marcoscg.infoview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by marco on 02/10/2017.
 */

public class InfoView extends RelativeLayout {

    private TextView title, message;
    private ImageView image;
    private Button tryAgain;

    private OnTryAgainClickListener onTryAgainClickListener;

    public interface OnTryAgainClickListener {
        public void onTryAgainClick();
    }

    public InfoView(Context context) {
        super(context);
        init(null, 0);
    }

    public InfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public InfoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public InfoView setTitle(String title) {
        if (this.title != null)
            this.title.setText(title);
        return this;
    }

    public InfoView setTitleRes(@StringRes int titleRes) {
        if (this.title != null)
            this.title.setText(getStr(titleRes));
        return this;
    }

    public InfoView setMessage(String message) {
        if (this.message != null)
            this.message.setText(message);
        return this;
    }

    public InfoView setMessageRes(@StringRes int messageRes) {
        if (this.message != null)
            this.message.setText(getStr(messageRes));
        return this;
    }

    public InfoView setIconDrawable(Drawable iconDrawable) {
        if (this.image != null)
            this.image.setImageDrawable(iconDrawable);
        return this;
    }

    public InfoView setIconBitmap(Bitmap iconBitmap) {
        if (this.image != null)
            this.image.setImageBitmap(iconBitmap);
        return this;
    }

    public InfoView setIconRes(@DrawableRes int iconRes) {
        if (this.image != null)
            this.image.setImageResource(iconRes);
        return this;
    }

    public InfoView setButtonText(String buttonText) {
        if (this.tryAgain != null)
            this.tryAgain.setText(buttonText);
        return this;
    }

    public InfoView setButtonTextRes(@StringRes int buttonTextRes) {
        if (this.tryAgain != null)
            this.tryAgain.setText(getStr(buttonTextRes));
        return this;
    }

    public InfoView setButtonTextColor(@ColorInt int textColor) {
        if (this.tryAgain != null)
            this.tryAgain.setTextColor(textColor);
        return this;
    }

    public InfoView setButtonTextColorRes(@ColorRes int textColor) {
        if (this.tryAgain != null)
            this.tryAgain.setTextColor(ContextCompat.getColor(getContext(), textColor));
        return this;
    }

    public InfoView setOnTryAgainClickListener(OnTryAgainClickListener listener) {
        onTryAgainClickListener = listener;
        return this;
    }

    public InfoView setProgress(boolean setProgress) {
        if (setProgress) {
            findViewById(R.id.iv_container).setVisibility(INVISIBLE);
            findViewById(R.id.iv_progress_bar).setVisibility(VISIBLE);
        } else {
            findViewById(R.id.iv_container).setVisibility(VISIBLE);
            findViewById(R.id.iv_progress_bar).setVisibility(GONE);
        }
        return this;
    }

    public InfoView setShowButton(boolean showButton) {
        if (showButton)
            tryAgain.setVisibility(VISIBLE);
        else tryAgain.setVisibility(GONE);

        return this;
    }

    private void init(AttributeSet attrs, int defStyle) {
        inflate(getContext(), R.layout.info_view_layout, this);
        title = (TextView) findViewById(R.id.iv_title);
        message = (TextView) findViewById(R.id.iv_message);
        image = (ImageView) findViewById(R.id.iv_image);
        tryAgain = (Button) findViewById(R.id.iv_try_again);
        tryAgain.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTryAgainClickListener!=null)
                    onTryAgainClickListener.onTryAgainClick();
            }
        });

        if (attrs != null) {
            String title = "", message = "", buttonText = "";
            Drawable icon = null;
            int buttonTextColor = 0;
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.InfoView, defStyle, 0);
            try {
                title = a.getString(R.styleable.InfoView_iv_title);
                message = a.getString(R.styleable.InfoView_iv_message);
                icon = a.getDrawable(R.styleable.InfoView_iv_icon);
                buttonText = a.getString(R.styleable.InfoView_iv_buttonText);
                buttonTextColor = a.getColor(R.styleable.InfoView_iv_buttonTextColor, 0);
                setShowButton(a.getBoolean(R.styleable.InfoView_iv_showButton, true));
            } finally {
                a.recycle();
            }
            this.title.setText(title);
            this.message.setText(message);
            if (icon != null)
                this.image.setImageDrawable(icon);
            this.tryAgain.setText(buttonText);
            if (buttonTextColor != 0) {
                this.tryAgain.setTextColor(buttonTextColor);
            }
        }
    }

    private String getStr (@StringRes int resId) {
        return getContext().getResources().getString(resId);
    }
}