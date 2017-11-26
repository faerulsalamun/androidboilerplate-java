package id.web.faerul.boilerplate.ui.main;

import id.web.faerul.boilerplate.data.model.Ribot;
import id.web.faerul.boilerplate.ui.base.MvpView;
import java.util.List;

public interface MainMvpView extends MvpView {

  void showRibots(List<Ribot> ribots);

  void showRibotsEmpty();

  void showError(String message);
}
