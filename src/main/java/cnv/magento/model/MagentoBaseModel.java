/**
 *
 * @author Rohit Shinde @Canvass
 * 13 Jan, 2016
 */
package cnv.magento.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MagentoBaseModel implements Serializable {

    @SerializedName(value = "entity_id")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}