package dstudio.com.retrofitrxandroid.viewmodel.view;

import dstudio.com.retrofitrxandroid.model.colorresponse.Colors;
import eu.inloop.viewmodel.IView;

/**
 * Created by janwelcris on 8/3/2017.
 */

public interface IUColorView extends IView{
    void getColorsData(Colors colors);

    void showloading(float progress);
    void hideProgress();
}
