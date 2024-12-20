package by.yvesRocher.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;
import java.util.Map;

public class Specifications {

    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addHeaders(getHeaders())
                .build();
    }

    public static ResponseSpecification responseSpecification(int code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    private static Map<String,String> getHeaders (){
        Map<String,String> headers = new HashMap<>();
        headers.put("accept","application/json");
        headers.put("accept-language","ru-RU,ru;q=0.9,en-GB;q=0.8,en;q=0.7,en-US;q=0.6");
        headers.put("access-control-max-age","7200");
        headers.put("content-type","application/json");
        headers.put("cookies","_gcl_au: 1.1.758523137.1731532222,_ga: GA1.1.1426635524.1731532223,_ym_uid: 1731532223952358082,_ym_d: 1731532223,_tt_enable_cookie: 1,_ttp: G0_mPAUg8MmKdM01RzZhlyiwEm4,_ym_isad: 1,_ym_visorc: w,cookieProcessing: 1,_ga_CMTJR9L0Y6: GS1.1.1731532222.1.1.1731532231.51.0.0");
        headers.put("hl","ru");
        headers.put("origin","https://www.y-r.by");
        headers.put("priority","u=1, i");
        headers.put("referer","https://www.y-r.by/");
        return  headers;

    }
}
