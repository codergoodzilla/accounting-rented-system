package com.service.accounting;

import com.domain.accounting.AccountingHistory;
import com.domain.accounting.InputAccountingRecord;

import java.util.List;

public interface AccountingRecordService {

    /**
     *
     *
     * @return found ids for all accounting records
     */
    List<Integer> findAll();

    /**
     *
     *
     * @param id
     * @return found accounting record by id
     */
    AccountingHistory findById(int id);

    /**
     *
     *
     * @param record
     * create accounting record
     */
    void create(InputAccountingRecord record);

    /**
     *
     *
     * @param id
     * delete accounting record by id
     */
    void delete(int id);
}
