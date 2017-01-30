package integration;

import integration.shared.IntegrationServer;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class ItemEndpointIT extends IntegrationServer {

    @Test
    public void should_return_iten() {
        get("http://127.0.0.1:" + jettyPort + "/challenge-backend/item?begindate=01-10-2016&finaldate=01-10-2016")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name[0]", equalTo("Celular"))
                .and()
                .body("code[0]", equalTo("1"))
                .and()
                .body("date[0]", equalTo("2016-10-01T24:00:00.0"))
                .and()
                .body("dimension[0].weight", equalTo("10.5"))
                .and()
                .body("dimension[0].height", equalTo("10.5"))
                .and()
                .body("dimension[0].width", equalTo("10.5"))
                .and()
                .body("dimension[0].length", equalTo("10.5"));
    }

    @Test
    public void should_return_BAD_REQUEST_when_item_not_found() {
        get("http://127.0.0.1:" + jettyPort + "/challenge-backend/item?begindate=05-10-2017&finaldate=10-10-2017")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
