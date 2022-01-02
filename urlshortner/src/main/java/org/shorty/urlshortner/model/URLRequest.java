package org.shorty.urlshortner.model;

public class URLRequest {
    private String originalURL;

    public URLRequest(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }
}
