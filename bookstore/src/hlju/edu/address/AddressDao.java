package hlju.edu.address;
import static hlju.edu.utils.DataSourceUtils.*;

import hlju.edu.domain.Address;
import hlju.edu.utils.QueryRunner;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class AddressDao {
	/*
	 * 根据一个人的id，查询这个人的所有地址
	 * */
	public List<Address> queryAll(String uid){
		String sql = "select * from address where uid=?";
		QueryRunner run = new QueryRunner(getDatasSource());
		List<Address> list = 
				run.query(sql,new BeanListHandler<Address>(Address.class),uid);
		return list;
	}
	public Address queryOne(String id){
		String sql = "select * from address where id=?";
		QueryRunner run = new QueryRunner(getDatasSource());
		Address addr = 
				run.query(sql, new BeanHandler<Address>(Address.class),id);
		return addr;
	}
}
