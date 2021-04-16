package mx.com.gm.peliculas.excepciones;

import java.io.IOException;

public class ManejoExcepciones extends IOException {
    /**
     * Constructs an {@code IOException} with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method)
     */
    public ManejoExcepciones(String message) {
        super(message);
    }
}
