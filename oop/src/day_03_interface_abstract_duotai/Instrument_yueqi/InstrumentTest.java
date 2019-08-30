package day_03_interface_abstract_duotai.Instrument_yueqi;

public class InstrumentTest {

    public static void main(String[] args) {
        Instrument instrument = new Piano();

        Instrument instrument1 = new Violin();

        instrument.play();
        instrument1.play();
    }

}
