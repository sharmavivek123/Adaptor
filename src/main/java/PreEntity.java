/*
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.netty.util.Mapping;
import io.vertx.core.json.Json;

import java.util.LinkedHashMap;
import java.util.Map;


public class PreEntity {

    private  String oi;
    private String tq;
    private String pd;
    @JsonCreator
    public PreEntity(@JsonProperty("OrderId") String oi,
                     @JsonProperty("TotalQuantity") String tq,
                     @JsonProperty("ProductDescription") String pd) {
        this.oi =oi;
        this.tq = tq;
        this.pd=pd;
    }

    @JsonCreator
    public PreEntity(Map<String,Object> props)
    {
        oi = (String) props.get("OrderId");
        tq = (String) props.get("TotalQuantity");
        pd = (String) props.get("ProductDescription");
    }



    public PreEntity() {
    }

    public String getOrderId() {
        return oi;
    }

    public void setOrderId(String orderId) {
        oi = orderId;
    }

    public String getTotalQuantity() {
        return tq;
    }

    public void setTotalQuantity(String totalQuantity) {
        tq = totalQuantity;
    }

    public String getProductDescription() {
        return pd;
    }
    public void setProductDescription(String productDescription) {

        pd= productDescription;
    }

    @Override
    public String toString() {
        return "PreEntity{" +
                "OrderId='" + oi + '\'' +
                ", TotalQuantity='" + tq + '\'' +
                ", ProductDescription='" + pd + '\'' +
                '}';
    }

}*/
