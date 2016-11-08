package org.pablojan.gwt.js;

import org.pablojan.gwt.js.handler.ProxyHandler;
import org.pablojan.gwt.types.SNode;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Proxy {

  @JsConstructor
  public Proxy(SNode target, ProxyHandler handler) {    
  }

}
