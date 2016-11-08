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

package com.openbravo.pos.customers;

import java.io.Serializable;

import com.openbravo.pos.util.StringUtils;

/**
 *
 * @author adrianromero
 */
public class CustomerInfo implements Serializable {

  private static final long serialVersionUID = 9083257536541L;
  protected Long id;
  protected String searchkey;
  protected Long taxid;
  protected String name;

  /** Creates a new instance of UserInfoBasic */
  public CustomerInfo(Long id) {
    this.id = id;
    this.searchkey = null;
    this.taxid = null;
    this.name = null;
  }

  public Long getId() {
    return id;
  }

  public Long getTaxid() {
    return taxid;
  }

  public void setTaxid(Long taxid) {
    this.taxid = taxid;
  }

  public String getSearchkey() {
    return searchkey;
  }

  public void setSearchkey(String searchkey) {
    this.searchkey = searchkey;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long printTaxid() {
    // return StringUtils.encodeXML(taxid);
    return taxid;
  }

  public String printName() {
    return StringUtils.encodeXML(name);
  }

  @Override
  public String toString() {
    return getName();
  }
}