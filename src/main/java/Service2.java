import io.vertx.core.AbstractVerticle;
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
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;


import java.util.*;
import java.util.concurrent.TimeUnit;


import java.util.Map;
import java.util.stream.Collectors;


public class Service2 extends AbstractVerticle {
    /*Mapping mapping=new Mapping ();
    Map<String,String> p1=new HashMap <> (  );
*/
    BidiMap<String,String> p1 = new DualHashBidiMap<> ();
    Bucket bucket = null;
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx ( );
        vertx.deployVerticle ( new Service2 ( ) );
    }

    @Override
    public void start(Future <Void> fut) throws Exception {



        p1.put("on","orderNumber");
        p1.put("son","shortOrderNumber");
        p1.put("cn","customerNumber");
        p1.put("dd","deliveryDate");
        p1.put("van","vanNumber");
        p1.put("csn","customerSupportNumber");
        p1.put("si","storeId");
        p1.put("ot","orderType");
        p1.put("os","orderStatus");
        p1.put("iso","isStoredOrder");
        p1.put("icls","isCorelineSubstituted");
        p1.put("tvn","tescoVoucherName");
        p1.put("tepn","tescoEPurseName");
        p1.put("vpn","voucherPromotionName");
        p1.put("pi","productId");
        p1.put("pt","productType");
        p1.put("pd","productDescription");
        p1.put("pq","productQuantity");
        p1.put("pup","productUnitPrice");
        p1.put("ptp","productTotalPrice");
        p1.put("psg","productSubGroup");
        p1.put("pz","pickingZone");
        p1.put("iafv","isApplicableForVat");
        p1.put("ub","useBy");
        p1.put("oli","orderLineId");
        p1.put("pn","promotionName");
        p1.put("opi","orderedProductId");
        p1.put("opt","orderedProductType");
        p1.put("ops","orderedProductSubgroup");
        p1.put("opz","orderedPickingZone");
        p1.put("opd","orderedProductDescription");
        p1.put("opq","orderedProductQuantity");
        p1.put("opaup","orderedProductActualUnitPrice");
        p1.put("opptp","orderedProductPromoTotalPrice");
        p1.put("pip","productIdProvided");
        p1.put("ppt","productProvidedType");
        p1.put("pps","productProvidedSubgroup");
        p1.put("pppz","productProvidedPickingZone");
        p1.put("ppiaf","productProvidedIsApplicableForVat");
        p1.put("ppd","productProvidedDescription");
        p1.put("ppq","productProvidedQuantity");
        p1.put("ppaup","productProvidedActualUnitPrice");
        p1.put("ppatp","productProvidedActualTotalPrice");
        p1.put("pppup","productProvidedPromoUnitPrice");
        p1.put("pmr","priceMatchRefunds");
        p1.put("ies","isEssentialSubstitution");
        p1.put("pppc","prePromotionProductCost");
        p1.put("ps","promotionalSavings");
        p1.put("sc","serviceCharge");
        p1.put("tc","totalCost");
        p1.put("pcd","privilegeCardDiscount");
        p1.put("cvc","computerVoucherCount");
        p1.put("pcn","paymentCardNumber");
        p1.put("pced","paymentCardExpiryDate");
        p1.put("pct","paymentCardType");
        p1.put("vn","vatNumber");
        p1.put("vp","vatPercentage");
        p1.put("cbc","carrierBagCharge");
        p1.put("mbc","minimumBasketCharge");
        p1.put("pspd","promotionDescription");
        p1.put("pp","promotionPrice");
        p1.put("rp","regularPoints");
        p1.put("gp","greenPoints");
        p1.put("tp","totalPoints");
        p1.put("tptd","totalPointsTillDate");
        p1.put("ccd","clubCardDigits");
        p1.put("dsst","deliverySlotStartTime");
        p1.put("dset","deliverySlotEndTime");
        p1.put("t","title");
        p1.put("fn","firstName");
        p1.put("mn","middleName");
        p1.put("ln","lastName");
        p1.put("add","address");
        p1.put("pc","postalCodes");
        p1.put("dtpn","daytimePhoneNumber");
        p1.put("epn","eveningPhoneNumber");
        p1.put("mob","mobileNumber");
        p1.put("pio","productId");
        p1.put("pdo","productDescription");
        p1.put("q","quantity");
        p1.put("icrs","isCustomerRequestedSubstitution");
        p1.put("ec","eCoupon");
        p1.put("cc","currencyCode");
        p1.put("cs","currencySymbol");
        p1.put("picb","productIdcb");
        p1.put("pdcb","productDescriptioncb");
        p1.put("pupcb","productUnitPricecb");
        p1.put("piffc","productIdffc");
        p1.put("pdffc","productDescriptionffc");
        p1.put("pupffc","productUnitPriceffc");
        p1.put("psgffc","productSubGroup");
        p1.put("ost","orderState");
        p1.put("fs","fulfilmentState");





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
        vertx.createHttpServer ( ).requestHandler ( router::accept ).listen ( 8681 );
    }

    private void postdata(RoutingContext routingContext) {

        String jsonRequestBody = routingContext.getBodyAsString ( );
        System.out.println ( jsonRequestBody );
        JsonObject obj = new JsonParser ( ).parse ( jsonRequestBody ).getAsJsonObject ( );
        System.out.println ( "json object......" );
        System.out.println ( obj );
        final JsonObject jsonObject = toCompressData ( obj );
        System.out.println ( "Converted Data into smaller : " + jsonObject );

        final JsonElement oid = jsonObject.get ( "pi" );
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
        String key=null;
        jsonObject.getAsJsonObject ( );
        JsonObject renderJsonObject = new JsonObject ( );
        final Set <String> keySets = jsonObject.keySet ( );
        Iterator <String> iterator = keySets.iterator ( );

        ArrayList list = new ArrayList ( );

        while (iterator.hasNext ( )) {

            String s1=iterator.next ();//full form name---------------

            System.out.println ("*************777777777777777777********" );
            System.out.println (s1 );

            String o = p1.getKey (s1);
//            String o2 = p1.get (o);
            System.out.println ("*************************" );
//            System.out.println (o );
//            System.out.println (o2 );

            renderJsonObject.add (o.toString (), jsonObject.get ( s1 ) );
        }

        return renderJsonObject;

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

                final Object sss = p1.getKey ( next );

                final Object o1 = jsonObject.get ( next );
                Gson gson = new Gson ( );
                final JsonElement jsonElement = gson.toJsonTree ( o1 );
               // r1.add ( sss , jsonElement );
            }
            jsonArray.add ( r1 );
        }
        Gson gson = new Gson ( );
        String jsonString = gson.toJson ( jsonArray );
        routingContext.response ( ).setStatusCode ( 200 )
                .putHeader ( HttpHeaders.CONTENT_TYPE , "application/json" )
                .end (jsonString );
    }






}
