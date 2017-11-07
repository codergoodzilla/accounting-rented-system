package com.repository;

import com.domain.accounting.AccountingRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRecordRepository extends CrudRepository<AccountingRecord, Integer> {

}
