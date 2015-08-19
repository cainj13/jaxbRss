package org.semper.reformanda.syndication.rss.itunes;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Collection;

/**
 * Created by jcain on 8/6/15.
 */
public class Category {

    private String text;
    // TODO could probably use some validation here around nesting sub-categories too deep.  Could produce invalid feed using this model.
    private Collection<Category> subcategories;
    // TODO the category "name" element should be an attribute, rather than a text node!

    @XmlAttribute
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Collection<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<Category> subcategories) {
        this.subcategories = subcategories;
    }
}