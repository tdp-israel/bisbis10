package com.att.tdp.bisbis10.testutils;

public class PaginationTestUtils {

    static public int calcCountInPage(int count, int page, int pageSize) { 
        return Math.max(
            0, 
            Math.min(
                pageSize,
                count - page * pageSize
            )
        );
    }
}
