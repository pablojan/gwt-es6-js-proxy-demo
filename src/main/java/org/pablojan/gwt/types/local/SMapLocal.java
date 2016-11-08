package org.pablojan.gwt.types.local;

import java.util.HashMap;
import java.util.Map;

import org.pablojan.gwt.js.HasJsProxy;
import org.pablojan.gwt.js.Proxy;
import org.pablojan.gwt.types.IllegalCastException;
import org.pablojan.gwt.types.SMap;
import org.pablojan.gwt.types.SNode;
import org.pablojan.gwt.types.SPrimitive;
import org.pablojan.gwt.types.SUtils;


public class SMapLocal implements SMap, HasJsProxy {

  public SMapLocal() {
    
  }
  
  private Map<String, SNode> map = new HashMap<String, SNode>();
  private Proxy proxy = null;
  
  @Override
  public Object get(String key) {  
    SNode node = map.get(key);
    if (node instanceof SPrimitive)
      return ((SPrimitive) node).getObject();
    
    return node;
  }

  @Override
  public SMap put(String key, SNode value) {
    map.put(key, value);  
    return this;
  }
  
  @Override
  public SMap put(String key, Object object) throws IllegalCastException {
    SNode node = SUtils.cast(object);
    return put(key, node);
  }

  @Override
  public Object remove(String key) {
    SNode node = map.remove(key);
    if (node instanceof SPrimitive)
      return ((SPrimitive) node).getObject();
    
    return node;
  }
  
  @Override
  public boolean has(String key) {
    return map.containsKey(key);
  }

  @Override
  public String[] keys() {
    return map.keySet().toArray(new String[map.size()]);
  }
  
  @Override
  public Proxy getJsProxy() {
    return proxy;       
  }
  
  @Override
  public void setJsProxy(Proxy proxy) {
    this.proxy = proxy;
  }
  
}
