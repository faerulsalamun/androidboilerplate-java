package id.web.faerul.boilerplate.util.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.web.faerul.boilerplate.R;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 10/13/16.
 */

public class TitleBar extends RelativeLayout {
  @BindView(R.id.titlebar_title) TextView mTxtTitle;
  @BindView(R.id.titlebar_action_button) ImageButton mActionButton;
  @BindView(R.id.titlebar_action_right_button) ImageButton mRightActionButton;

  public TitleBar(Context context) {
    this(context, null);
  }

  public TitleBar(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();

    if (isInEditMode()) return;

    TypedArray typedArray =
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.TitleBar, 0, 0);
    int src = typedArray.getResourceId(R.styleable.TitleBar_src, 0);
    int rightSrc = typedArray.getResourceId(R.styleable.TitleBar_rightSrc, 0);

    mTxtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

    if (src != 0) mActionButton.setImageResource(src);
    if (rightSrc != 0) {
      mRightActionButton.setImageResource(rightSrc);
      mRightActionButton.setVisibility(View.VISIBLE);
    }
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.custom_view_title_bar, this, true);
    if (isInEditMode()) return;
    ButterKnife.bind(this);
  }

  public void setTitle(@StringRes int resId) {
    mTxtTitle.setText(resId);
  }

  public void setTitle(String title) {
    mTxtTitle.setText(title);
  }

  public void setTitleTextSize(float size) {
    mTxtTitle.setTextSize(size);
  }

  public void setImageButton(int image) {
    mActionButton.setImageResource(image);
  }

  public void setImageRightButton(int image) {
    mRightActionButton.setImageResource(image);
  }

  public void setOnActionButtonClick(OnClickListener onActionButtonClick) {
    mActionButton.setOnClickListener(onActionButtonClick);
  }

  public void setSecondaryActionClick(OnClickListener secondaryActionClick) {
    mRightActionButton.setOnClickListener(secondaryActionClick);
  }
}
