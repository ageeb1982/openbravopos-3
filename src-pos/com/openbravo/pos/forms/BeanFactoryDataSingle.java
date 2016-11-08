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

package com.openbravo.pos.forms;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.PreparedSentence;
import com.openbravo.data.loader.SerializerRead;
import com.openbravo.data.loader.Session;
import com.openbravo.pos.admin.PeopleView;
import com.openbravo.pos.admin.ResourcesView;
import com.openbravo.pos.admin.RoleInfo;
import com.openbravo.pos.customers.CustomerInfo;
import com.openbravo.pos.inventory.AttributeSetsEditor;
import com.openbravo.pos.inventory.AttributeUseEditor;
import com.openbravo.pos.inventory.AttributeValuesEditor;
import com.openbravo.pos.inventory.AttributesEditor;
import com.openbravo.pos.inventory.AuxiliarEditor;
import com.openbravo.pos.inventory.CategoriesEditor;
import com.openbravo.pos.inventory.LocationsView;
import com.openbravo.pos.inventory.ProductsWarehousePanel;
import com.openbravo.pos.inventory.StockDiaryEditor;
import com.openbravo.pos.inventory.TaxCategoriesEditor;
import com.openbravo.pos.inventory.TaxCustCategoriesEditor;
import com.openbravo.pos.mant.FloorsEditor;
import com.openbravo.pos.mant.PlacesEditor;
import com.openbravo.pos.panels.JPanelCloseMoney;
import com.openbravo.pos.panels.PaymentsEditor;
import com.openbravo.pos.sales.JProductAttEdit;
import com.openbravo.pos.sales.JProductAttEdit.AttributeInstInfo;
import com.openbravo.pos.sales.SharedTicketInfo;
import com.openbravo.pos.sales.SimpleReceipt;
import com.openbravo.pos.sales.restaurant.JTicketsBagRestaurantRes;
import com.openbravo.pos.thirdparties.ThirdPartiesView;
import com.openbravo.pos.ticket.ProductInfoEdit;
import com.openbravo.pos.ticket.TaxInfo;
import com.openbravo.pos.ticket.TicketInfo;
import com.openbravo.pos.ticket.TicketLineInfo;
import com.openbravo.pos.ticket.TicketTaxInfo;
import com.openbravo.ws.externalsales.Product;

/**
 *
 * @author adrianromero
 */
public abstract class BeanFactoryDataSingle implements BeanFactoryApp {
    protected Session s;
  
    /** Creates a new instance of BeanFactoryData */
    public BeanFactoryDataSingle() {
    }
    
    public abstract void init();

    public void init(AppView app) throws BeanFactoryException {
        this.s = app.getSession();
        init();
    }
    
    public Object getBean() {
        return this;
    }
    
    public final Long getNextId(Class clazz) throws BasicException {
      Long id = null;
      String sequenceName = null;
      if (clazz.equals(AppLocal.class)) {
        sequenceName = "SEQ_APPLICATIONS";
      } else if (clazz.equals(AttributesEditor.class)) {
        sequenceName = "SEQ_ATTRIBUTE";
      } else if (clazz.equals(AttributeInstInfo.class)) {
        sequenceName = "SEQ_ATTRIBUTE_INS";
      } else if (clazz.equals(AttributeSetsEditor.class)) {
        sequenceName = "SEQ_ATTRIBUTE_SET";
      } else if (clazz.equals(JProductAttEdit.class)) {
        sequenceName = "SEQ_ATTRIBUTE_SET_INS";
      } else if (clazz.equals(AttributeUseEditor.class)) {
        sequenceName = "SEQ_ATTRIBUTE_USE";
      } else if (clazz.equals(AttributeValuesEditor.class)) {
        sequenceName = "SEQ_ATTRIBUTE_VAL";
      } else if (clazz.equals(JPanelCloseMoney.class)) {
        sequenceName = "SEQ_CLOSEDCASH";
      } else if (clazz.equals(CategoriesEditor.class)) {
        sequenceName = "SEQ_CATEGORIES";
      } else if (clazz.equals(CustomerInfo.class)) {
        sequenceName = "SEQ_CUSTOMERS";
      } else if (clazz.equals(FloorsEditor.class)) {
        sequenceName = "SEQ_FLOORS";
      } else if (clazz.equals(LocationsView.class)) {
        sequenceName = "SEQ_LOCATIONS";
      } else if (clazz.equals(PaymentsEditor.class)) {
        sequenceName = "SEQ_PAYMENTS";
      } else if (clazz.equals(PeopleView.class)) {
        sequenceName = "SEQ_PEOPLE";
      } else if (clazz.equals(PlacesEditor.class)) {
        sequenceName = "SEQ_PLACES";
      } else if (clazz.equals(ProductInfoEdit.class)) {
        sequenceName = "SEQ_PRODUCTS";
      } else if (clazz.equals(Product.class)) {
        sequenceName = "SEQ_PRODUCTS_CAT";
      } else if (clazz.equals(AuxiliarEditor.class)) {
        sequenceName = "SEQ_PRODUCTS_COM";
      } else if (clazz.equals(SimpleReceipt.class)) {
        sequenceName = "SEQ_RECEIPTS";
      } else if (clazz.equals(ProductInfoEdit.class)) {
        sequenceName = "SEQ_RESERVATIONS";
      } else if (clazz.equals(JTicketsBagRestaurantRes.class)) {
        sequenceName = "SEQ_RESERVATIONS";
      } else if (clazz.equals(ResourcesView.class)) {
        sequenceName = "SEQ_RESOURCES"; // TODO
      } else if (clazz.equals(RoleInfo.class)) {
        sequenceName = "SEQ_ROLES";
      } else if (clazz.equals(SharedTicketInfo.class)) {
        sequenceName = "SEQ_SHARED_TICKETS";
      } else if (clazz.equals(ProductInfoEdit.class)) {
        sequenceName = "SEQ_STOCK_CURRENT"; // TODO
      } else if (clazz.equals(StockDiaryEditor.class)) {
        sequenceName = "SEQ_STOCK_DIARY";
      } else if (clazz.equals(ProductsWarehousePanel.class)) {
        sequenceName = "SEQ_STOCK_LEVEL";
      } else if (clazz.equals(TaxCategoriesEditor.class)) {
        sequenceName = "SEQ_TAX_CATE";
      } else if (clazz.equals(TaxCustCategoriesEditor.class)) {
        sequenceName = "SEQ_TAX_CUST_CATE";
      } else if (clazz.equals(TaxInfo.class)) {
        sequenceName = "SEQ_TAXES";
      } else if (clazz.equals(TicketTaxInfo.class)) {
        sequenceName = "SEQ_TAX_LINES";
      } else if (clazz.equals(ThirdPartiesView.class)) {
        sequenceName = "SEQ_THIRD_PARTIES";
      } else if (clazz.equals(TicketLineInfo.class)) {
        sequenceName = "SEQ_TICKET_LINES";
      } else if (clazz.equals(TicketInfo.class)) {
        sequenceName = "SEQ_RECEIPTS";
      }
      
      id = (Long) new PreparedSentence(s, "SELECT " + sequenceName + ".NEXTVAL FROM DUAL", null,
          new SerializerRead() {
            public Long readValues(DataRead dr) throws BasicException {
              return dr.getLong(1);
            }
          }).find();
      
      return id;
    }
    
}
