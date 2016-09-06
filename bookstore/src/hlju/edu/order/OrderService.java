package hlju.edu.order;

import hlju.edu.domain.Order;

public class OrderService implements IOrderService {
	private OrderDao dao = new OrderDao();
	public Order create(Order order){
		return dao.create(order);
	}
}
