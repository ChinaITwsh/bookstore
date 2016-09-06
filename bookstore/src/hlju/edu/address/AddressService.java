package hlju.edu.address;

import hlju.edu.domain.Address;

import java.util.List;

public class AddressService {
	private AddressDao dao = new AddressDao();
	public List<Address> queryAll(String uid){
		return dao.queryAll(uid);
	}
	public Address queryOne(String id){
		return dao.queryOne(id);
	}
}
