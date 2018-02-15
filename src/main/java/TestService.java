/*
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.transcoder.JsonTranscoder;
import com.google.gson.*;
//import com.couchbase.client.java.document.json.JsonObject;

import com.sun.org.apache.xpath.internal.SourceTree;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import jdk.nashorn.internal.parser.JSONParser;


import java.util.*;
import java.util.concurrent.TimeUnit;


import java.util.Map;
import java.util.stream.Collectors;


public class TestService extends AbstractVerticle {
StringBuffer shortname;
Integer shortnameinteger;

    Map <String, String> data = new HashMap <> ( );
    Map <String, String> data1 = new HashMap <> ( );
    Map <String, String> data11 = new HashMap <> ( );

    ArrayList <String> list = new ArrayList <> ( );

    Bucket bucket = null;
    //private names names;
    // private names names1;

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx ( );
        vertx.deployVerticle ( new TestService ( ) );
    }

    @Override
    public void start(Future <Void> fut) throws Exception {

        CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder ( )
                //this set the IO socket timeout globally, to 45s
                .socketConnectTimeout ( (int) TimeUnit.SECONDS.toMillis ( 10000 ) )
                //this sets the connection timeout for openBucket calls globally (unless a particular call provides its own timeout)
                .connectTimeout ( TimeUnit.SECONDS.toMillis ( 12000 ) )
                .build ( );

        Cluster cluster = CouchbaseCluster.create ( env , "http://127.0.0.1:8091" );
        bucket = cluster.openBucket ( "default" , "" );
        System.out.println ( "bucket open........" );


        Router router = Router.router ( vertx );
        ObjectMapper objectMapper = new ObjectMapper ( );
        router.route ( "/items" ).handler ( BodyHandler.create ( ) );
        router.post ( "/items" ).handler ( this::postdata );
        router.get ( "/items" ).handler ( this::getdata );
        router.get ( "/" ).handler ( new Handler <RoutingContext> ( ) {
            @Override
            public void handle(RoutingContext routingContext) {
                routingContext.response ( ).end ( "hello............." );
                System.out.println ( "hello" );
            }
        } );
        vertx.createHttpServer ( ).requestHandler ( router::accept ).listen ( 8781 );
    }

    private void getdata(RoutingContext routingContext) {
        String key = null;
        JsonObject jsonObject3 = new JsonObject ( );
        JsonObject r1 = new JsonObject ( );
        N1qlQuery n1qlQuery = N1qlQuery.simple ( "SELECT * FROM default" );
        N1qlQueryResult n1qlQueryResult = this.bucket.query ( n1qlQuery );
        ListIterator <N1qlQueryRow> s2 = n1qlQueryResult.allRows ( ).listIterator ( );
        JsonArray jsonArray = new JsonArray ( );
        while (s2.hasNext ( )) {
            N1qlQueryRow row = (N1qlQueryRow) s2.next ( );
            com.couchbase.client.java.document.json.JsonObject value = row.value ( );
            com.couchbase.client.java.document.json.JsonObject jsonObject = value.getObject ( "default" );

            final Set <String> names = jsonObject.getNames ( );
            System.out.println ( "get all short values in bunch......" + names );
            final Iterator <String> iterator = names.iterator ( );
            while (iterator.hasNext ( )) {
                final String next = iterator.next ( );

                final String sss = data11.get ( next );
                final Object o1 = jsonObject.get ( next );
                Gson gson = new Gson ( );
                final JsonElement jsonElement = gson.toJsonTree ( o1 );
                r1.add ( sss , jsonElement );
            }
            jsonArray.add ( r1 );
        }
        Gson gson = new Gson ( );
        String jsonString = gson.toJson ( jsonArray );
        routingContext.response ( ).setStatusCode ( 200 )
                .putHeader ( HttpHeaders.CONTENT_TYPE , "application/json" )
                .end (jsonString );
    }


    private void postdata(RoutingContext routingContext) {

        String jsonRequestBody = routingContext.getBodyAsString ( );
        System.out.println ( jsonRequestBody );
        JsonObject obj = new JsonParser ( ).parse ( jsonRequestBody ).getAsJsonObject ( );
        System.out.println ( "json object......" );
        System.out.println ( obj );
        final JsonObject jsonObject = toCompressData ( obj );
        System.out.println ( "Converted Data into smaller : " + jsonObject );

        final JsonElement oid = jsonObject.get ( "o0" );
        System.out.println ( "idetrid..............." );
        System.out.println ( oid );
        final String idcouch = oid.toString ( );
        System.out.println ( idcouch );

        JsonDocument document = JsonDocument.create ( idcouch ,
                com.couchbase.client.java.document.json.JsonObject.fromJson ( jsonObject.toString ( ) ) );

        bucket.upsert ( document );

        routingContext.response ( ).end ( "Working" );
    }

    private void rawJsonDocument(String idcouch , JsonObject jsonObject) {
    }


    public RawJsonDocument put(final String key , final JsonObject googleJsonObject) {
        return bucket.upsert ( RawJsonDocument.create ( key , googleJsonObject.toString ( ) ) );
    }


    public JsonObject toCompressData(JsonObject jsonObject) {
        int counter=0;
        String s,s2;
        jsonObject.getAsJsonObject ( );
        JsonObject renderJsonObject = new JsonObject ( );
        final Set <String> keySets = jsonObject.keySet ( );
        Iterator <String> iterator = keySets.iterator ( );

        ArrayList list = new ArrayList ( );

        while (iterator.hasNext ( )) {

         String s1=iterator.next ();//full form name---------------

                 s = s1.substring(0, 1);
                int nu = counter++;
                s2 = s+ nu;
                System.out.println(s2);

                data.put ( s1 , s2);
                data11.put ( s2 , s1 );
                renderJsonObject.add ( s2 , jsonObject.get ( s1 ) );



            */
