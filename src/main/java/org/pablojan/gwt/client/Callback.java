package org.pablojan.gwt.client;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public interface Callback<T> {

  public void onError(String code);
  public void onSuccess(T response);
  
}
