package org.pablojan.gwt.types;


import org.pablojan.gwt.types.local.SMapLocal;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsOptional;
import jsinterop.annotations.JsType;

@JsType(namespace = "swell", name = "Map")
public interface SMap extends SNode {
 
  public static SMap create(@JsOptional Object data) {
    return new SMapLocal();
  } 
  
  public Object get(String key);
  
  @JsIgnore
  public SMap put(String key, SNode value);
  
  public SMap put(String key, Object object) throws IllegalCastException;
  
  public Object remove(String key);
  
  public boolean has(String key);
  
  public String[] keys();
  
}
