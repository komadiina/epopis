package org.unibl.etf.epopis.model.api;

public class APIDistributer extends API {
    public void pregledajZahtjeve() {

    }

    public void obradiZahtjev(boolean prihvatljiv) {
        if (prihvatljiv) odobriZahtjev();
        else odbijZahtjev();
    }

    private void odobriZahtjev() {

    }

    private void odbijZahtjev() {

    }
}
