package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysVarastoonNega() {
        varasto.lisaaVarastoon(-8);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysVarastoonLiikaa() {
        varasto.lisaaVarastoon(11);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaaNega() {
        varasto.otaVarastosta(-2);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void maaraOnIsompiKuinSaldo() {
        varasto.otaVarastosta(20);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenKonstruktori() {
        varasto = new Varasto(-2);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void toinenNegatiivinenKonstruktori() {
        varasto = new Varasto(-2, -2);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void positiivinenJaNegatiivinenKonstruktori() {
        varasto = new Varasto(2, -2);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(2, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void tilavuusOnPienempiKuinSaldoKonstruktori() {
        varasto = new Varasto(2, 3);
        assertEquals(2, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(2, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void tilavuusOnIsompiKuinSaldoKonstruktori() {
        varasto = new Varasto(3, 2);
        assertEquals(2, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(3, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void testToString() {
        varasto = new Varasto(100, 20.2);
        assertEquals("saldo = 20.2, vielä tilaa 79.8",
                varasto.toString());
    }

}