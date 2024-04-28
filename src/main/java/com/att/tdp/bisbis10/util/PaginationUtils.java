package com.att.tdp.bisbis10.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.att.tdp.bisbis10.exception.pagination.InvalidPageSizeValueException;
import com.att.tdp.bisbis10.exception.pagination.InvalidPageValueException;

@Component
public class PaginationUtils {
    static private Integer DEFAULT_PAGE_SIZE = 10;

    public Pageable createPageable(Integer page, Integer pageSize) {
        validatePageData(page, pageSize);

        return PageRequest.of(
            page == null ? 0 : page, 
            pageSize == null ? DEFAULT_PAGE_SIZE : pageSize
        );
    }

    public void validatePageData(Integer page, Integer pageSize) {
        if(page != null && page < 0) {
            throw new InvalidPageValueException();
        }
        if(pageSize != null && pageSize < 0) {
            throw new InvalidPageSizeValueException();

        }
    }
}
