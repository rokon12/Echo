package edu.univdhaka.iit.echo.domain;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.util.UUID;


public class Photo implements Serializable {

    private int id;
    private int version;
    private Blob thumbnail;
    private Blob original;
    private String contentType;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Blob thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Blob getOriginal() {
        return original;
    }

    public void setOriginal(Blob original) {
        this.original = original;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
