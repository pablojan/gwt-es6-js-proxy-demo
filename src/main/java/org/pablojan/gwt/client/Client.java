package org.pablojan.gwt.client;


import org.pablojan.gwt.client.OpenOperation.Response;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * How to define methods to be used both from Java and JavaScript.
 * 
 * @author pablojan@gmail.com (Pablo Ojanguren)
 *
 */
@JsType(namespace = "swell")
public class Client {

  @JsType(namespace = JsPackage.GLOBAL, name = "console")
  public static class Console {
      public static native void log(String s);
  }
  
  /**
   * Example of a method that can be call from JavaScript and Java
   * 
   * @param options
   * @param callback
   */
  public void open(OpenOperation.Options options, Callback<OpenOperation.Response> callback) {
    Console.log("Open() "+options.getObjectId());
    callback.onError("Here the error code");
    callback.onSuccess(new OpenOperation.Response() {
      
      @Override
      public String getData() {
        return "Here response data";
      }
    });
  }
  
  
  /**
   * Use it to call internally the open() method. 
   * 
   */
  public void call() {
    
    Console.log("Call()");

    open(new OpenOperation.Options() {

      @Override
      public String getObjectId() {      
        return "43254z";
      }
      
    },
     new Callback<OpenOperation.Response>(){

      @Override
      public void onError(String code) {
        Console.log("onError "+code);
      }

      @Override
      public void onSuccess(Response response) {
        Console.log("onSuccess "+response.getData());      
        
      }
      
    });
    
    
  }
  
}
