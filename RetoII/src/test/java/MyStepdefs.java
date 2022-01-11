import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class MyStepdefs {

    @Given("^Tengo acceso al api de crear reserva$")
    public void tengoAccesoAlApiDeCrearReserva() {
    }

    @When("^ejecuto un metodo post a \"([^\"]*)\" con el body$")
    public void ejecutoUnMetodoPostAConElBody(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^se espera que el codigo de respuesta sea (\\d+)$")
    public void seEsperaQueElCodigoDeRespuestaSea(int arg0) {
    }
}
