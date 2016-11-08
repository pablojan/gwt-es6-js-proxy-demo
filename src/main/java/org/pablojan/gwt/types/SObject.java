package org.pablojan.gwt.types;


import org.pablojan.gwt.js.Proxy;
import org.pablojan.gwt.js.handler.SMapProxyHandler;
import org.pablojan.gwt.types.local.SMapLocal;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;

@JsType(namespace = "swell", name = "Object")
public class SObject implements SMap {
  
  private SMap delegateMap;

  public static SObject create() {
    return new SObject(new SMapLocal());
  }
  
  @JsIgnore
  public SObject(SMap map) {
    this.delegateMap = map;
  }
  
  @Override
  public Object get(String key) {
    return delegateMap.get(key);
  }

  @JsIgnore
  @Override
  public SMap put(String key, SNode value) {
    delegateMap.put(key, value);
    return this;
  }

  @Override
  public SMap put(String key, Object object) throws IllegalCastException {
    delegateMap.put(key, object);
    return this;
  }

  @Override
  public Object remove(String key) {
    return delegateMap.remove(key);
  }

  
  @Override
  public boolean has(String key) {
    return delegateMap.has(key);
  }

  @Override
  public String[] keys() {
    return delegateMap.keys();
  }

  /**
   * Only GWT
   * <p>
   * Returns a JavaScript proxy providing a pure JavaScript view
   * of the object
   */
  public Object asNative() {
    return new Proxy(delegateMap, new SMapProxyHandler());
  }
}
