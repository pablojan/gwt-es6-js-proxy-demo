package org.pablojan.gwt.client;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

public interface OpenOperation {

  @JsType(isNative = true)
  public interface Options {
    
    @JsProperty(name = "objectId")
    public String getObjectId();    
    
  }
  
  @JsType
  public interface Response {
    
    @JsProperty(name = "data")
    public String getData();
  }
  
}
