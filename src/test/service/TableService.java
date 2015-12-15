package test.service;

import java.util.UUID;

import com.cmss.storage.RawTable;


public interface TableService {
	RawTable add(RawTable table);
	RawTable get(UUID id);
	Integer getTableCount();
}
