package org.sebas.ejemploestructuradatos.list.sebas.poointerfaces.catalogo.literario;

import java.util.Date;

public interface ILibro {
    Date getFechaPublicacion();
    String getAutor();
    String getTitulo();
    String getEditorial();

}
