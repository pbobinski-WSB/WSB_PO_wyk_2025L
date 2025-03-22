package wsb.po.trzy;

public class KlasaTestowa {

    private int pole;

    public KlasaTestowa() {
    }

    public KlasaTestowa(int pole) {
        this.pole = pole;
    }

    public int getPole() {
        return pole;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }

    @Override
    public String toString() {
        return "KlasaTestowa{" +
                "pole=" + pole +
                '}';
    }
}
