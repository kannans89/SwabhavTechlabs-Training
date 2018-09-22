package com.shoppingcart.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shoppingcart.model.LineItem;
import com.shoppingcart.model.Product;
import com.shoppingcart.service.LineItemService;
import com.shoppingcart.service.ProductService;
import com.shoppingcart.viewmodel.ProductViewModel;

public class BrowseProductAction extends ActionSupport implements ModelDriven<ProductViewModel>, SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> userSession = null;
	private ProductService productService = null;
	private LineItemService lineItemService = null;
	private List<Product> products = null;
	private List<LineItem> lineItems = null;
	Map<LineItem, Product> cartProduct = null;
	private ProductViewModel productBean = null;
	private UUID uuid = UUID.randomUUID();
	
	public BrowseProductAction() {

		productService = ProductService.getInstance();
		lineItemService = new LineItemService();
		products = new ArrayList<>();
		lineItems = new ArrayList<>();
		cartProduct = new HashMap<>();
		productBean = new ProductViewModel();
		userSession = new HashMap<>();
	}

	public String execute() {
		products = productService.getProducts();
		productBean.setProductNameValue(productService.getProductsNameValuePair());
//		System.out.println("after");

		List<LineItem> lineItemFromSession = new ArrayList<>();
		if (userSession.get("lineitems") == null) {
			System.out.println("Inside executs and session is "+userSession.get("lineitems"));
			return SUCCESS;
		} else {
			
			lineItemFromSession = (List<LineItem>) userSession.get("lineitems");
			System.out.println("Session contains something "+lineItemFromSession.size());
			productBean.setCartProduct(getProductsForLineItems(lineItemFromSession));

			return SUCCESS;
		}
	}

	public String addProductToCart() {
		List<LineItem> lineItemFromSession = new ArrayList<>();
		products = productService.getProducts();
		productBean.setProductNameValue(productService.getProductsNameValuePair());

		if (userSession.get("lineitems") == null) {
			lineItemService.addLineItem(new LineItem("" + uuid.getMostSignificantBits(), productBean.getQuantity(), "",
					productBean.getProduct_id()));
			userSession.put("lineitems", lineItemService.getLineItems());
			List<LineItem> lis = (List<LineItem>) userSession.get("lineitems");
			productBean.setCartProduct(getProductsForLineItems(lineItemService.getLineItems()));
			return SUCCESS;
		} else {
			lineItemFromSession = (List<LineItem>) userSession.get("lineitems");
			lineItemService.setLineItems(lineItemFromSession);
		}
		
		if (lineItemService.isAlreadyInCart(productBean.getProduct_id())) {
			System.out.println("inside addToCart product if and id is " + productBean.getProduct_id());
			lineItemFromSession = (List<LineItem>) userSession.get("lineitems");
			productBean.setCartProduct(getProductsForLineItems(lineItemFromSession));
			return SUCCESS;
		} else {
			lineItemService.addLineItem(new LineItem("" + uuid.getMostSignificantBits(), productBean.getQuantity(), "",
					productBean.getProduct_id()));
			userSession.put("lineitems", lineItemService.getLineItems());
			productBean.setCartProduct(getProductsForLineItems(lineItemService.getLineItems()));
			return SUCCESS;
		}
	}

	public String updateProduct() {
		
		return SUCCESS;
	}
	
	public String deleteProduct() {
		System.out.println("Inside delete product");
		String lid = (String) ServletActionContext.getRequest().getParameter("line_id");
		System.out.println(lid);
		
		List<LineItem> lineitems = (List<LineItem>) userSession.get("lineitems");
		lineItemService.setLineItems(lineitems);
		
		System.out.println("before deleting size of list is "+lineItemService.getLineItems().size());
		List<LineItem> updatedLineItems = lineItemService.removeElementById(lid);
		userSession.put("lineitems", updatedLineItems);
		System.out.println("After deleting size of list is "+updatedLineItems.size());
		return SUCCESS;
	}

	private Map<LineItem, Product> getProductsForLineItems(List<LineItem> lineItems) {
		Map<LineItem, Product> cartProducts = new HashMap<>();
		for (LineItem item : lineItems) {
			cartProducts.put(item, productService.getProductById(item.getProduct_id()));
		}
		return cartProducts;
	}

	public ProductViewModel getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductViewModel productBean) {
		this.productBean = productBean;
	}

	@Override
	public ProductViewModel getModel() {
		return this.productBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}
}
