package hlju.edu.types;
import static hlju.edu.utils.DataSourceUtils.*;

import hlju.edu.domain.Types;
import hlju.edu.utils.QueryRunner;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

public class TypeDao {
	/**
	 * 查询所有图书分类
	 */
	public List<Types> queryAll(){
		String sql = "select * from types";
		QueryRunner run = new QueryRunner(getDatasSource());
		List<Types> types = 
				run.query(sql,new BeanListHandler<Types>(Types.class));
		return types;
	}
}
