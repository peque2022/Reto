import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Request {

    @Test
    public void PostUpdateDeleteItem(){

        //CREATE - POST

        JSONObject json = new JSONObject();

        JSONObject bodyItem = new JSONObject();

        bodyItem.put("firstname","Luana");
        bodyItem.put("lastname","Gamarra");
        bodyItem.put("totalprice","222");
        bodyItem.put("depositpaid","true");
        bodyItem.put("additionalneeds","Dinner");

        JSONObject subBodyItem = new JSONObject();

        subBodyItem.put("checkin","2018-01-01");
        subBodyItem.put("checkout","2019-01-01");

        json.put("bookingdates", subBodyItem.toMap());

        System.out.println("****************** CREATE - POST *********************");

        Response response=given()
                .auth()
                .preemptive()
                .basic("admin","password123")
                .body(bodyItem.toString())
                .log()
                .all()
                .when()
                .post("https://restful-booker.herokuapp.com/booking");
        response.then()
                .statusCode(200)
                .body("firstname",equalTo("Luana"))
                .body("lastname",equalTo("Gamarra"))
                .body("totalprice",equalTo("222"))
                .body("depositpaid",equalTo("true"))
                .body("additionalneeds",equalTo("Dinner"))
//                .body("checkin",equalTo("2018-01-01"))
//                .body("checkout",equalTo("2019-01-01"))
                .log()
                .all();


        String bookingId = response.then().extract().path("bookingid")+"";
        System.out.println("**** ID ITEM: " + bookingId);


        // UPDATE

        bodyItem = new JSONObject();
        bodyItem.put("firstname","LuanaX");
        bodyItem.put("lastname","GamarraX");
        bodyItem.put("totalprice","2222");
        bodyItem.put("depositpaid","true");
        bodyItem.put("checkin","2018-01-01");
        bodyItem.put("checkout","2019-01-01");
        bodyItem.put("additionalneeds","Lunch");

        System.out.println("****************** UPDATE *********************");

        response=given()
                .auth()
                .preemptive()
                .basic("admin","password123")
                .body(bodyItem.toString())
                .log()
                .all()
                .when()
                .put("https://restful-booker.herokuapp.com/booking/"+bookingId);
        response.then()
                .statusCode(200)
                .body("firstname",equalTo("LuanaX"))
                .body("lastname",equalTo("GamarraX"))
                .body("totalprice",equalTo("2222"))
                .log()
                .all();

        System.out.println("****************** DELETE *********************");

        // DELETE

        response= given()
                .auth()
                .preemptive()
                .basic("admin","password123")
                .log()
                .all()
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+bookingId);
        response.then()
                .statusCode(201)
                .log()
                .all();

    }

}
