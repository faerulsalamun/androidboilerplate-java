package id.web.faerul.boilerplate.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import id.web.faerul.boilerplate.BoilerplateApplication;
import id.web.faerul.boilerplate.injection.component.ConfigPersistentComponent;
import id.web.faerul.boilerplate.injection.component.DaggerConfigPersistentComponent;
import id.web.faerul.boilerplate.injection.component.FragmentComponent;
import id.web.faerul.boilerplate.injection.module.FragmentModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import timber.log.Timber;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 10/16/16.
 */

public abstract class BaseFragment extends Fragment {

  private static final String KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID";
  private static final AtomicLong NEXT_ID = new AtomicLong(0);
  private static final Map<Long, ConfigPersistentComponent> sComponentsMap = new HashMap<>();

  protected Activity mActivity;
  private FragmentComponent mFragmentComponent;
  private long mFragmentId;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Create the ActivityComponent and reuses cached ConfigPersistentComponent if this is
    // being called after a configuration change.
    mFragmentId = savedInstanceState != null ? savedInstanceState.getLong(KEY_FRAGMENT_ID)
        : NEXT_ID.getAndIncrement();
    ConfigPersistentComponent configPersistentComponent;
    if (!sComponentsMap.containsKey(mFragmentId)) {
      Timber.i("Creating new Fragment ConfigPersistentComponent id=%d", mFragmentId);
      configPersistentComponent = DaggerConfigPersistentComponent.builder()
          .applicationComponent(BoilerplateApplication.get(getActivity()).getComponent())
          .build();
      sComponentsMap.put(mFragmentId, configPersistentComponent);
    } else {
      Timber.i("Reusing Fragment ConfigPersistentComponent id=%d", mFragmentId);
      configPersistentComponent = sComponentsMap.get(mFragmentId);
    }
    mFragmentComponent =
        configPersistentComponent.fragmentComponent(new FragmentModule(getActivity()));
    mActivity = getActivity();
  }

  public FragmentComponent getFragmentComponent() {
    return mFragmentComponent;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayout(), container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  protected abstract @LayoutRes int getLayout();

  @Override public void onDestroy() {
    Timber.i("Clearing Fragment ConfigPersistentComponent id=%d", mFragmentId);
    sComponentsMap.remove(mFragmentId);
    super.onDestroy();
  }
}
