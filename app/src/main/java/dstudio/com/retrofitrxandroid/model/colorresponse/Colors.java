
package dstudio.com.retrofitrxandroid.model.colorresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Colors {

    @SerializedName("colors")
    @Expose
    private List<Color_> colors = null;

    public List<Color_> getColors() {
        return colors;
    }

    public void setColors(List<Color_> colors) {
        this.colors = colors;
    }

}
