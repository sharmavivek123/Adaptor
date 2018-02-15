//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.collect.BiMap;
//import com.google.common.collect.HashBiMap;
//import com.google.gson.JsonObject;
//import org.apache.commons.collections.BidiMap;
//import org.apache.commons.collections.bidimap.DualHashBidiMap;
//import org.apache.commons.collections.bidimap.UnmodifiableBidiMap;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import sun.misc.IOUtils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Converter {
//
//
//
//
//
//
//    static final Map<String,String> map=new HashMap <> (  );
//    private Converter(JsonObject jsonObject){
//
//    }
//
//    public static void main(String[] args) {
//
//       /* BidiMap stateCodeToDescription = new DualHashBidiMap ();
//        stateCodeToDescription.put ( "oi","orderId" );
//
//        System.out.println (stateCodeToDescription.getKey ( "oi" ) );//null
//        System.out.println (stateCodeToDescription.get ( "oi" ) );//orderid
//        System.out.println ("-----------------" );
//        System.out.println (stateCodeToDescription.getKey ( "orderId" ) );//oi
//        System.out.println (stateCodeToDescription.get ( "orderId" ) );//null
//
//*/
//String json = "{\n" +
//        "  \"orderDetails\": {\n" +
//        "    \"orderNumber\": \"367388519\",\n" +
//        "    \"shortOrderNumber\": \"8647\",\n" +
//        "    \"customerNumber\": \"983e8d27-74da-40e0-8994-b1f8398f2bcf\",\n" +
//        "    \"deliveryDate\": \"01/11/2017\",\n" +
//        "    \"vanNumber\": \"2L\",\n" +
//        "    \"customerSupportNumber\": \"0800 323 4040\",\n" +
//        "    \"storeId\": \"9165\",\n" +
//        "    \"orderType\": \"Delivery\",\n" +
//        "    \"orderStatus\": \"Checked Out\",\n" +
//        "    \"isStoredOrder\": \"False\",\n" +
//        "    \"isCorelineSubstituted\": \"N\",\n" +
//        "    \"tescoVoucherName\": \"Clubcard Voucher\",\n" +
//        "    \"tescoEPurseName\": \"Tesco Gift Card\",\n" +
//        "    \"voucherPromotionName\": \"Tesco for Schools and clubs\"\n" +
//        "  },\n" +
//        "  \"orderLines\": [\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:1c1f0b3c-239e-4218-8441-acdf3677c9fb\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Mixed Leaf 120g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"F16AB\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"useBy\": \"01/13/2017\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:6e8dc52f-d361-4a17-9c5e-46839d3a3c6d\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Pineapple Fingers 80g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.50\",\n" +
//        "      \"productTotalPrice\": \"0.5000\",\n" +
//        "      \"productSubGroup\": \"F16AF\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:f36be7d4-9ec0-4b29-8a40-52cf7b33e563\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Brt Whole Milk 568ml/1 Pint \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.45\",\n" +
//        "      \"productTotalPrice\": \"0.4500\",\n" +
//        "      \"productSubGroup\": \"F51CA\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:cf6d02e5-47b2-4d3c-9e6c-1ba5dc7cf32a\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Pure Brt Skimmed Milk 2l \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.25\",\n" +
//        "      \"productTotalPrice\": \"1.2500\",\n" +
//        "      \"productSubGroup\": \"F51CJ\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:0173edd3-b0f3-49a5-9f73-ef4d2d8e0668\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Greek Style Yogurt 4 X 100g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"F52CT\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:106d2240-113b-4a29-9eb0-8249a7a03e90\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco British W/Th Smoked Ham 125g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.80\",\n" +
//        "      \"productTotalPrice\": \"1.8000\",\n" +
//        "      \"productSubGroup\": \"F53IP\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:b1f2906e-b84b-4f74-8fe9-ac26621decbf\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco British Roast Beef 125g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.80\",\n" +
//        "      \"productTotalPrice\": \"1.8000\",\n" +
//        "      \"productSubGroup\": \"F53IP\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:36459012-e9cc-4106-b8b5-f06eeea2015e\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Herta 4 Jumbo Frankfurters Hot Dogs 360g \",\n" +
//        "      \"productQuantity\": \"2\",\n" +
//        "      \"productUnitPrice\": \"2.00\",\n" +
//        "      \"productTotalPrice\": \"4.0000\",\n" +
//        "      \"productSubGroup\": \"F53IW\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"useBy\": \"01/16/2017\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:42d8fc9f-32ac-4191-ac59-a3ed0460b43f\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Quorn Chicken Style Pieces 350g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"3.00\",\n" +
//        "      \"productTotalPrice\": \"3.0000\",\n" +
//        "      \"productSubGroup\": \"F54PB\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:22cad9f4-bcdd-4b17-8b8f-3da4b633492a\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Quorn Bacon Style Rashers 120g \",\n" +
//        "      \"productQuantity\": \"4\",\n" +
//        "      \"productUnitPrice\": \"1.50\",\n" +
//        "      \"productTotalPrice\": \"6.0000\",\n" +
//        "      \"productSubGroup\": \"F54PB\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:42fb9857-3442-4f46-8e23-d38e116463fc\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Quorn Cocktail Sausages 180g \",\n" +
//        "      \"productQuantity\": \"2\",\n" +
//        "      \"productUnitPrice\": \"1.50\",\n" +
//        "      \"productTotalPrice\": \"3.0000\",\n" +
//        "      \"productSubGroup\": \"F54PB\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"useBy\": \"01/16/2017\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:91aac1ef-314c-49d9-b898-5c5e36477fbe\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"The City Kitchen Pork Steamed Bun 210g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.00\",\n" +
//        "      \"productTotalPrice\": \"2.0000\",\n" +
//        "      \"productSubGroup\": \"F54PI\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:71b7c7ff-0d47-4dd1-97a0-c1835fa4c7af\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Fin* Ckn & Chorizo, Prawn Paella 475g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"3.50\",\n" +
//        "      \"productTotalPrice\": \"3.5000\",\n" +
//        "      \"productSubGroup\": \"F54PN\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"useBy\": \"01/15/2017\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:ef7404c7-49d0-46c1-bdda-72b6425bf11f\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Finest Chicken & Prawn Pad Thai 410g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"3.50\",\n" +
//        "      \"productTotalPrice\": \"3.5000\",\n" +
//        "      \"productSubGroup\": \"F54PN\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"useBy\": \"01/13/2017\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:4735ed4a-7c15-4074-bffd-4c88cf08310e\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Yorkshire Prov Seasonal Veg Soup 600g (l) \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.50\",\n" +
//        "      \"productTotalPrice\": \"2.5000\",\n" +
//        "      \"productSubGroup\": \"F54RG\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:269c817c-0c49-44c5-ad8a-bc2948ac8b6b\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Vita Coco 100% Natural Coconut Water 4 X 330ml  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"4.99\",\n" +
//        "      \"productTotalPrice\": \"4.9900\",\n" +
//        "      \"productSubGroup\": \"F54TN\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:0c50ba6f-f7d8-4cbd-aebf-d531ac788278\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Tesco Pineapple Banana C/Nut 1lt Smoothie  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.50\",\n" +
//        "      \"productTotalPrice\": \"1.5000\",\n" +
//        "      \"productSubGroup\": \"F54TR\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:7aad746a-051c-4771-8b95-1a3179c67f04\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Suntrail Farms Ripen At Home Nectarine M/Mum4\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.49\",\n" +
//        "      \"productTotalPrice\": \"1.4900\",\n" +
//        "      \"productSubGroup\": \"F11SC\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:38ceab2a-8c94-4b6e-8d90-e612f42cd42e\",\n" +
//        "      \"productType\": \"Chilled\",\n" +
//        "      \"productDescription\": \"Nightingale Farms Celery 450g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.49\",\n" +
//        "      \"productTotalPrice\": \"0.4900\",\n" +
//        "      \"productSubGroup\": \"F13CM\",\n" +
//        "      \"pickingZone\": \"CH\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:6268f503-e8dc-43a1-8388-5df760aad1a4\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Redmere Farms Carrots 1kg \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.45\",\n" +
//        "      \"productTotalPrice\": \"0.4500\",\n" +
//        "      \"productSubGroup\": \"F15IF\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:227c3924-7cdc-44a0-99ab-fd96a737ebd7\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Bananas Loose \",\n" +
//        "      \"productQuantity\": \"loose\",\n" +
//        "      \"productUnitPrice\": \"loose\",\n" +
//        "      \"productTotalPrice\": \"0.40\",\n" +
//        "      \"productSubGroup\": \"F11VA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:a982ea68-64ca-4dd9-9e8d-ac434dcb6b71\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Multiseed Farmhouse Batch 800g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.90\",\n" +
//        "      \"productTotalPrice\": \"0.9000\",\n" +
//        "      \"productSubGroup\": \"B31DA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:cba975d9-ff4b-4474-94bb-fa6baeb03034\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco 6 White Pitta Bread \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.50\",\n" +
//        "      \"productTotalPrice\": \"0.5000\",\n" +
//        "      \"productSubGroup\": \"B33ED\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:4f291c1e-e439-470f-abe7-855556ee6dbf\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Mr Kipling Bumble Bee Slice 9pk \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.17\",\n" +
//        "      \"productTotalPrice\": \"1.1700\",\n" +
//        "      \"productSubGroup\": \"B45AM\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"useBy\": \"01/16/2017\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:a021a2a8-d2d2-4fe2-ae28-11ada0473113\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"TescoFin Salted Caramel & Milk Choc Cookie 4pk \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"B63PE\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:0e893b24-a703-4aad-bf1e-779adf1194be\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Braeburn Apples Loose \",\n" +
//        "      \"productQuantity\": \"loose\",\n" +
//        "      \"productUnitPrice\": \"loose\",\n" +
//        "      \"productTotalPrice\": \"2.88\",\n" +
//        "      \"productSubGroup\": \"F11AC\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:081bb2a5-4b92-44e6-a90b-361272a79c68\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Green Pears Loose \",\n" +
//        "      \"productQuantity\": \"loose\",\n" +
//        "      \"productUnitPrice\": \"loose\",\n" +
//        "      \"productTotalPrice\": \"1.48\",\n" +
//        "      \"productSubGroup\": \"F11KA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:0d278d1a-4bcc-46f5-b6e9-d3f41df4d2d3\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Heinz Snap Pots 50% Less Sugar 4x200g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.49\",\n" +
//        "      \"productTotalPrice\": \"2.4900\",\n" +
//        "      \"productSubGroup\": \"G13AA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:68a90a5b-304c-41cc-8554-0789237d60af\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Heinz Macaroni Cheese 400g \",\n" +
//        "      \"productQuantity\": \"2\",\n" +
//        "      \"productUnitPrice\": \"1.07\",\n" +
//        "      \"productTotalPrice\": \"2.1400\",\n" +
//        "      \"productSubGroup\": \"G13DD\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:263e80ae-11dd-49c2-9303-0a38d24ad4cb\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Princes Drained Tuna Steak In S/Water 3pk 120g\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.00\",\n" +
//        "      \"productTotalPrice\": \"2.0000\",\n" +
//        "      \"productSubGroup\": \"G14GD\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:00e8ffa5-cfc8-4227-928d-bb6f8ebd679a\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Spirali 500g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.59\",\n" +
//        "      \"productTotalPrice\": \"0.5900\",\n" +
//        "      \"productSubGroup\": \"G18DC\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:5c81c717-f050-4389-9fd9-167e61cf4a7f\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Hilife Tempt Me Tuna Selection Multipack 8 Pack *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"4.00\",\n" +
//        "      \"productTotalPrice\": \"4.0000\",\n" +
//        "      \"productSubGroup\": \"G37DA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:610a25c0-60ba-4b72-b745-5c8ee2c2a1a2\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Pataks Madras Sauce 450g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"G41LI\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:9c7354ab-e597-4889-9b25-3650dcc71570\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Loyd Grossman Tomt C/Grill Veg Pasta Sce 350g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"G41LK\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:f202a53b-2b5a-40d2-af16-62bb6e334d15\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Loyd Grossman B/Naise & M/Room 425g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"G41MF\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:606622e5-ca46-44f6-95f6-770a2bc9e2a8\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Wholegrain Mustard 180g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.55\",\n" +
//        "      \"productTotalPrice\": \"0.5500\",\n" +
//        "      \"productSubGroup\": \"G42MP\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:acafd1de-c1d7-42f4-b9bb-b1c9e5dcb1ce\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Weetabix Minis Fruit & Nut Crisp 600g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.50\",\n" +
//        "      \"productTotalPrice\": \"2.5000\",\n" +
//        "      \"productSubGroup\": \"G51AP\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:2f81afec-591b-45ae-aea3-2ab93ca39318\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Stoats Bl/Berry Hon Porridge Bar Multipacks4x50g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.00\",\n" +
//        "      \"productTotalPrice\": \"2.0000\",\n" +
//        "      \"productSubGroup\": \"G51AR\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:7a8d5428-e58a-4d30-9564-bfe6bf20e6b9\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Twinings Lemon & Ginger 20 Teabags 30g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"G61AH\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:5290ad49-7f32-4c07-8feb-a3c60835f141\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Pukka Org Spiced Apl Cinn + Gingr 20 Tea Bags 40g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.50\",\n" +
//        "      \"productTotalPrice\": \"1.5000\",\n" +
//        "      \"productSubGroup\": \"G61AH\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:435f4e91-67d8-4e81-9ed2-5f7db60c109b\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Dr Pepper Zero 6 X 330 Ml Pack  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"3.55\",\n" +
//        "      \"productTotalPrice\": \"3.5500\",\n" +
//        "      \"productSubGroup\": \"G62GD\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:47b58bfe-9347-4933-91b3-fa54a0c47d5b\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Nas Ginger Beer 4 X 330ml  *\",\n" +
//        "      \"productQuantity\": \"2\",\n" +
//        "      \"productUnitPrice\": \"0.99\",\n" +
//        "      \"productTotalPrice\": \"1.9800\",\n" +
//        "      \"productSubGroup\": \"G62GD\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:a324a91f-fc74-4b9e-b9b4-775523542122\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tango Sugar Free Orange 6x330ml  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"3.19\",\n" +
//        "      \"productTotalPrice\": \"3.1900\",\n" +
//        "      \"productSubGroup\": \"G62GD\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:7fc7a062-02ee-41bd-add7-5cb103ac93a2\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Coca Cola Diet Coke 1.75l  *\",\n" +
//        "      \"productQuantity\": \"2\",\n" +
//        "      \"productUnitPrice\": \"1.66\",\n" +
//        "      \"productTotalPrice\": \"3.3200\",\n" +
//        "      \"productSubGroup\": \"G62JA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:c9a27b1a-3ac7-4036-81ff-e4deaa330f5e\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Finest Maple And Pecan Cookies 200g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.59\",\n" +
//        "      \"productTotalPrice\": \"1.5900\",\n" +
//        "      \"productSubGroup\": \"G71CH\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:1ee7b075-ac56-4765-8349-42e769aee1de\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Walkers Variety Snacks 24pk  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"3.00\",\n" +
//        "      \"productTotalPrice\": \"3.0000\",\n" +
//        "      \"productSubGroup\": \"G76DA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:4b0930b6-04f5-4e66-9d65-6e043933b25a\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Snickers & Hazelnut 4 Pack 196g  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.00\",\n" +
//        "      \"productTotalPrice\": \"1.0000\",\n" +
//        "      \"productSubGroup\": \"G78AC\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Cadbury Dairy Milk Picnic Choc Bars X4 193.6g  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.50\",\n" +
//        "      \"productTotalPrice\": \"1.5000\",\n" +
//        "      \"productSubGroup\": \"G78AC\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:6af520a8-6a3d-4e03-83bd-7836efc11106\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Persil Small & Mighty Bio. 60 Wash 2.1l  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"7.00\",\n" +
//        "      \"productTotalPrice\": \"7.0000\",\n" +
//        "      \"productSubGroup\": \"N35AB\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:c33de245-516e-4531-b463-530b4181b7cc\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Dylon Colour Catcher 40 Sheets  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"4.50\",\n" +
//        "      \"productTotalPrice\": \"4.5000\",\n" +
//        "      \"productSubGroup\": \"N35BA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:31b21221-9c3b-4057-8986-0e8d53da5938\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Tesco Antibac Wsh Up Liqd Lime & Lem 450ml  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"0.70\",\n" +
//        "      \"productTotalPrice\": \"0.7000\",\n" +
//        "      \"productSubGroup\": \"N35GA\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:a215d7ba-a71e-440d-a8e9-5f93620696fa\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Spontex Microfibre Cloth 4 Pack  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.00\",\n" +
//        "      \"productTotalPrice\": \"2.0000\",\n" +
//        "      \"productSubGroup\": \"N35JV\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:6af1ccdd-8ac3-485a-88e4-001537f6394d\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Andrex Toilet Tissue 16 Roll White  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"6.50\",\n" +
//        "      \"productTotalPrice\": \"6.5000\",\n" +
//        "      \"productSubGroup\": \"N35PG\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:9928220c-cfda-46d5-b46d-70bfeea7eca6\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Heinz Sav Pouch Apple & Pork Casserole 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.30\",\n" +
//        "      \"productTotalPrice\": \"1.3000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:0be836a8-09d5-4344-9402-df3564f96bdf\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Ella's Pork Roast Stage 2 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.40\",\n" +
//        "      \"productTotalPrice\": \"1.4000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:2ac7329b-c1b8-4143-a6b3-223d48b779a0\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Ella's Vegetable Lasagne Stage 2 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.40\",\n" +
//        "      \"productTotalPrice\": \"1.4000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:70375b2d-dd97-419f-8651-1dc12f544259\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Heinz Sav Pouch Creamy Fish Pie 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.30\",\n" +
//        "      \"productTotalPrice\": \"1.3000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:5f8fea8a-5f66-49b9-9dbc-73086c2b3762\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Hipp Organic Mild Tomato & Ckn Curry 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.30\",\n" +
//        "      \"productTotalPrice\": \"1.3000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:4e5ed309-8bec-4f6d-b73f-4b2e0b063814\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Ella's Fun Ckn & Noodle With Red Pepper 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.40\",\n" +
//        "      \"productTotalPrice\": \"1.4000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:97c0cefa-5479-4696-a2f5-94372d4a3770\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Hipp Organic Squash Ckn Pasta Bake 7m+ 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.30\",\n" +
//        "      \"productTotalPrice\": \"1.3000\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"For Aisha Indian Ckn & Swt P/Toe 7 Mth+ 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.45\",\n" +
//        "      \"productTotalPrice\": \"1.4500\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"For Aisha Jerk Ckn & Mango 7 Mth+ 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.45\",\n" +
//        "      \"productTotalPrice\": \"1.4500\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"For Aisha Ckn Dhal With Lentil 7mth+ 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.45\",\n" +
//        "      \"productTotalPrice\": \"1.4500\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"For Aisha Moroc Ckn Tagine 7 Mth+ 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.45\",\n" +
//        "      \"productTotalPrice\": \"1.4500\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"For Aisha Lamb Shepherds Pie 7 Mth+ 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.45\",\n" +
//        "      \"productTotalPrice\": \"1.4500\",\n" +
//        "      \"productSubGroup\": \"N53AJ\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:b87e1481-a04b-4658-acce-7115aa2b0296\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Ella's Kitchen Veg Bake With Lentils 130g \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"1.40\",\n" +
//        "      \"productTotalPrice\": \"1.4000\",\n" +
//        "      \"productSubGroup\": \"N53AO\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:9bb00b6c-acfc-439d-833f-2633c39a516a\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"productDescription\": \"Pampers Baby Dry Size 4 Jumbo+ Pack 86 Nappies \",\n" +
//        "      \"productQuantity\": \"2\",\n" +
//        "      \"productUnitPrice\": \"14.00\",\n" +
//        "      \"productTotalPrice\": \"28.0000\",\n" +
//        "      \"productSubGroup\": \"N53DG\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"isApplicableForVat\": \"N\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:049c78a9-8175-4976-ba11-df94e545a4a0\",\n" +
//        "      \"productType\": \"Frozen\",\n" +
//        "      \"productDescription\": \"Terry's Chocolate Orange 3 X 90ml  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.99\",\n" +
//        "      \"productTotalPrice\": \"2.9900\",\n" +
//        "      \"productSubGroup\": \"F76AJ\",\n" +
//        "      \"pickingZone\": \"FZ\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:e5e6ba31-e023-4dba-b4dd-d26acff38c72\",\n" +
//        "      \"productType\": \"Frozen\",\n" +
//        "      \"productDescription\": \"Tesco Chewy Caramel Ice Cream 480ml  *\",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"productUnitPrice\": \"2.00\",\n" +
//        "      \"productTotalPrice\": \"2.0000\",\n" +
//        "      \"productSubGroup\": \"F76DA\",\n" +
//        "      \"pickingZone\": \"FZ\",\n" +
//        "      \"isApplicableForVat\": \"Y\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productDescription\": \"Tesco 6 White Pitta Bread \",\n" +
//        "      \"productQuantity\": \"1\",\n" +
//        "      \"isApplicableForVat\": \"N\",\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:cba975d9-ff4b-4474-94bb-fa6baeb03034\",\n" +
//        "      \"productUnitPrice\": \"0.50\",\n" +
//        "      \"productSubGroup\": \"B33ED\",\n" +
//        "      \"pickingZone\": \"AM\",\n" +
//        "      \"productTotalPrice\": \"0.5000\",\n" +
//        "      \"productType\": \"Cupboard\",\n" +
//        "      \"useBy\": \"02/18/2017\"\n" +
//        "    }\n" +
//        "  ],\n" +
//        "  \"substitutions\": [\n" +
//        "    {\n" +
//        "      \"orderLineId\": \"45878501\",\n" +
//        "      \"promotionName\": \"\",\n" +
//        "      \"orderedProductId\": \"trn:tesco:product:uuid:2bb229f1-81f0-46e1-9135-b33bdbef69d7\",\n" +
//        "      \"orderedProductType\": \"Cupboard\",\n" +
//        "      \"orderedProductSubgroup\": \"G37DA\",\n" +
//        "      \"orderedPickingZone\": \"AM\",\n" +
//        "      \"orderedProductDescription\": \"Tesco Premium Fish Selection In Jelly 6x85g \",\n" +
//        "      \"orderedProductQuantity\": \"1\",\n" +
//        "      \"orderedProductActualUnitPrice\": \"3.50\",\n" +
//        "      \"orderedProductPromoTotalPrice\": \"3.50\",\n" +
//        "      \"substitutedProducts\": [\n" +
//        "        {\n" +
//        "          \"productIdProvided\": \"trn:tesco:product:uuid:8b24c09b-1661-41f0-a655-fdc915613ef2\",\n" +
//        "          \"productProvidedType\": \"Cupboard\",\n" +
//        "          \"productProvidedSubgroup\": \"G37DA\",\n" +
//        "          \"productProvidedPickingZone\": \"AM\",\n" +
//        "          \"productProvidedIsApplicableForVat\": \"Y\",\n" +
//        "          \"productProvidedDescription\": \"Tesco Premium Chicken Seln In Jelly 6x85g \",\n" +
//        "          \"productProvidedQuantity\": \"1\",\n" +
//        "          \"productProvidedActualUnitPrice\": \"3.50\",\n" +
//        "          \"productProvidedActualTotalPrice\": \"3.5000\",\n" +
//        "          \"productProvidedPromoUnitPrice\": \"3.5000\",\n" +
//        "          \"priceMatchRefunds\": \"0.00\",\n" +
//        "          \"isEssentialSubstitution\": \"N\"\n" +
//        "        }\n" +
//        "      ]\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"orderLineId\": \"45887889\",\n" +
//        "      \"promotionName\": \"\",\n" +
//        "      \"orderedProductId\": \"trn:tesco:product:uuid:52d873c5-f418-4001-b342-caa568670279\",\n" +
//        "      \"orderedProductType\": \"Cupboard\",\n" +
//        "      \"orderedProductSubgroup\": \"G51AR\",\n" +
//        "      \"orderedPickingZone\": \"AM\",\n" +
//        "      \"orderedProductDescription\": \"Nature Valley Protein Peanut Butter&Choc4x40g\",\n" +
//        "      \"orderedProductQuantity\": \"1\",\n" +
//        "      \"orderedProductActualUnitPrice\": \"1.44\",\n" +
//        "      \"orderedProductPromoTotalPrice\": \"1.44\",\n" +
//        "      \"substitutedProducts\": [\n" +
//        "        {\n" +
//        "          \"productIdProvided\": \"trn:tesco:product:uuid:6d9b9309-cf5f-4a4d-8ab7-6b463a1e3b2c\",\n" +
//        "          \"productProvidedType\": \"Cupboard\",\n" +
//        "          \"productProvidedSubgroup\": \"G51AR\",\n" +
//        "          \"productProvidedPickingZone\": \"AM\",\n" +
//        "          \"productProvidedIsApplicableForVat\": \"Y\",\n" +
//        "          \"productProvidedDescription\": \"Nature Valley Crunchy Bars Oat & Hon 5pack 210g\",\n" +
//        "          \"productProvidedQuantity\": \"1\",\n" +
//        "          \"productProvidedActualUnitPrice\": \"2.39\",\n" +
//        "          \"productProvidedActualTotalPrice\": \"2.3900\",\n" +
//        "          \"productProvidedPromoUnitPrice\": \"1.4400\",\n" +
//        "          \"priceMatchRefunds\": \"0.95\",\n" +
//        "          \"isEssentialSubstitution\": \"N\"\n" +
//        "        }\n" +
//        "      ]\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"orderLineId\": \"45887890\",\n" +
//        "      \"promotionName\": \"\",\n" +
//        "      \"orderedProductId\": \"trn:tesco:product:uuid:5e84d11a-7b00-4695-9a21-8d1907510908\",\n" +
//        "      \"orderedProductType\": \"Cupboard\",\n" +
//        "      \"orderedProductSubgroup\": \"G51AR\",\n" +
//        "      \"orderedPickingZone\": \"AM\",\n" +
//        "      \"orderedProductDescription\": \"Nature Valley Protein Salted Caramel Bar4x40g\",\n" +
//        "      \"orderedProductQuantity\": \"1\",\n" +
//        "      \"orderedProductActualUnitPrice\": \"1.44\",\n" +
//        "      \"orderedProductPromoTotalPrice\": \"1.44\",\n" +
//        "      \"substitutedProducts\": [\n" +
//        "        {\n" +
//        "          \"productIdProvided\": \"trn:tesco:product:uuid:6d9b9309-cf5f-4a4d-8ab7-6b463a1e3b2c\",\n" +
//        "          \"productProvidedType\": \"Cupboard\",\n" +
//        "          \"productProvidedSubgroup\": \"G51AR\",\n" +
//        "          \"productProvidedPickingZone\": \"AM\",\n" +
//        "          \"productProvidedIsApplicableForVat\": \"Y\",\n" +
//        "          \"productProvidedDescription\": \"Nature Valley Crunchy Bars Oat & Hon 5pack 210g\",\n" +
//        "          \"productProvidedQuantity\": \"1\",\n" +
//        "          \"productProvidedActualUnitPrice\": \"2.39\",\n" +
//        "          \"productProvidedActualTotalPrice\": \"2.3900\",\n" +
//        "          \"productProvidedPromoUnitPrice\": \"1.4400\",\n" +
//        "          \"priceMatchRefunds\": \"0.95\",\n" +
//        "          \"isEssentialSubstitution\": \"N\",\n" +
//        "          \"productProvidedUseBy\": \"01/13/2017\"\n" +
//        "        },\n" +
//        "        {\n" +
//        "          \"productIdProvided\": \"trn:tesco:product:uuid:6d9b9309-cf5f-4a4d-8ab7-6b463a1e3b2r\",\n" +
//        "          \"productProvidedType\": \"Cupboard\",\n" +
//        "          \"productProvidedSubgroup\": \"G51AR\",\n" +
//        "          \"productProvidedPickingZone\": \"AM\",\n" +
//        "          \"productProvidedIsApplicableForVat\": \"Y\",\n" +
//        "          \"productProvidedDescription\": \"Nature Valley Crunchy Bars Oat & Hon 5pack 210g\",\n" +
//        "          \"productProvidedQuantity\": \"1\",\n" +
//        "          \"productProvidedActualUnitPrice\": \"2.39\",\n" +
//        "          \"productProvidedActualTotalPrice\": \"2.3900\",\n" +
//        "          \"productProvidedPromoUnitPrice\": \"1.4400\",\n" +
//        "          \"priceMatchRefunds\": \"0.95\",\n" +
//        "          \"isEssentialSubstitution\": \"N\",\n" +
//        "          \"productProvidedUseBy\": \"01/13/2018\"\n" +
//        "        }\n" +
//        "      ]\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"orderLineId\": \"27295703\",\n" +
//        "      \"orderedProductPromoTotalPrice\": \"0.77\",\n" +
//        "      \"substitutedProducts\": [\n" +
//        "        {\n" +
//        "          \"productProvidedSubgroup\": \"B33ED\",\n" +
//        "          \"productProvidedDescription\": \"Tesco 6 Wholemeal Pitta Bread \",\n" +
//        "          \"productProvidedActualTotalPrice\": \"0.5000\",\n" +
//        "          \"isEssentialSubstitution\": \"N\",\n" +
//        "          \"productIdProvided\": \"trn:tesco:product:uuid:69e9647c-e227-4d54-bcf6-d3d0c477dc1b\",\n" +
//        "          \"productProvidedPickingZone\": \"AM\",\n" +
//        "          \"productProvidedQuantity\": \"1\",\n" +
//        "          \"productProvidedActualUnitPrice\": \"0.50\",\n" +
//        "          \"productProvidedPromoUnitPrice\": \"0.5000\",\n" +
//        "          \"productProvidedIsApplicableForVat\": \"N\",\n" +
//        "          \"priceMatchRefunds\": \"0.00\",\n" +
//        "          \"productProvidedType\": \"Cupboard\"\n" +
//        "        }\n" +
//        "      ],\n" +
//        "      \"orderedProductId\": \"trn:tesco:product:uuid:cba975d9-ff4b-4474-94bb-fa6baeb03034\",\n" +
//        "      \"orderedProductSubgroup\": \"B33ED\",\n" +
//        "      \"promotionName\": \"\",\n" +
//        "      \"orderedPickingZone\": \"AM\",\n" +
//        "      \"orderedProductType\": \"Cupboard\",\n" +
//        "      \"orderedProductQuantity\": \"1\",\n" +
//        "      \"orderedProductActualUnitPrice\": \"0.38\",\n" +
//        "      \"orderedProductDescription\": \"Tesco 6 White Pitta Bread \"\n" +
//        "    }\n" +
//        "  ],\n" +
//        "  \"paymentAndSavings\": {\n" +
//        "    \"prePromotionProductCost\": \"171.5700\",\n" +
//        "    \"promotionalSavings\": \"-18.5100\",\n" +
//        "    \"serviceCharge\": \"2.5000\",\n" +
//        "    \"totalCost\": \"155.0600\",\n" +
//        "    \"privilegeCardDiscount\": \"0.0000\",\n" +
//        "    \"computerVoucherCount\": \"0\",\n" +
//        "    \"paymentCardNumber\": \"3768\",\n" +
//        "    \"paymentCardExpiryDate\": \"03/17\",\n" +
//        "    \"paymentCardType\": \"Visa\",\n" +
//        "    \"vatNumber\": \"220430231\",\n" +
//        "    \"vatPercentage\": \"20%\",\n" +
//        "    \"carrierBagCharge\": \"0\",\n" +
//        "    \"minimumBasketCharge\": \"0\"\n" +
//        "  },\n" +
//        "  \"promotionSavings\": [\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"BRAND GUARANTEE\",\n" +
//        "      \"promotionPrice\": \"-1.1700\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"COOKED MEAT 2 FOR £3\",\n" +
//        "      \"promotionPrice\": \"-0.6000\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"DRINKS 2 FOR £1.5\",\n" +
//        "      \"promotionPrice\": \"-0.4800\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"DRINKS 2 FOR £2\",\n" +
//        "      \"promotionPrice\": \"-1.3200\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"FOR AISHA 3 FOR £4\",\n" +
//        "      \"promotionPrice\": \"-0.3500\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"HEINZ 2 FOR £2\",\n" +
//        "      \"promotionPrice\": \"-0.6000\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"HERTA 2 FOR £3\",\n" +
//        "      \"promotionPrice\": \"-1.0000\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"ICE CREAM 2 FOR £3\",\n" +
//        "      \"promotionPrice\": \"-1.9900\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"PAMPERS 2 FOR £18\",\n" +
//        "      \"promotionPrice\": \"-10.0000\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"promotionDescription\": \"READY MEALS 2 FOR £6\",\n" +
//        "      \"promotionPrice\": \"-1.0000\"\n" +
//        "    }\n" +
//        "  ],\n" +
//        "  \"clubCardStatements\": {\n" +
//        "    \"regularPoints\": 156,\n" +
//        "    \"greenPoints\": 0,\n" +
//        "    \"totalPoints\": 156,\n" +
//        "    \"totalPointsTillDate\": 1494,\n" +
//        "    \"clubCardDigits\": 5266\n" +
//        "  },\n" +
//        "  \"deliveryDetails\": {\n" +
//        "    \"deliverySlotStartTime\": \"13:00\",\n" +
//        "    \"deliverySlotEndTime\": \"14:00\"\n" +
//        "  },\n" +
//        "  \"customerDetails\": {\n" +
//        "    \"title\": \"Mrs\",\n" +
//        "    \"firstName\": \"Paula\",\n" +
//        "    \"middleName\": \"\",\n" +
//        "    \"lastName\": \"Freeman-Bown\",\n" +
//        "    \"address\": \"26 Elm Road,Winchester\",\n" +
//        "    \"postalCodes\": \"SO22 5AG\",\n" +
//        "    \"daytimePhoneNumber\": \"07802585121\",\n" +
//        "    \"eveningPhoneNumber\": \"07802585121\",\n" +
//        "    \"mobileNumber\": \"\",\n" +
//        "    \"emailId\": \"paulafreemanbown@gmail.com\",\n" +
//        "    \"isFirstTimeCustomer\": \"NO  \",\n" +
//        "    \"isSecondTimeCustomer\": \"NO  \",\n" +
//        "    \"isDeliverySaverCustomer\": \"NO\"\n" +
//        "  },\n" +
//        "  \"outOfStockProducts\": [\n" +
//        "    {\n" +
//        "      \"productId\": \"81655524\",\n" +
//        "      \"productDescription\": \"Tv Times \",\n" +
//        "      \"quantity\": \"1\",\n" +
//        "      \"isCustomerRequestedSubstitution\": \"TS\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productId\": \"81655524\",\n" +
//        "      \"productDescription\": \"Tv Times \",\n" +
//        "      \"quantity\": \"1\",\n" +
//        "      \"isCustomerRequestedSubstitution\": \"NS\"\n" +
//        "    },\n" +
//        "    {\n" +
//        "      \"productDescription\": \"Tesco 6 White Pitta Bread \",\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:cba975d9-ff4b-4474-94bb-fa6baeb03034\",\n" +
//        "      \"quantity\": \"1\",\n" +
//        "      \"isCustomerRequestedSubstitution\": \"TS\"\n" +
//        "    }\n" +
//        "  ],\n" +
//        "  \"eCoupons\": {\n" +
//        "    \"eCoupon\": \"0.0000\"\n" +
//        "  },\n" +
//        "  \"extendedOrder\": {\n" +
//        "    \"currency\": {\n" +
//        "      \"currencyCode\": \"GBP\",\n" +
//        "      \"currencySymbol\": \"£\"\n" +
//        "    },\n" +
//        "    \"carrierBagCharge\": {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:7262a5a9-29af-444e-8af4-8ff8b5e595d8\",\n" +
//        "      \"productDescription\": \"Bag Charge\",\n" +
//        "      \"productUnitPrice\": \"0\"\n" +
//        "    },\n" +
//        "    \"fulfilmentCharge\": {\n" +
//        "      \"productId\": \"trn:tesco:product:uuid:3272d243-bb60-4bf6-a4cb-adf599970d29\",\n" +
//        "      \"productDescription\": \"2.50 Service Charge\",\n" +
//        "      \"productUnitPrice\": \"2.5000\",\n" +
//        "      \"productSubGroup\": \"Z92CA\"\n" +
//        "    },\n" +
//        "    \"orderState\": \"closed\",\n" +
//        "    \"fulfilmentState\": \"fulfilled\"\n" +
//        "  }\n" +
//        "}";
//        System.out.println ("----------json----------------" );
//        System.out.println (json );
//
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map = new HashMap<String, Object>();
//// convert JSON string to Map
//        try {
//            map = mapper.readValue(json, new TypeReference<Map<String, Object>> () {});
//        } catch (IOException e) {
//            e.printStackTrace ( );
//        }
//        System.out.println ("-----------------map-------------------" );
//        System.out.println(map);
//
//
//
//
//     /* ObjectMapper mapper=new ObjectMapper();
//       BidiMap map = new DualHashBidiMap ();
//
//
//        try {
//            map = mapper.readValue(json, new TypeReference<Map<String, Object>> () {});
//        } catch (IOException e) {
//            e.printStackTrace ( );
//        }
//        System.out.println ("-----------------map-------------------" );
//        System.out.println(map);
//*/
//
//
//
//
//    }
//
//}
//
//
//
