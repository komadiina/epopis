package org.unibl.etf.epopis.model.api;

public class APIPotrosac extends API {
    public void registrujSe() {

    }

    public void posaljiZahtjev(boolean jeIskljucenje) {
        if (jeIskljucenje) posaljiIskljucenje();
        else posaljiPrikljucenje();
    }

    public void posaljiIskljucenje() {

    }

    public void posaljiPrikljucenje() {

    }
}
