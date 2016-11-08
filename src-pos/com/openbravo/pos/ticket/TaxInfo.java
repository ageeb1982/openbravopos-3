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

import java.io.Serializable;
import java.util.Date;

import com.openbravo.data.loader.IKeyed;

/**
 *
 * @author adrianromero
 */
public class TaxInfo implements Serializable, IKeyed {
    
    private static final long serialVersionUID = -2705212098856473043L;
    private Long id;
    private String name;
    private Long taxcategoryid;
    private Date validfrom;
    private Long taxcustcategoryid;
    private Long parentid;
    
    private double rate;
    private boolean cascade;
    private Integer order;
    
    /** Creates new TaxInfo */
    public TaxInfo(Long id, String name, Long taxcategoryid, Date validfrom, Long taxcustcategoryid, Long parentid, double rate, boolean cascade, Integer order) {
        this.id = id;
        this.name = name;
        this.taxcategoryid = taxcategoryid;
        this.validfrom = validfrom;
        this.taxcustcategoryid = taxcustcategoryid;
        this.parentid = parentid;
        
        this.rate = rate;
        this.cascade = cascade;
        this.order = order;
    }
    
    public Long getKey() {
        return id;
    }
    
    public void setID(Long value) {
        id = value;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String value) {
        name = value;
    }

    public Long getTaxCategoryID() {
        return taxcategoryid;
    }
    
    public void setTaxCategoryID(Long value) {
        taxcategoryid = value;
    }

    public Date getValidFrom() {
        return validfrom;
    }

    public Long getTaxCustCategoryID() {
        return taxcustcategoryid;
    }
    
    public void setTaxCustCategoryID(Long value) {
        taxcustcategoryid = value;
    }    

    public Long getParentID() {
        return parentid;
    }
    
    public void setParentID(Long value) {
        parentid = value;
    }
    
    public double getRate() {
        return rate;
    }
    
    public void setRate(double value) {
        rate = value;
    }

    public boolean isCascade() {
        return cascade;
    }
    
    public void setCascade(boolean value) {
        cascade = value;
    }
    
    public Integer getOrder() {
        return order;
    }
    
    public Integer getApplicationOrder() {
        return order == null ? Integer.MAX_VALUE : order.intValue();
    }    
    
    public void setOrder(Integer value) {
        order = value;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
