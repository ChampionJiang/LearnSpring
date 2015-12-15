package test.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.cmss.storage.RawTable;

import test.domain.Product;

@Service
public class TableServiceImpl implements TableService {

	private Map<UUID, RawTable> tables =
			new HashMap<UUID, RawTable>();
	
	public TableServiceImpl() {
		
	}
	@Override
	public RawTable add(RawTable table) {
		// TODO Auto-generated method stub
		
		UUID id = table.getUUID();
		tables.put(id, table);
		return table;
	}

	@Override
	public RawTable get(UUID id) {
		// TODO Auto-generated method stub
		return tables.get(id);
	}
	@Override
	public Integer getTableCount() {
		// TODO Auto-generated method stub
		return tables.size();
	}

}
