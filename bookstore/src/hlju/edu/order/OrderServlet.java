package hlju.edu.order;

import hlju.edu.address.AddressService;
import hlju.edu.domain.Address;
import hlju.edu.domain.Book;
import hlju.edu.domain.Order;
import hlju.edu.domain.OrderLine;
import hlju.edu.domain.User;
import hlju.edu.utils.BaseServlet;
import hlju.edu.utils.BookStoreUtils;
import hlju.edu.utils.TxProxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderServlet extends BaseServlet {
	private AddressService addressService = new AddressService();
	private IOrderService service = (IOrderService) TxProxy.factory(new OrderService());
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		User user = (User) req.getSession().getAttribute("user");
		List<Address> list = addressService.queryAll(user.getId());
		req.setAttribute("address",list);
		return "order";
	}
	/*
	 * 接收，送货地址
	 * */
	public String create(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String addrId = req.getParameter("addr");
		Address addr = addressService.queryOne(addrId);
		String addrString = addr.getName()+","+addr.getAddr()+","+addr.getTel();
		
		User user = (User) req.getSession().getAttribute("user");
		
		Order order = new Order();
		order.setAddr(addrString);
		order.setCtime(BookStoreUtils.date());
		order.setStat("0");
		order.setId(BookStoreUtils.order(order));
		order.setUid(user.getId());
		
		BigDecimal amount = new BigDecimal(0);
		
		Map<String,Book> car = (Map<String, Book>) req.getSession().getAttribute("car");
		for(Book b:car.values()){
			OrderLine ol = new OrderLine();
			ol.setId(BookStoreUtils.uuid());
			ol.setBookid(b.getId());
			ol.setCont(b.getSum());
			BigDecimal a = new BigDecimal(b.getPrice());
			
			a = a.multiply(new BigDecimal(b.getRebate()));
			a = a.divide(new BigDecimal(1),BigDecimal.ROUND_HALF_UP);
			
			ol.setPrice(a.doubleValue());
			
			a = a.multiply(new BigDecimal(b.getSum()));
			amount=amount.add(a);
			
			order.getLines().add(ol);
		}
		order.setMoney(amount.doubleValue());
		service.create(order);
		req.getSession().removeAttribute("car");
		resp.setCharacterEncoding("Utf-8");
		resp.getWriter().print("下单成功！您的订单号为 :"+order.getId());
		return null;
	}
}
