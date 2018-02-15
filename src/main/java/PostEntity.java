//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jdk.nashorn.internal.ir.annotations.Ignore;
//
//import java.util.Map;
//
//
//public class PostEntity {
//    private  String OrderIdaa;
//    private String TotalQuantity;
//  private String ProductDescription;
//    @Ignore
//
//
//
//    @JsonCreator
//    public PostEntity(Map<String,Object> props)
//
//    {
//         OrderId= (String) props.get("oi");
//
//        TotalQuantity= (String) props.get("tq");
//        ProductDescription= (String) props.get("pd");
//    }
//
//
//    public PostEntity() {
//    }
//
//    public String getoi() {
//        return OrderId;
//    }
//
//    public void setoi(String oi) {
//        OrderId = oi;
//    }
//
//
//
//    public String gettq() {
//        return TotalQuantity;
//    }
//
//    public void settq(String tq) {
//        TotalQuantity=tq;
//    }
//
//
//    public String getpd(){
//        return ProductDescription;
//    }
//    public String setpd(String pd){
//        return ProductDescription;
//    }
//
//
//    @Override
//    public String toString() {
//        return "PreEntity{" +
//                "OrderId='" + OrderId + '\'' +
//                ", TotalQuantity='" + TotalQuantity + '\'' +
//                ", ProductDescription='" + ProductDescription + '\'' +
//                '}';
//    }
//
//
//}