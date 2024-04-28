package com.att.tdp.bisbis10.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaginationUtils {
    static private Integer DEFAULT_PAGE_SIZE = 10;
    private final DataValidator dataValidator;

    @Autowired
    public PaginationUtils(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }


    public Pageable createPageable(Integer page, Integer pageSize) {
        dataValidator.validatePageData(page, pageSize);

        return PageRequest.of(
            page == null ? 0 : page, 
            pageSize == null ? DEFAULT_PAGE_SIZE : pageSize
        );
    }
}
