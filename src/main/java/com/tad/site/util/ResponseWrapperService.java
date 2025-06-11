package com.tad.site.util;

import java.util.List;

import com.tad.site.util.responseType.ResponseWrapper;

public interface ResponseWrapperService {
    ResponseWrapper<String> wrapperCreate(int code, String message);
    <T> ResponseWrapper<T> wrapperCreate(int code, String message, List<T> item);
    ResponseWrapper<String> errorCreate(int code, String message);
}
