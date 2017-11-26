package id.web.faerul.boilerplate.util.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.web.faerul.boilerplate.R;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 10/13/16.
 */

public class CustomToolbar extends Toolbar {

  @BindView(R.id.text_title) TextView mTxtTitle;
  @BindView(R.id.image_button_left) ImageButton mActionButton;
  @BindView(R.id.image_button_right) ImageButton mRightActionButton;
  @BindView(R.id.image_button_right_two) ImageButton mRightActionButtonTwo;
  @BindView(R.id.text_right) TextView mTextRight;
  @BindView(R.id.text_title_left) TextView mTextTitleLeft;

  public CustomToolbar(Context context) {
    this(context, null);
  }

  public CustomToolbar(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();

    if (isInEditMode()) return;

    TypedArray typedArray =
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.TitleBar, 0, 0);
    int src = typedArray.getResourceId(R.styleable.TitleBar_src, 0);
    int rightSrc = typedArray.getResourceId(R.styleable.TitleBar_rightSrc, 0);

    mTxtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    mTextTitleLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

    if (src != 0) mActionButton.setImageResource(src);
    if (rightSrc != 0) {
      mRightActionButton.setImageResource(rightSrc);
      mRightActionButton.setVisibility(View.VISIBLE);
    }
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.custom_toolbar, this, true);
    if (isInEditMode()) return;
    ButterKnife.bind(this);
  }

  public void setTitle(@StringRes int resId) {
    mTxtTitle.setText(resId);
  }

  public void setTitle(String title) {
    mTxtTitle.setText(title);
  }

  public void setTitleRight(@StringRes int resId) {
    mTxtTitle.setVisibility(GONE);
    mTextTitleLeft.setText(resId);
  }

  public void setTitleRight(String resId) {
    mTxtTitle.setVisibility(GONE);
    mTextTitleLeft.setText(resId);
  }

  public void setTextRight(@StringRes int resId) {
    mTextRight.setText(resId);
  }

  public void setTextRight(String title) {
    mTextRight.setText(title);
  }

  public void setTitleTextSize(float size) {
    mTxtTitle.setTextSize(size);
  }

  public void setImageButton(int image) {
    mActionButton.setImageResource(image);
  }

  public void setImageRightButton(int image) {
    mRightActionButton.setVisibility(VISIBLE);
    mRightActionButton.setImageResource(image);
  }

  public void setImageRightButtonTwo(int image) {
    mRightActionButtonTwo.setVisibility(VISIBLE);
    mRightActionButtonTwo.setImageResource(image);
  }

  public void setImageRightButtonTwoOnClickListener(OnClickListener onActionButtonClick) {
    mRightActionButtonTwo.setOnClickListener(onActionButtonClick);
  }

  public void setOnActionButtonClick(OnClickListener onActionButtonClick) {
    mActionButton.setOnClickListener(onActionButtonClick);
  }

  public void setOnActionTextRightClick(OnClickListener onActionButtonClick) {
    mTextRight.setOnClickListener(onActionButtonClick);
  }

  public void setSecondaryActionClick(OnClickListener secondaryActionClick) {
    mRightActionButton.setOnClickListener(secondaryActionClick);
  }

  public void setTextTitleSize(int size) {
    mTxtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
  }

  public void setTextTitleCaps(boolean active) {
    mTxtTitle.setAllCaps(active);
  }

  public void setTextTitleColor(Context context, int color) {
    mTxtTitle.setTextColor(ContextCompat.getColor(context, color));
  }
}
