/**
 * Copyright 2015 Joshua Cain
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.semper.reformanda.syndication.util;

import org.semper.reformanda.syndication.rss.MimeType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MimeTypeAdapter extends XmlAdapter<String, MimeType> {

    @Override
    public MimeType unmarshal(final String mimeTypeString) throws Exception {
        return MimeType.fromType(mimeTypeString);
    }

    @Override
    public String marshal(final MimeType mimeType) throws Exception {
        return mimeType.getType();
    }
}