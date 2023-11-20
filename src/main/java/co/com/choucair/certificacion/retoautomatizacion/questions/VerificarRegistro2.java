package co.com.choucair.certificacion.retoautomatizacion.questions;

import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.Home;
import co.com.choucair.certificacion.retoautomatizacion.userinterfaces.cart;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.core.Serenity.getDriver;

public class VerificarCompra2 {



   //  public static final Target FACTURE=Target.the("factura").locatedBy("//*[text()='Thank you for your purchase!']");
    public static Question<String> value(){

        return TheTarget.textOf(cart.FACTURE);

    }

}
