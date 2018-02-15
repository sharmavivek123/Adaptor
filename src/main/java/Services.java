//import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
//import com.couchbase.client.java.Bucket;
//import com.couchbase.client.java.Cluster;
//import com.couchbase.client.java.CouchbaseCluster;
//import com.couchbase.client.java.document.JsonDocument;
//import com.couchbase.client.java.document.json.JsonObject;
//import com.couchbase.client.java.env.CouchbaseEnvironment;
//import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
//import com.couchbase.client.java.query.N1qlQuery;
//import com.couchbase.client.java.query.N1qlQueryResult;
//import com.couchbase.client.java.query.N1qlQueryRow;
//import com.couchbase.client.java.transcoder.JsonTranscoder;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.Future;
//import io.vertx.core.Vertx;
//import io.vertx.core.http.HttpHeaders;
//import io.vertx.core.http.HttpServer;
//import io.vertx.core.http.HttpServerResponse;
//import io.vertx.core.json.Json;
//import io.vertx.ext.web.Router;
//import io.vertx.ext.web.RoutingContext;
//import io.vertx.ext.web.handler.BodyHandler;
//
//import java.sql.Array;
//import java.util.LinkedHashMap;
//import java.util.ListIterator;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//
//public class Services extends AbstractVerticle {
//    /*CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder().connectTimeout(10000L).kvTimeout(3000L).build();
//    Cluster cluster;
//    Bucket bucket;
//    Router router;
//
//    public Services() {
//        this.cluster = CouchbaseCluster.create(this.env, new String[]{
//                "localhost"});
//        this.bucket = this.cluster.openBucket("default");
//
//        this.router = Router.router(this.vertx);
//    }*/
//
//    public static void main(String[] args) {
//        Vertx vertx = Vertx.vertx();
//        vertx.deployVerticle(new Services());
//    }
//    public Map<String,Name> p1=new LinkedHashMap<>();
//    private void createData(){
//        Name n1=new Name("OrderId","oi");
//        p1.put(n1.getLn(), n1);
//
//        Name n2=new Name("TotalQuantity","tq");
//        p1.put(n2.getLn(), n2);
//
//        Name n3=new Name("ProductDescription","pd");
//        p1.put(n3.getLn(), n3);
//    }
//
//    class Test{
//
//
//
//
//
//
//
//
//    }
//
//
//
//    public void start(Future<Void> fut) throws Exception {
//
//        CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
//                //this set the IO socket timeout globally, to 45s
//                .socketConnectTimeout((int) TimeUnit.SECONDS.toMillis(10000))
//                //this sets the connection timeout for openBucket calls globally (unless a particular call provides its own timeout)
//                .connectTimeout(TimeUnit.SECONDS.toMillis(12000))
//                .build();
//        Cluster cluster= CouchbaseCluster.create(env,"http://127.0.0.1:8091");
//       Bucket bucket=cluster.openBucket("default","password" );
//        System.out.println("bucket open........");
//        JsonObject products=JsonObject.create();
//        JsonDocument document=JsonDocument.create("cb2",products);
//        Router router = Router.router(vertx);
//
//        ObjectMapper objectMapper=new ObjectMapper();
//
//
//        router.route("/assets/all").handler(BodyHandler.create());
//
//
//        router.post("/assets/all").handler(this::postpro);
//        router.get("/assets/all").handler(this::getAll);
//        vertx
//                .createHttpServer()
//                .requestHandler(router::accept)
//                .listen(
//                        // Retrieve the port from the configuration,
//                        // default to 8080.
//                        8972,
//                        result -> {
//                            if (result.succeeded()) {
//                                fut.complete();
//                            } else {
//                                fut.fail(result.cause());
//                            }
//                        }
//                );
//
//
///*
//        this.router.route("/post").handler(BodyHandler.create());
//        this.router.post("/post").handler(this::postpro);
//        this.router.get("/get").handler(this::getAll);
//        HttpServer var10000 = this.vertx.createHttpServer();
//        Router var10001 = this.router;
//        this.router.getClass();
//        var10000.requestHandler(var10001::accept).listen(8888);*/
//    }
//
//    Bucket bucket=null;
//
//    void postpro(RoutingContext rc) {
//        System.out.println(rc.getBodyAsString());
//
//        Name name=(Name)Json.decodeValue(rc.getBody(),Name.class);
//
//        PreEntity preEntity = (PreEntity) Json.decodeValue(rc.getBody(), PreEntity.class);
//        System.out.println("value----------" + preEntity);
//        String body = rc.getBodyAsString();
//        System.out.println(body);
//        Gson gson = new Gson();
//        String id = preEntity.getOrderId();
//        String jsonobj = gson.toJson(preEntity);
//        System.out.println("----------------------");
//        System.out.println(jsonobj);
//        JsonDocument jsonDocument = null;
//
//        try {
//            jsonDocument = JsonDocument.create(id, (new JsonTranscoder()).stringToJsonObject(jsonobj));
//            System.out.println(jsonDocument);
//        } catch (Exception var9) {
//            var9.printStackTrace();
//        }
//
//         bucket.upsert(jsonDocument);
//        rc.response().setStatusCode(200).putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(preEntity));
//    }
//
//    public void getAll(RoutingContext rc) {
//        N1qlQuery n1qlQuery = N1qlQuery.simple("SELECT * FROM default");
//        N1qlQueryResult n1qlQueryResult = this.bucket.query(n1qlQuery);
//        String s = n1qlQueryResult.allRows().toString();
//        System.out.println(s);
//        ListIterator<N1qlQueryRow> s2 = n1qlQueryResult.allRows().listIterator();
//        System.out.println(s2);
//        JsonArray jsonArray = new JsonArray();
//
//        while(s2.hasNext()) {
//            System.out.println(s2.hasNext());
//            N1qlQueryRow row = (N1qlQueryRow)s2.next();
//            System.out.println(row);
//            JsonObject value = row.value();
//            System.out.println(value);
//            JsonObject jsonObject = value.getObject("default");
//            System.out.println("value----------------------" + jsonObject);
//            PostEntity postEntity = (PostEntity)Json.decodeValue(jsonObject.toString(), PostEntity.class);
//            System.out.println("java object-----------");
//            System.out.println(postEntity);
//            Gson gson = new Gson();
//            String id = postEntity.getoi();
//            String jsonobj = gson.toJson(postEntity);
//            System.out.println("============json object==========");
//            System.out.println(jsonobj);
//            jsonArray.add(jsonobj);
//        }
//
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(jsonArray);
//        rc.response().setStatusCode(200).putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(jsonString);
//    }
//}
