package org.semper.reformanda.syndication.rss.itunes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcain on 8/6/15.
 */
public class Category {

    private String text;
    // TODO could probably use some validation here around nesting sub-categories too deep.  Could produce invalid feed using this model.
    private List<Category> subcategories;
    // TODO the category "name" element should be an attribute, rather than a text node!

    @XmlAttribute
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement(name = "category")
    public List<Category> getSubcategories() {
        if (subcategories == null) {
            subcategories = new ArrayList();
        }

        return subcategories;
    }
}