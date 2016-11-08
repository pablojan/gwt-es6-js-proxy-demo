package org.pablojan.gwt.js.handler;

import org.pablojan.gwt.js.HasJsProxy;
import org.pablojan.gwt.js.Proxy;
import org.pablojan.gwt.types.IllegalCastException;
import org.pablojan.gwt.types.SMap;
import org.pablojan.gwt.types.SNode;
import org.pablojan.gwt.types.SUtils;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;

@JsType(namespace = "swell")
public class SMapProxyHandler extends ProxyHandler {

  @JsIgnore
  public SMapProxyHandler() {
  }
  
  public Object get(SMap target, String property, ProxyHandler reciever) {
    Object node = target.get(property);

    if (node instanceof HasJsProxy) {
      Proxy proxy = ((HasJsProxy) node).getJsProxy();

      if (proxy == null) {
        if (node instanceof SMap) {
          proxy = new Proxy((SNode) node, new SMapProxyHandler());
          ((HasJsProxy) node).setJsProxy(proxy);
        }
      }

      return proxy;

    } else {
      return node;
    }
  }

  public boolean set(SMap target, String property, Object value, ProxyHandler reciever) throws IllegalCastException {        
    target.put(property, SUtils.cast(value));
    return true;
  }
  
}
