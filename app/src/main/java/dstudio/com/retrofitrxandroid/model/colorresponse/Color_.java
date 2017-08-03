
package dstudio.com.retrofitrxandroid.model.colorresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color_ {

    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("code")
    @Expose
    private Code code;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

}
