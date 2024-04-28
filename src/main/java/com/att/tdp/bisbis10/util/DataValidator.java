package com.att.tdp.bisbis10.util;

import org.springframework.stereotype.Component;

import com.att.tdp.bisbis10.exception.pagination.InvalidPageSizeValueException;
import com.att.tdp.bisbis10.exception.pagination.InvalidPageValueException;

@Component
public class DataValidator {
    public void validatePageData(Integer page, Integer pageSize) {
        if(page != null && page < 0) {
            throw new InvalidPageValueException();
        }
        if(pageSize != null && pageSize < 0) {
            throw new InvalidPageSizeValueException();

        }
    }
}
