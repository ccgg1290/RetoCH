package co.com.choucair.certificacion.retoautomatizacion.tasks;

import co.com.choucair.certificacion.retoautomatizacion.interactions.ManejoAlertas;
import co.com.choucair.certificacion.retoautomatizacion.models.FcomprarProduct;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Prod;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.cart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class ComprarProduct implements Task {

/*
    private final List<FcomprarProduct> data;

    public ComprarProduct(List<FcomprarProduct> data2) {
        this.data = data2;
    }

    public static  ComprarProduct comprarProducto(List<FcomprarProduct> data){

        return Tasks.instrumented(ComprarProduct.class);
    }


 */



    public static ComprarProduct comprarProducto() {
        return Tasks.instrumented(ComprarProduct.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {


        //Elegir producto e inciar la compra
        actor.attemptsTo(

                Click.on(Home.COMPRAPHONES),
                WaitUntil.the(Home.COMPRAPHONE, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(Home.COMPRAPHONE),
                WaitUntil.the(Prod.ADDTOCAR, isCurrentlyVisible()).forNoMoreThan(10).seconds(),
                Click.on(Prod.ADDTOCAR)
        );
        // Esperar que aparezca la alerta
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //cerrar la alerta
        System.out.println("antes de la alerta");
        System.out.println(ManejoAlertas.mensajeAlerta());
        ManejoAlertas.aceptarAlerta();

        actor.attemptsTo(
                //ir la carrito de compras
                Click.on(Prod.NAVCART),
                Click.on(cart.PLACEORDER),
                //llenar formulario de compra
                WaitUntil.the(cart.FORMNAME, isCurrentlyVisible()).forNoMoreThan(10).seconds(),

                /*SendKeys.of(data.get(0).getName()).into(cart.FORMNAME),
                SendKeys.of(data.get(0).getCountry()).into(cart.FORMCOUNTRY),
                SendKeys.of(data.get(0).getCity()).into(cart.FORMCITY),
                SendKeys.of(data.get(0).getCard()).into(cart.FORMCARD),
                SendKeys.of(data.get(0).getMonth()).into(cart.FORMMONTH),
                SendKeys.of(data.get(0).getYear()).into(cart.FORYEAR),//*/



                SendKeys.of("cristian").into(cart.FORMNAME),
                SendKeys.of("Colombia").into(cart.FORMCOUNTRY),
                SendKeys.of("Bogota").into(cart.FORMCITY),
                SendKeys.of("1548847").into(cart.FORMCARD),
                SendKeys.of("10").into(cart.FORMMONTH),
                SendKeys.of("2022").into(cart.FORYEAR),//



                // finalizar compra
                Click.on(cart.PURCHASE),
                WaitUntil.the(cart.OKCOMPRA, isCurrentlyVisible()),
                //Click.on(cart.PURCHASE)
                Click.on(cart.OKCOMPRA)
        );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
