//import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.Future;
//import io.vertx.core.Vertx;
//import io.vertx.core.json.Json;
//import io.vertx.ext.web.Router;
//import io.vertx.ext.web.RoutingContext;
//import io.vertx.ext.web.handler.BodyHandler;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Service1 extends AbstractVerticle{
//    public static void main(String[] args) {
//        Vertx vertx=Vertx.vertx();
//        vertx.deployVerticle(new Service1());
//    }
//    private Map<String,Name> p1=new LinkedHashMap<>();
//    private void createData(){
//        Name n1=new Name("OrderId","oi");
//        p1.put(n1.getLn(), n1);
//
//        Name n2=new Name("TotalQuantity","tq");
//        p1.put(n2.getLn(), n2);
//
//        Name n3=new Name("ProductDescription","pd");
//        p1.put(n3.getLn(), n3);
//
//
//        }
//
//
//
//
//
//     public String lntosn(String ln){
//         final Name name = p1.get("ln");
//         final String s1 = name.getLn();
//         final String s2 = name.getSn();
//         return s2;
//
//     }
//
//        public String sntoln(String sn){
//            final Name name1 = p1.get("sn");
//            final String sn0 = name1.getLn();
//            final String sn1 = name1.getSn();
//            return sn0;
//
//        }
//
//
// @Override
// public void start(Future<Void> fut) throws Exception{
//        createData();
//     Router router=Router.router(vertx);
//     ObjectMapper objectMapper=new ObjectMapper();
//     router.route("/items").handler(BodyHandler.create());
//     router.post("/items").handler(this::postdata);
//     router.get("/items").handler(this::getdata);
//
//
//     vertx.createHttpServer().requestHandler(router::accept).listen(8681);
// }
//
//    private void getdata(RoutingContext routingContext) {
//
//        routingContext.response()
//                .putHeader("content-type", "application/json; charset=utf-8")
//                .end(Json.encode(p1));
//        System.out.println(Json.encode(p1));
//
//    }
//
//    private void postdata(RoutingContext routingContext) {
//        System.out.println(p1.get("OrderId"));
//
//        String s11=routingContext.getBodyAsString();
//        Name n1=Json.decodeValue(s11,Name.class);
//        Name name=p1.put(n1.getLn(),n1);
//        System.out.println(name);
//        routingContext.response().setStatusCode(200)
//                .putHeader("content-type","application/json; charset=utf-8")
//                .end(Json.encode(name));
//        System.out.println(Json.encode(name));
//
//
//    }
//
//
//
//}
