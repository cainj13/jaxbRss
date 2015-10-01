package org.semper.reformanda.syndication.util;

import org.semper.reformanda.syndication.rss.itunes.BlockValue;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BlockValueTypeAdapter extends XmlAdapter<String, BlockValue> {

    @Override
    public BlockValue unmarshal(final String blockValueString) throws Exception {
        return BlockValue.fromText(blockValueString);
    }

    @Override
    public String marshal(BlockValue blockValue) throws Exception {
        // Since "yes" is the only value that has effect, don't marshal otherwise.
        return BlockValue.YES == blockValue ? blockValue.toString() : null;
    }
}