/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/**
 *
 * @author Owner
 */
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