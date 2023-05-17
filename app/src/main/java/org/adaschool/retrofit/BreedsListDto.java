package org.adaschool.retrofit;

import java.util.List;
import java.util.Map;

public class BreedsListDto {
    private String status;
    private List<String> message;



    private List<String> links;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }



    public void setMessage(List<String> message) {
        this.message = message;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}

