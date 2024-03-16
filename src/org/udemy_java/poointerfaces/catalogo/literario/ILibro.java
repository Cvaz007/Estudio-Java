package org.udemy_java.poointerfaces.catalogo.literario;

import java.util.Date;

public interface ILibro {
    Date getFechaPublicacion();
    String getAutor();
    String getTitulo();
    String getEditorial();

}
