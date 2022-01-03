package org.shorty.urlshortner.model;

public class ShortURLEntity {
    private String uid;
    private long id;

    public ShortURLEntity(String uid, long id) {
        this.uid = uid;
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
