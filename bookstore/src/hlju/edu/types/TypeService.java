package hlju.edu.types;
import hlju.edu.domain.Types;

import java.util.List;
public class TypeService {
	private TypeDao dao = new TypeDao();
	public List<Types> queryAll(){
		return dao.queryAll();
	}
}
