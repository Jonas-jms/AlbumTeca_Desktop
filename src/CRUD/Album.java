package CRUD;

public abstract class Album
{ 
    protected String album="",artista="",genero="";
    protected int ID_artista,ID_genero;

    public String getAlbum()
    { return album; }

    public String getArtista()
    { return artista; }

    public String getGenero()
    { return genero; }
    
    public void setArtista(String artista)
    { 
        if(artista.length()>0)
        this.artista=artista;
    }

    public void setGenero(String genero)
    { 
        if(genero.length()>0)
        this.genero=genero;
    }
    
    public void setAlbum(String album)
    { 
        if(album.length()>0)
        this.album=album;
    }
}