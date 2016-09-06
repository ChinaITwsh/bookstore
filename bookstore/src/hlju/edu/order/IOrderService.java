package hlju.edu.order;

import hlju.edu.domain.Order;
import hlju.edu.utils.Tx;

public interface IOrderService {
	@Tx
	Order create(Order order);
}