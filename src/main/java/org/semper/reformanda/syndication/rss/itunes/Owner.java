package org.semper.reformanda.syndication.rss.itunes;

public class Owner {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Owner setEmail(String email) {
        this.email = email;
        return this;
    }
}