/*String s1 = iterator.next ( );
            System.out.println ( "full..................." );
            System.out.println ( s1 );
            String s2 = s1.substring ( 0 , 2 );
            String s3 = s1.substring ( s1.length ( ) - 1);
            String s4 = s2.concat ( s3 );
            System.out.println ( "short................." );
            System.out.println ( s4 );
            data.put ( s1 , s4 );
            data11.put ( s4 , s1 );*//*


            */
/*final JsonElement jsonElement = jsonObject.get ( s1 );
            System.out.println ("7&&&&&&&&&&&&&&&&&&&&&&&&&&" );
            System.out.println (jsonElement );*//*


        }
        System.out.println ("---------------------" );
        System.out.println (data );

        return renderJsonObject;

    }

}





































*/
/*






import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
        import com.couchbase.client.java.Bucket;
        import com.couchbase.client.java.Cluster;
        import com.couchbase.client.java.CouchbaseCluster;
        import com.couchbase.client.java.document.JsonDocument;
        import com.couchbase.client.java.document.RawJsonDocument;
        import com.couchbase.client.java.env.CouchbaseEnvironment;
        import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
        import com.couchbase.client.java.query.N1qlQuery;
        import com.couchbase.client.java.query.N1qlQueryResult;
        import com.couchbase.client.java.query.N1qlQueryRow;
        import com.couchbase.client.java.transcoder.JsonTranscoder;
        import com.google.gson.Gson;
        import com.google.gson.JsonElement;
        import com.google.gson.JsonObject;
        import com.google.gson.JsonDeserializationContext;
//import com.couchbase.client.java.document.json.JsonObject;

        import com.google.gson.JsonParser;
        import com.sun.org.apache.xpath.internal.SourceTree;
        import io.vertx.core.AbstractVerticle;
        import io.vertx.core.Future;
        import io.vertx.core.Handler;
        import io.vertx.core.Vertx;
        import io.vertx.core.http.HttpHeaders;
        import io.vertx.core.json.Json;
        import io.vertx.core.json.JsonArray;
        import io.vertx.ext.web.Router;
        import io.vertx.ext.web.RoutingContext;
        import io.vertx.ext.web.handler.BodyHandler;
        import jdk.nashorn.internal.parser.JSONParser;


        import java.util.*;
        import java.util.concurrent.TimeUnit;


        import java.util.Map;
        import java.util.stream.Collectors;


public class TestService extends AbstractVerticle{


    Map<String ,String> data=new HashMap<>();
    Map<String,String>data1=new HashMap <> ( );
    Map<String,String>data11=new HashMap <> ( );

    ArrayList<String> list=new ArrayList <>();

    Bucket bucket=null;
    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx();
        vertx.deployVerticle(new TestService());
    }

    @Override
    public void start(Future<Void> fut) throws Exception{

        CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
                //this set the IO socket timeout globally, to 45s
                .socketConnectTimeout((int) TimeUnit.SECONDS.toMillis(10000))
                //this sets the connection timeout for openBucket calls globally (unless a particular call provides its own timeout)
                .connectTimeout(TimeUnit.SECONDS.toMillis(12000))
                .build();

        Cluster cluster= CouchbaseCluster.create(env,"http://127.0.0.1:8091");
        bucket=cluster.openBucket("default","" );
        System.out.println("bucket open........");


        Router router=Router.router(vertx);
        ObjectMapper objectMapper=new ObjectMapper();
        router.route("/items").handler(BodyHandler.create());
        router.post("/items").handler(this::postdata);
        router.get("/items").handler(this::getdata);
        router.get("/").handler(new Handler<RoutingContext>() {
            @Override
            public void handle(RoutingContext routingContext) {
                routingContext.response().end("hello.............");
                System.out.println("hello");
            }
        });
        vertx.createHttpServer().requestHandler(router::accept).listen(8781);
    }

    private void getdata(RoutingContext routingContext) {
        String key=null;
        JsonObject jsonObject3=new JsonObject();
        JsonObject r1=new JsonObject ();
        N1qlQuery n1qlQuery = N1qlQuery.simple("SELECT * FROM default");
        N1qlQueryResult n1qlQueryResult = this.bucket.query(n1qlQuery);
        ListIterator<N1qlQueryRow> s2 = n1qlQueryResult.allRows().listIterator();
        JsonArray jsonArray = new JsonArray();

        while(s2.hasNext()) {

            N1qlQueryRow row = (N1qlQueryRow)s2.next();
            com.couchbase.client.java.document.json.JsonObject value = row.value();
            com.couchbase.client.java.document.json.JsonObject jsonObject = value.getObject("default");
            System.out.println("value----------------------" + jsonObject);
            final Set <String> names = jsonObject.getNames();

            final Iterator <String> iterator = names.iterator();
            while(iterator.hasNext()){
                final String next = iterator.next();
                final String sss = data11.get ( next );
                final Object o1 = jsonObject.get ( next );
                //Here we need JsonElement-------
                Gson gson=new Gson ();
                final JsonElement jsonElement = gson.toJsonTree ( o1 );

                r1.add(sss, jsonElement );
            }
            System.out.println (r1 );
   *//*

*/
/* JsonArray jsonArray1=new JsonArray (  );
            jsonArray1.add ( r1 );
           System.out.println (jsonArray1 );*//*
*/
/*

        }
       Gson gson = new Gson();
        String jsonString = gson.toJson(jsonArray);
        routingContext.response().setStatusCode(200)
                .putHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .end(r1.toString ());
    }


    private void postdata(RoutingContext routingContext) {

        String jsonRequestBody=routingContext.getBodyAsString();
        System.out.println(jsonRequestBody);
        JsonObject obj = new JsonParser().parse(jsonRequestBody).getAsJsonObject();
        final JsonObject jsonObject = toCompressData(obj);

        final JsonElement oid = jsonObject.get("od");
        final String idcouch = oid.toString();
         JsonDocument document = JsonDocument.create(idcouch,
                com.couchbase.client.java.document.json.JsonObject.fromJson(jsonObject.toString()));

        bucket.upsert(document);

        routingContext.response().end("Working");
    }

    private void rawJsonDocument(String idcouch, JsonObject jsonObject) {
    }


    public RawJsonDocument put(final String key, final JsonObject  googleJsonObject) {
        return bucket.upsert(RawJsonDocument.create(key, googleJsonObject.toString()));
    }



    public JsonObject toCompressData(JsonObject jsonObject){
        jsonObject.getAsJsonObject();
        JsonObject renderJsonObject=new JsonObject();
        final Set<String> keySets = jsonObject.keySet();
        Iterator<String> iterator=keySets.iterator();

        ArrayList list=new ArrayList();

        while(iterator.hasNext()){

            String s1=iterator.next();
            System.out.println("full...................");
            System.out.println(s1);
            String s2=s1.substring(0,1);
            String s3=s1.substring(s1.length()-1);
            String s4=s2.concat(s3);
            System.out.println("short.................");
            System.out.println(s4);
            data.put(s1,s4);
            data11.put ( s4,s1 );
            renderJsonObject.add(s4,jsonObject.get(s1));
        }
        return renderJsonObject;

    }

}

*//*







*/
