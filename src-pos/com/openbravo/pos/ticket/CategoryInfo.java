//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.
package com.openbravo.pos.ticket;

import java.awt.image.BufferedImage;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.ImageUtils;
import com.openbravo.data.loader.SerializerRead;

/**
 *
 * @author  Adrian
 * @version 
 */
public class CategoryInfo implements IKeyed {

    private static final long serialVersionUID = 8612449444103L;
    private Long m_sID;
    private String m_sName;
    private BufferedImage m_Image;

    /** Creates new CategoryInfo */
    public CategoryInfo(Long id, String name, BufferedImage image) {
        m_sID = id;
        m_sName = name;
        m_Image = image;
    }

    public Long getKey() {
        return m_sID;
    }

    public void setID(Long sID) {
        m_sID = sID;
    }

    public Long getID() {
        return m_sID;
    }

    public String getName() {
        return m_sName;
    }

    public void setName(String sName) {
        m_sName = sName;
    }

    public BufferedImage getImage() {
        return m_Image;
    }

    public void setImage(BufferedImage img) {
        m_Image = img;
    }

    @Override
    public String toString() {
        return m_sName;
    }

    public static SerializerRead getSerializerRead() {
        return new SerializerRead() { public Object readValues(DataRead dr) throws BasicException {
            return new CategoryInfo(dr.getLong(1), dr.getString(2), ImageUtils.readImage(dr.getBytes(3)));
        }};
    }
}
