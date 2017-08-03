
package dstudio.com.retrofitrxandroid.model.colorresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Code {

    @SerializedName("rgba")
    @Expose
    private String rgba;
    @SerializedName("hex")
    @Expose
    private String hex;

    public String getRgba() {
        return rgba;
    }

    public void setRgba(String rgba) {
        this.rgba = rgba;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

}
