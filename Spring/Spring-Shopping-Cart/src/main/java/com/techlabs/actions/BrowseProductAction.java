package com.techlabs.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.entity.Cart;
import com.techlabs.entity.Customer;
import com.techlabs.entity.LineItem;
import com.techlabs.entity.Product;
import com.techlabs.service.CartService;
import com.techlabs.service.CustomerService;
import com.techlabs.service.LineItemService;
import com.techlabs.service.ProductService;
import com.techlabs.viewmodel.ProductViewModel;

public class BrowseProductAction extends ActionSupport implements ModelDriven<ProductViewModel>, SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> userSession = null;
	private ProductService productService = null;
	private LineItemService lineItemService = null;
	private CustomerService custService = null;
	private CartService cartService = null;

	private List<Product> products = null;
	private List<Cart> cartItems = null;
	Map<LineItem, Product> cartProduct = null;
	private ProductViewModel productBean = null;
	private UUID uuid = UUID.randomUUID();
	private String cust_id = "";

	private HttpSession sess = null;

	@Autowired
	public void setService(ProductService pService, LineItemService lService, CustomerService cService,
			CartService cartService) {
		this.productService = pService;
		this.lineItemService = lService;
		this.custService = cService;
		this.cartService = cartService;
	}

	public BrowseProductAction() {

		products = new ArrayList<>();
		cartProduct = new HashMap<>();
		productBean = new ProductViewModel();
		userSession = new HashMap<>();
		cartItems = new ArrayList<>();
	}

	public String execute() {
		products = productService.getProducts();
		System.out.println("from browse products action execute " + products.size());
		productBean.setProductNameValue(productService.getProductsNameValuePair());
//		System.out.println("after");

		// from session
		cust_id = (String) userSession.get("userEmail");

		List<Cart> cartItemFromSession = new ArrayList<>();
		List<Cart> cartItemFromDB = new ArrayList<>();
		cartItemFromDB = this.custService.getCartItemsById(cust_id);

		if (userSession.get("cartitems") != null) {
			cartItemFromSession = (List<Cart>) userSession.get("cartitems");
			cust_id = (String) userSession.get("userEmail");
			System.out.println("From bpa cust_id " + cust_id);

		}

		if (this.cartService.getCartProducts().size() <= 0) {
			cartItems = mergeLineitems(cartItemFromSession, cartItemFromDB);
			this.cartService.setCartProducts(cartItems);
		} else {
			cartItems = this.cartService.getCartProducts();
		}

		System.out.println("Cart items size " + this.cartService.getCartProducts().size());
		System.out.println("Session contains something " + this.cartService.getCartProducts().size());
		productBean.setCartProduct(getProductsForLineItems(cartItems));

		return SUCCESS;

	}

	private List<Cart> mergeLineitems(List<Cart> l1, List<Cart> l2) {
		List<Cart> list = new ArrayList<>();
		System.out.println("l1 is " + l1 == null);

		if (l1 != null) {
			System.out.println("l1 size " + l1.size());
			for (Cart item : l1) {
				list.add(item);
			}

		}

		if (l2 != null) {
			System.out.println("l2 size " + l2.size());
			for (Cart item : l2) {
				list.add(item);
			}
		}

		return list;
	}

	public String addProductToCart() {
		System.out.println("Inside add to product cart");
		List<Cart> cartItemFromSession = new ArrayList<>();
		products = productService.getProducts();
		productBean.setProductNameValue(productService.getProductsNameValuePair());
		cust_id = (String) userSession.get("userEmail");

		// get added product
		System.out.println("Id " + productBean.getProduct_id());
		System.out.println("Quantity " + productBean.getQuantity());
		Product product = productService.getProductById(productBean.getProduct_id());

		if (!(userSession.get("cartitems") == null)) {
			cartItemFromSession = (List<Cart>) userSession.get("cartitems");
			this.cartService.setCartProducts(cartItemFromSession);
		}

		if (!(cartService.isAlreadyInCart(productBean.getProduct_id()))) {
			Customer customer = custService.getCustomerByEmail(cust_id);
			Cart cartObj = new Cart("" + uuid.getMostSignificantBits(), productBean.getQuantity(), product, customer);
			cartService.addToCart(cartObj, cust_id);
			System.out.println("Current customer is " + customer.getEmail());

			customer.setCartProducts(convertToSet(cartService.getCartProducts()));

			// this.custService.saveCustomer(customer);
			userSession.put("cartitems", this.cartService.getCartProducts());
			productBean.setCartProduct(getProductsForLineItems(this.cartService.getCartProducts()));
			return SUCCESS;
		}
		return SUCCESS;
	}

	public Set<Cart> convertToSet(List<Cart> cartItems) {
		Set<Cart> setCartItems = new HashSet<>();
		for (Cart cart : cartItems) {
			setCartItems.add(cart);
		}
		return setCartItems;
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

		System.out.println("before deleting size of list is " + lineItemService.getLineItems().size());
		List<LineItem> updatedLineItems = lineItemService.removeElementById(lid);
		userSession.put("lineitems", updatedLineItems);
		System.out.println("After deleting size of list is " + updatedLineItems.size());
		return SUCCESS;
	}

	private Map<Cart, Product> getProductsForLineItems(List<Cart> cartItems) {
		Map<Cart, Product> cartProducts = new HashMap<>();
		for (Cart item : cartItems) {
			Product p = item.getProduct();
			cartProducts.put(item, productService.getProductById(p.getProduct_id()));
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
