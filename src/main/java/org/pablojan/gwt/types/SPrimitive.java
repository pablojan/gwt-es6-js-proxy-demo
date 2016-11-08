package org.pablojan.gwt.types;

import com.google.gwt.core.client.JavaScriptObject;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;

@JsType(namespace = "swell", name = "Primitive")
public class SPrimitive implements SNode {

  private static final int TYPE_INT = 1;
  private static final int TYPE_DOUBLE = 2;
  private static final int TYPE_STRING = 3;
  private static final int TYPE_BOOL = 4;
  private static final int TYPE_JSO = 5;

  private final int type;
  private final int intValue;
  private final double doubleValue;
  private final String stringValue;
  private final Boolean boolValue;
  private final JavaScriptObject jsoValue;

  @JsIgnore
  public SPrimitive(int value) {
    type = TYPE_INT;
    intValue = value;
    doubleValue = Double.NaN;
    stringValue = null;
    boolValue = null;
    jsoValue = null;
  }

  @JsIgnore
  public SPrimitive(double value) {
    type = TYPE_DOUBLE;
    intValue = Integer.MAX_VALUE;
    doubleValue = value;
    stringValue = null;
    boolValue = null;
    jsoValue = null;

  }

  @JsIgnore
  public SPrimitive(String value) {
    type = TYPE_STRING;
    intValue = Integer.MAX_VALUE;
    doubleValue = Double.NaN;
    stringValue = value;
    boolValue = null;
    jsoValue = null;
  }

  @JsIgnore
  public SPrimitive(boolean value) {
    type = TYPE_BOOL;
    intValue = Integer.MAX_VALUE;
    doubleValue = Double.NaN;
    stringValue = null;
    boolValue = value;
    jsoValue = null;
  }

  @JsIgnore
  public SPrimitive(JavaScriptObject value) {
    type = TYPE_JSO;
    intValue = Integer.MAX_VALUE;
    doubleValue = Double.NaN;
    stringValue = null;
    boolValue = null;
    jsoValue = value;
  }

 
  public int getType() {
    return type;
  }

  public Object getObject() {

    if (type == TYPE_STRING)
      return stringValue;

    if (type == TYPE_INT)
      return intValue;

    if (type == TYPE_DOUBLE)
      return doubleValue;

    if (type == TYPE_BOOL)
      return boolValue;

    if (type == TYPE_JSO)
      return jsoValue;

    throw new IllegalCastException("Error casting to Object");
  }

}
